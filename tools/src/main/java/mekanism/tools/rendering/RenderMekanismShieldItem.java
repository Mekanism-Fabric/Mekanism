package mekanism.tools.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import mekanism.tools.accessors.BuiltinModelItemRendererAccessor;
import mekanism.tools.accessors.ItemRendererAccessor;
import mekanism.tools.items.MekanismShieldItem;
import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import java.util.*;

@Environment(EnvType.CLIENT)
public final class RenderMekanismShieldItem {

    private static final Minecraft client = Minecraft.getInstance();
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


    public static void render(ItemStack stack, ItemTransforms.TransformType mode, PoseStack matrices, MultiBufferSource vertexConsumers, int lightLevel, int overlay) {
        Item item = stack.getItem();
        if (!(item instanceof MekanismShieldItem)) return;

        MekanismShieldItem shieldItem = (MekanismShieldItem) item;
        ShieldTextures shieldTexture = getShieldTexture(shieldItem).orElse(null);
        if (shieldTexture == null) return;

        Material spriteIdentifier = shieldTexture.getBase();
        ShieldModel shieldModel = getShieldModel();
        lightLevel = shieldItem.getCustomLightLevel(stack, lightLevel);

        matrices.pushPose();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer = spriteIdentifier.sprite().wrap(ItemRenderer.getFoilBufferDirect(vertexConsumers, shieldModel.renderType(spriteIdentifier.atlasLocation()), true, stack.hasFoil()));
        shieldModel.handle().render(matrices, vertexConsumer, lightLevel, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        if (stack.getTagElement("BlockEntityTag") != null) {
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
            BannerRenderer.renderPatterns(matrices, vertexConsumers, lightLevel, overlay, shieldModel.plate(), spriteIdentifier, false, list, stack.hasFoil());
        } else {
            shieldModel.plate().render(matrices, vertexConsumer, lightLevel, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        matrices.popPose();
    }

    private static ShieldModel getShieldModel() {
        ItemRenderer itemRenderer = client.getItemRenderer();
        BlockEntityWithoutLevelRenderer builtinModelItemRenderer = ((ItemRendererAccessor) itemRenderer).getBuiltinModelItemRenderer();
        return ((BuiltinModelItemRendererAccessor) builtinModelItemRenderer).getModelShield();
    }
}
