package mekanism.additions.registries;

import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.rendering.BabyCreeperEntityRenderer;
import mekanism.additions.rendering.BabyEndermanEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.StrayEntityRenderer;
import net.minecraft.client.render.entity.WitherSkeletonEntityRenderer;

public final class AdditionsEntityRenderers {

    public static void init() {
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_CREEPER.getEntityType(), BabyCreeperEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_ENDERMAN.getEntityType(), BabyEndermanEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_SKELETON.getEntityType(), SkeletonEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_STRAY.getEntityType(), StrayEntityRenderer::new);
        EntityRendererRegistry.register(AdditionsEntityTypes.BABY_WITHER_SKELETON.getEntityType(), WitherSkeletonEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_CREEPER, () ->
            BabyCreeperEntityModel.getTexturedModelData(Dilation.NONE)
        );
        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_CREEPER_ARMOR, () ->
            BabyCreeperEntityModel.getTexturedModelData(new Dilation(1.0F))
        );
        EntityModelLayerRegistry.registerModelLayer(AdditionsEntityModelLayers.BABY_ENDERMAN,
            BabyEndermanEntityModel::getTexturedModelData
        );
    }

}
