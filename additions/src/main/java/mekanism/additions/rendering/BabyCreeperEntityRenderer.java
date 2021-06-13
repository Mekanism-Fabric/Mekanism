package mekanism.additions.rendering;

import mekanism.additions.entities.BabyCreeperEntity;
import mekanism.additions.models.BabyCreeperEntityModel;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BabyCreeperEntityRenderer extends MobEntityRenderer<BabyCreeperEntity, BabyCreeperEntityModel<BabyCreeperEntity>> {
    private static final Identifier CREEPER_TEXTURES = new Identifier("textures/entity/creeper/creeper.png");

    public BabyCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BabyCreeperEntityModel<>(context.getPart(AdditionsEntityModelLayers.BABY_CREEPER)), 0.5F);
        this.addFeature(new BabyCreeperChargeFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    protected void scale(BabyCreeperEntity entity, MatrixStack matrices, float amount) {
        float fuseTime = entity.getClientFuseTime(amount);
        float h = 1.0F + MathHelper.sin(fuseTime * 100.0F) * fuseTime * 0.01F;
        fuseTime = MathHelper.clamp(fuseTime, 0.0F, 1.0F);
        fuseTime *= fuseTime;
        fuseTime *= fuseTime;
        float i = (1.0F + fuseTime * 0.4F) * h;
        float j = (1.0F + fuseTime * 0.1F) / h;
        matrices.scale(i, j, i);
    }

    @Override
    protected float getAnimationCounter(BabyCreeperEntity entity, float tickDelta) {
        float g = entity.getClientFuseTime(tickDelta);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(g, 0.5F, 1.0F);
    }

    @Override
    public Identifier getTexture(BabyCreeperEntity entity) {
        return CREEPER_TEXTURES;
    }
}
