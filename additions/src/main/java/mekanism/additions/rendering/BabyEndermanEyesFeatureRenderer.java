package mekanism.additions.rendering;

import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class BabyEndermanEyesFeatureRenderer<T extends BabyEndermanEntity> extends EyesLayer<T, BabyEndermanEntityModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("textures/entity/enderman/enderman_eyes.png"));

    public BabyEndermanEyesFeatureRenderer(RenderLayerParent<T, BabyEndermanEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}
