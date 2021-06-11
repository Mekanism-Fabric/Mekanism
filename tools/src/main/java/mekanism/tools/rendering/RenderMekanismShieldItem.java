package mekanism.tools.rendering;

import com.mojang.datafixers.util.Pair;
import mekanism.Mekanism;
import mekanism.tools.accessors.BuiltinModelItemRendererAccessor;
import mekanism.tools.accessors.ItemRendererAccessor;
import mekanism.tools.registries.ToolItems;
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
import net.minecraft.util.registry.Registry;

import java.util.List;

public final class RenderMekanismShieldItem {

    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = stack.getItem();
        ShieldTextures textures;
        if (item == ToolItems.BRONZE_SHIELD) {
            textures = ShieldTextures.BRONZE;
        } else if (item == ToolItems.LAPIS_LAZULI_SHIELD) {
            textures = ShieldTextures.LAPIS_LAZULI;
        } else if (item == ToolItems.OSMIUM_SHIELD) {
            textures = ShieldTextures.OSMIUM;
        } else if (item == ToolItems.REFINED_GLOWSTONE_SHIELD) {
            textures = ShieldTextures.REFINED_GLOWSTONE;
        } else if (item == ToolItems.REFINED_OBSIDIAN_SHIELD) {
            textures = ShieldTextures.REFINED_OBSIDIAN;
        } else if (item == ToolItems.STEEL_SHIELD) {
            textures = ShieldTextures.STEEL;
        } else {
            Mekanism.LOGGER.warn("Unknown item for mekanism shield renderer: {}", Registry.ITEM.getId(item));
            return;
        }
        SpriteIdentifier material = textures.getBase();
        ShieldEntityModel shieldModel = getShieldModel();
        matrices.push();
        matrices.scale(1, -1, -1);
        VertexConsumer buffer = material.getSprite().getTextureSpecificVertexConsumer(ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, shieldModel.getLayer(material.getAtlasId()), true, stack.hasGlint()));
        if (stack.getSubTag("BlockEntityTag") != null) {
            shieldModel.getHandle().render(matrices, buffer, light, overlay, 1, 1, 1, 1);
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.getPatternsFromNbt(ShieldItem.getColor(stack), BannerBlockEntity.getPatternListTag(stack));
            BannerBlockEntityRenderer.renderCanvas(matrices, vertexConsumers, light, overlay, shieldModel.getPlate(), material, false, list);
        } else {
            shieldModel.render(matrices, buffer, light, overlay, 1, 1, 1, 1);
        }
        matrices.pop();
    }

    private static ShieldEntityModel getShieldModel() {
        ItemRenderer itemRenderer = client.getItemRenderer();
        BuiltinModelItemRenderer builtinModelItemRenderer = ((ItemRendererAccessor) itemRenderer).getBuiltinModelItemRenderer();
        return ((BuiltinModelItemRendererAccessor) builtinModelItemRenderer).getModelShield();
    }
}
