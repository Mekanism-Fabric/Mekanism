package mekanism.tools.mixins;

import mekanism.tools.items.IHazGlowEffect;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> {

    @Shadow @Final private static Map<String, Identifier> ARMOR_TEXTURE_CACHE;

    @ModifyArg(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/feature/ArmorFeatureRenderer;renderArmor(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;ILnet/minecraft/client/render/entity/model/BipedEntityModel;)V"
        ),
        method = "render"
    )
    private int replaceWithGlow(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model) {
        ItemStack itemStack = entity.getEquippedStack(armorSlot);

        if (itemStack.getItem() instanceof IHazGlowEffect) {
            return ((IHazGlowEffect) itemStack.getItem()).getCustomLightLevel(itemStack, light);
        }

        return light;
    }

    @Inject(
        at = @At("HEAD"),
        method = "getArmorTexture",
        cancellable = true
    )
    private void getArmorTexture(ArmorItem item, boolean legs, @Nullable String overlay, CallbackInfoReturnable<Identifier> callbackInfo) {
        ArmorMaterial material = item.getMaterial();

        if (material instanceof BaseMekanismMaterial) {
            String[] parts = material.getName().split(":");
            String texture = "textures/models/armor/%s_layer_%s.png";
            String s = (legs ? 2 : 1) + (overlay == null ? "" : "_" + overlay);

            if (parts.length > 1) {
                texture = parts[0] + ":" + String.format(texture, parts[1], s);
            } else {
                texture = String.format(texture, parts[0], s);
            }

            callbackInfo.setReturnValue(ARMOR_TEXTURE_CACHE.computeIfAbsent(texture, Identifier::new));
        }
    }

}
