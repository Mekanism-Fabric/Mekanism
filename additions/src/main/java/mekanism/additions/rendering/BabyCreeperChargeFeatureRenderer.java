package mekanism.additions.rendering;

import mekanism.additions.entities.BabyCreeperEntity;
import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;

public class BabyCreeperChargeFeatureRenderer extends EnergySwirlLayer<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> {
    private static final ResourceLocation SKIN = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private final BabyCreeperEntityModel<BabyCreeperEntity> model;

    public BabyCreeperChargeFeatureRenderer(RenderLayerParent<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> context, EntityModelSet loader) {
        super(context);
        this.model = new BabyCreeperEntityModel<>(loader.bakeLayer(AdditionsEntityModelLayers.BABY_CREEPER_ARMOR));
    }

    protected float xOffset(float partialAge) {
        return partialAge * 0.01F;
    }

    protected ResourceLocation getTextureLocation() {
        return SKIN;
    }

    protected EntityModel<BabyCreeperEntity> model() {
        return this.model;
    }
}
