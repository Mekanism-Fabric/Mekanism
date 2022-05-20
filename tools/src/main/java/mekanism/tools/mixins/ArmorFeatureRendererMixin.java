package mekanism.tools.mixins;

import mekanism.tools.items.IHazGlowEffect;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;

@Mixin(HumanoidArmorLayer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> {

    @Shadow @Final private static Map<String, ResourceLocation> ARMOR_TEXTURE_CACHE;

    @ModifyArg(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/feature/ArmorFeatureRenderer;renderArmor(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;ILnet/minecraft/client/render/entity/model/BipedEntityModel;)V"
        ),
        method = "render"
    )
    private int replaceWithGlow(PoseStack matrices, MultiBufferSource vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model) {
        ItemStack itemStack = entity.getItemBySlot(armorSlot);

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
    private void getArmorTexture(ArmorItem item, boolean legs, @Nullable String overlay, CallbackInfoReturnable<ResourceLocation> callbackInfo) {
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

            callbackInfo.setReturnValue(ARMOR_TEXTURE_CACHE.computeIfAbsent(texture, ResourceLocation::new));
        }
    }

}
