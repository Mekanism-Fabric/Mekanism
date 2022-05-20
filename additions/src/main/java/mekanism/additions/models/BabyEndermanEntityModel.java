package mekanism.additions.models;

import mekanism.additions.entities.BabyEndermanEntity;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.geom.ModelPart;

public class BabyEndermanEntityModel<T extends BabyEndermanEntity> extends EndermanModel<T> {

    public BabyEndermanEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public void setupAnim(T livingEntity, float f, float g, float h, float i, float j) {
        super.setupAnim(livingEntity, f, g, h, i, j);

        //Shift the head to be in the proper place for baby endermen
        head.y += 5.0F;
        if (this.creepy) {
            //Shift the head when angry to only the third the distance it goes up when it is an adult
            head.y += 5.0F / 3;
        }
    }
}
