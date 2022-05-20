package mekanism.additions.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.additions.entities.BabyCreeperEntity;
import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BabyCreeperEntityRenderer extends MobRenderer<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> {
    private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");

    public BabyCreeperEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new BabyCreeperEntityModel<>(context.bakeLayer(AdditionsEntityModelLayers.BABY_CREEPER)), 0.5F);
        this.addLayer(new BabyCreeperChargeFeatureRenderer(this, context.getModelSet()));
    }

    @Override
    protected void scale(BabyCreeperEntity entity, PoseStack matrices, float amount) {
        float fuseTime = entity.getSwelling(amount);
        float h = 1.0F + Mth.sin(fuseTime * 100.0F) * fuseTime * 0.01F;
        fuseTime = Mth.clamp(fuseTime, 0.0F, 1.0F);
        fuseTime *= fuseTime;
        fuseTime *= fuseTime;
        float i = (1.0F + fuseTime * 0.4F) * h;
        float j = (1.0F + fuseTime * 0.1F) / h;
        matrices.scale(i, j, i);
    }

    @Override
    protected float getAttackAnim(BabyCreeperEntity entity, float tickDelta) {
        float g = entity.getSwelling(tickDelta);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(g, 0.5F, 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(BabyCreeperEntity entity) {
        return CREEPER_TEXTURES;
    }
}
