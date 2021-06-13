package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public final class AdditionsEntityModelLayers {

    public static final EntityModelLayer BABY_CREEPER = registerMain("baby_creeper", "main");
    public static final EntityModelLayer BABY_CREEPER_ARMOR = registerMain("baby_creeper", "armor");

    private static EntityModelLayer registerMain(String name, String layer) {
        return new EntityModelLayer(MekanismAdditions.id(name), layer);
    }
}
