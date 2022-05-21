package mekanism.additions.registries;

import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.rendering.BabyCreeperEntityRenderer;
import mekanism.additions.rendering.BabyEndermanEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.StrayRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;

public final class AdditionsEntityRenderers {

    public static void init() {
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_CREEPER.getEntityType(), BabyCreeperEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_ENDERMAN.getEntityType(), BabyEndermanEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_SKELETON.getEntityType(), SkeletonRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_STRAY.getEntityType(), StrayRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_WITHER_SKELETON.getEntityType(), WitherSkeletonRenderer::new);

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
