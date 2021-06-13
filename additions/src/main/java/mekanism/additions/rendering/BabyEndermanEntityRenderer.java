package mekanism.additions.rendering;

import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class BabyEndermanEntityRenderer extends MobEntityRenderer<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/enderman/enderman.png");
    private final Random random = new Random();

    public BabyEndermanEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BabyEndermanEntityModel<>(context.getPart(AdditionsEntityModelLayers.BABY_ENDERMAN)), 0.5F);
        this.addFeature(new BabyEndermanEyesFeatureRenderer<>(this));
        this.addFeature(new BabyEndermanBlockFeatureRenderer(this));
    }

    @Override
    public void render(BabyEndermanEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        BlockState blockState = mobEntity.getCarriedBlock();
        BabyEndermanEntityModel<BabyEndermanEntity> babyEndermanEntityModel = this.getModel();
        babyEndermanEntityModel.carryingBlock = blockState != null;
        babyEndermanEntityModel.angry = mobEntity.isAngry();
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Vec3d getPositionOffset(BabyEndermanEntity entity, float tickDelta) {
        if (entity.isAngry()) {
            return new Vec3d(this.random.nextGaussian() * 0.02D, 0.0D, this.random.nextGaussian() * 0.02D);
        } else {
            return super.getPositionOffset(entity, tickDelta);
        }
    }

    @Override
    public Identifier getTexture(BabyEndermanEntity entity) {
        return TEXTURE;
    }
}
