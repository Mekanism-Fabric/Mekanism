package mekanism.additions.models;

import mekanism.additions.entities.BabyEndermanEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EndermanEntityModel;

public class BabyEndermanEntityModel<T extends BabyEndermanEntity> extends EndermanEntityModel<T> {

    public BabyEndermanEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
        super.setAngles(livingEntity, f, g, h, i, j);

        //Shift the head to be in the proper place for baby endermen
        head.pivotY += 5.0F;
        if (this.angry) {
            //Shift the head when angry to only the third the distance it goes up when it is an adult
            head.pivotY += 5.0F / 3;
        }
    }
}
