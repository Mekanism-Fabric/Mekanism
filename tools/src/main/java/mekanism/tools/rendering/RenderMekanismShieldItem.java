package mekanism.tools.rendering;

import com.mojang.datafixers.util.Pair;
import mekanism.tools.accessors.BuiltinModelItemRendererAccessor;
import mekanism.tools.accessors.ItemRendererAccessor;
import mekanism.tools.items.MekanismShieldItem;
import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BannerBlockEntityRenderer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.DyeColor;

import java.util.*;

@Environment(EnvType.CLIENT)
public final class RenderMekanismShieldItem {

    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final Map<MekanismShieldItem, ShieldTextures> shieldTexturesMap = new HashMap<>();

    public static Set<MekanismShieldItem> initShieldTextureMap() {
        if (shieldTexturesMap.isEmpty()) {
            shieldTexturesMap.put(ToolItems.BRONZE_SHIELD, ShieldTextures.BRONZE);
            shieldTexturesMap.put(ToolItems.LAPIS_LAZULI_SHIELD, ShieldTextures.LAPIS_LAZULI);
            shieldTexturesMap.put(ToolItems.OSMIUM_SHIELD, ShieldTextures.OSMIUM);
            shieldTexturesMap.put(ToolItems.REFINED_GLOWSTONE_SHIELD, ShieldTextures.REFINED_GLOWSTONE);
            shieldTexturesMap.put(ToolItems.REFINED_OBSIDIAN_SHIELD, ShieldTextures.REFINED_OBSIDIAN);
            shieldTexturesMap.put(ToolItems.STEEL_SHIELD, ShieldTextures.STEEL);
        }

        return shieldTexturesMap.keySet();
    }

    private static Optional<ShieldTextures> getShieldTexture(MekanismShieldItem shieldItem) {
        if (shieldTexturesMap.isEmpty() || !shieldTexturesMap.containsKey(shieldItem)) return Optional.empty();

        return Optional.of(shieldTexturesMap.get(shieldItem));
    }


    public static void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int lightLevel, int overlay) {
        Item item = stack.getItem();
        if (!(item instanceof MekanismShieldItem)) return;

        MekanismShieldItem shieldItem = (MekanismShieldItem) item;
        ShieldTextures shieldTexture = getShieldTexture(shieldItem).orElse(null);
        if (shieldTexture == null) return;

        SpriteIdentifier spriteIdentifier = shieldTexture.getBase();
        ShieldEntityModel shieldModel = getShieldModel();
        lightLevel = shieldItem.getCustomLightLevel(stack, lightLevel);

        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer = spriteIdentifier.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, shieldModel.getLayer(spriteIdentifier.getAtlasId()), true, stack.hasGlint()));
        shieldModel.getHandle().render(matrices, vertexConsumer, lightLevel, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        if (stack.getSubTag("BlockEntityTag") != null) {
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.getPatternsFromNbt(ShieldItem.getColor(stack), BannerBlockEntity.getPatternListTag(stack));
            BannerBlockEntityRenderer.renderCanvas(matrices, vertexConsumers, lightLevel, overlay, shieldModel.getPlate(), spriteIdentifier, false, list, stack.hasGlint());
        } else {
            shieldModel.getPlate().render(matrices, vertexConsumer, lightLevel, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        matrices.pop();
    }

    private static ShieldEntityModel getShieldModel() {
        ItemRenderer itemRenderer = client.getItemRenderer();
        BuiltinModelItemRenderer builtinModelItemRenderer = ((ItemRendererAccessor) itemRenderer).getBuiltinModelItemRenderer();
        return ((BuiltinModelItemRendererAccessor) builtinModelItemRenderer).getModelShield();
    }
}
