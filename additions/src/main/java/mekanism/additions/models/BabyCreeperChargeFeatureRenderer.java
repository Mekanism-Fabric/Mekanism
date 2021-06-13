package mekanism.additions.models;

import mekanism.additions.entities.BabyCreeperEntity;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.util.Identifier;

public class BabyCreeperChargeFeatureRenderer extends EnergySwirlOverlayFeatureRenderer<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> {
    private static final Identifier SKIN = new Identifier("textures/entity/creeper/creeper_armor.png");
    private final BabyCreeperEntityModel<BabyCreeperEntity> model;

    public BabyCreeperChargeFeatureRenderer(FeatureRendererContext<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> context, EntityModelLoader loader) {
        super(context);
        this.model = new BabyCreeperEntityModel<>(loader.getModelPart(AdditionsEntityModelLayers.BABY_CREEPER_ARMOR));
    }

    protected float getEnergySwirlX(float partialAge) {
        return partialAge * 0.01F;
    }

    protected Identifier getEnergySwirlTexture() {
        return SKIN;
    }

    protected EntityModel<BabyCreeperEntity> getEnergySwirlModel() {
        return this.model;
    }
}
