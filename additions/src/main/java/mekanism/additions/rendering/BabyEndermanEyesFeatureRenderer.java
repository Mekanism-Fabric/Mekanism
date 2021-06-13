package mekanism.additions.rendering;

import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

public class BabyEndermanEyesFeatureRenderer<T extends BabyEndermanEntity> extends EyesFeatureRenderer<T, BabyEndermanEntityModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("textures/entity/enderman/enderman_eyes.png"));

    public BabyEndermanEyesFeatureRenderer(FeatureRendererContext<T, BabyEndermanEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
