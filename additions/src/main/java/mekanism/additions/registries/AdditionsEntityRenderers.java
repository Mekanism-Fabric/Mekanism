package mekanism.additions.registries;

import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.rendering.BabyCreeperEntityRenderer;
import mekanism.additions.rendering.BabyEndermanEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.StrayRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;

@SuppressWarnings("UnstableApiUsage")
public final class AdditionsEntityRenderers {

    public static void init() {
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_CREEPER, BabyCreeperEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_ENDERMAN, BabyEndermanEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_SKELETON, SkeletonRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_STRAY, StrayRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_WITHER_SKELETON, WitherSkeletonRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_CREEPER, () ->
            BabyCreeperEntityModel.getTexturedModelData(CubeDeformation.NONE)
        );
        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_CREEPER_ARMOR, () ->
            BabyCreeperEntityModel.getTexturedModelData(new CubeDeformation(1.0F))
        );
        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_ENDERMAN,
            BabyEndermanEntityModel::createBodyLayer
        );
    }

}
