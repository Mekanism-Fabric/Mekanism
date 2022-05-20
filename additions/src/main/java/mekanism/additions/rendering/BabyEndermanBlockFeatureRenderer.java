package mekanism.additions.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.BlockState;

public class BabyEndermanBlockFeatureRenderer extends RenderLayer<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> {

    public BabyEndermanBlockFeatureRenderer(RenderLayerParent<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, BabyEndermanEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BlockState blockState = entity.getCarriedBlock();
        if (blockState != null) {
            matrices.pushPose();
            matrices.translate(0.0D, 0.6875D, -0.75D);
            matrices.mulPose(Vector3f.XP.rotationDegrees(20.0F));
            matrices.mulPose(Vector3f.YP.rotationDegrees(45.0F));
            matrices.translate(0.25D, 0.1875D, 0.25D);
            //Modify scale of block to be 3/4 of what it is for the adult enderman
            float scale = 0.5F * 0.75F;
            matrices.scale(-scale, -scale, scale);
            matrices.mulPose(Vector3f.YP.rotationDegrees(90.0F));
            //Adjust the position of the block to actually look more like it is in the enderman's hands
            matrices.translate(0, -1, 0.25);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockState, matrices, vertexConsumers, light, OverlayTexture.NO_OVERLAY);
            matrices.popPose();
        }
    }
}
