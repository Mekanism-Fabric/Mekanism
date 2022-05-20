package mekanism.additions.rendering;

import mekanism.additions.entities.BabyEndermanEntity;
import mekanism.additions.models.BabyEndermanEntityModel;
import mekanism.additions.registries.AdditionsEntityModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Random;

public class BabyEndermanEntityRenderer extends MobRenderer<BabyEndermanEntity, BabyEndermanEntityModel<BabyEndermanEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/enderman/enderman.png");
    private final Random random = new Random();

    public BabyEndermanEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new BabyEndermanEntityModel<>(context.bakeLayer(AdditionsEntityModelLayers.BABY_ENDERMAN)), 0.5F);
        this.addLayer(new BabyEndermanEyesFeatureRenderer<>(this));
        this.addLayer(new BabyEndermanBlockFeatureRenderer(this));
    }

    @Override
    public void render(BabyEndermanEntity mobEntity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        BlockState blockState = mobEntity.getCarriedBlock();
        BabyEndermanEntityModel<BabyEndermanEntity> babyEndermanEntityModel = this.getModel();
        babyEndermanEntityModel.carrying = blockState != null;
        babyEndermanEntityModel.creepy = mobEntity.isCreepy();
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Vec3 getRenderOffset(BabyEndermanEntity entity, float tickDelta) {
        if (entity.isCreepy()) {
            return new Vec3(this.random.nextGaussian() * 0.02D, 0.0D, this.random.nextGaussian() * 0.02D);
        } else {
            return super.getRenderOffset(entity, tickDelta);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(BabyEndermanEntity entity) {
        return TEXTURE;
    }
}
