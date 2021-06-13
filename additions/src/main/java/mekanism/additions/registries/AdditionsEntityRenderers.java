package mekanism.additions.registries;

import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.rendering.BabyCreeperEntityRenderer;
import mekanism.additions.rendering.BabyEndermanEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.StrayEntityRenderer;
import net.minecraft.client.render.entity.WitherSkeletonEntityRenderer;

@SuppressWarnings("UnstableApiUsage")
public final class AdditionsEntityRenderers {

    public static void init() {
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_CREEPER, BabyCreeperEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_ENDERMAN, BabyEndermanEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_SKELETON, SkeletonEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_STRAY, StrayEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(AdditionsEntityTypes.BABY_WITHER_SKELETON, WitherSkeletonEntityRenderer::new);

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
