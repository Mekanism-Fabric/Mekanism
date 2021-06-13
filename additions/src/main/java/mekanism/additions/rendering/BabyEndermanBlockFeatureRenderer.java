package mekanism.additions.rendering;

import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;

public class BabyEndermanBlockFeatureRenderer extends FeatureRenderer<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> {

    public BabyEndermanBlockFeatureRenderer(FeatureRendererContext<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, BabyEndermanEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BlockState blockState = entity.getCarriedBlock();
        if (blockState != null) {
            matrices.push();
            matrices.translate(0.0D, 0.6875D, -0.75D);
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(20.0F));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(45.0F));
            matrices.translate(0.25D, 0.1875D, 0.25D);
            //Modify scale of block to be 3/4 of what it is for the adult enderman
            float scale = 0.5F * 0.75F;
            matrices.scale(-scale, -scale, scale);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
            //Adjust the position of the block to actually look more like it is in the enderman's hands
            matrices.translate(0, -1, 0.25);
            MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(blockState, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV);
            matrices.pop();
        }
    }
}
