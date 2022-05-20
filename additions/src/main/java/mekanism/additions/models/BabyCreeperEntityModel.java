package mekanism.additions.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BabyCreeperEntityModel<T extends Entity> extends AgeableListModel<T> {

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leftHindLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;

    public BabyCreeperEntityModel(ModelPart root) {
        this.head = root.getChild(PartNames.HEAD);
        this.body = root.getChild(PartNames.BODY);
        this.rightHindLeg = root.getChild(PartNames.RIGHT_HIND_LEG);
        this.leftHindLeg = root.getChild(PartNames.LEFT_HIND_LEG);
        this.rightFrontLeg = root.getChild(PartNames.RIGHT_FRONT_LEG);
        this.leftFrontLeg = root.getChild(PartNames.LEFT_FRONT_LEG);
    }

    public static LayerDefinition getTexturedModelData(CubeDeformation dilation) {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        //Only real difference between this model and the vanilla creeper model is the "fix" for the head's rotation point
        // the other difference is extending ageable model instead
        modelPartData.addOrReplaceChild(PartNames.HEAD, CubeListBuilder.create().texOffs( 0,  0).addBox(-4.0F, -8.0F, -4.0F, 8.0F,  8.0F, 8.0F, dilation), PartPose.offset(0.0F, 10.0F, -2.0F));
        modelPartData.addOrReplaceChild(PartNames.BODY, CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F,  0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation), PartPose.offset(0.0F,  6.0F,  0.0F));

        CubeListBuilder modelPartBuilder = CubeListBuilder.create().texOffs( 0, 16).addBox(-2.0F,  0.0F, -2.0F, 4.0F,  6.0F, 4.0F, dilation);

        modelPartData.addOrReplaceChild(PartNames.RIGHT_HIND_LEG,  modelPartBuilder, PartPose.offset(-2.0F, 18.0F, 4.0F));
        modelPartData.addOrReplaceChild(PartNames.LEFT_HIND_LEG,   modelPartBuilder, PartPose.offset(2.0F, 18.0F, 4.0F));
        modelPartData.addOrReplaceChild(PartNames.RIGHT_FRONT_LEG, modelPartBuilder, PartPose.offset(-2.0F, 18.0F, -4.0F));
        modelPartData.addOrReplaceChild(PartNames.LEFT_FRONT_LEG,  modelPartBuilder, PartPose.offset(2.0F, 18.0F, -4.0F));

        return LayerDefinition.create(modelData, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.leftHindLeg, this.rightHindLeg, this.leftFrontLeg, this.rightFrontLeg);
    }

    @Override
    public void setupAnim(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = headYaw * ((float)Math.PI / 180F);
        this.rightHindLeg.xRot = Mth.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.leftHindLeg.xRot = Mth.cos(limbAngle * 0.6662F + (float)Math.PI) * 1.4F * limbDistance;
        this.rightFrontLeg.xRot = Mth.cos(limbAngle * 0.6662F + (float)Math.PI) * 1.4F * limbDistance;
        this.leftFrontLeg.xRot = Mth.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
}
