package mekanism.additions.registries;

import mekanism.additions.MekanismAdditions;
import net.minecraft.client.model.geom.ModelLayerLocation;

public final class AdditionsEntityModelLayers {

    public static final ModelLayerLocation BABY_CREEPER = registerMain("baby_creeper", "main");
    public static final ModelLayerLocation BABY_CREEPER_ARMOR = registerMain("baby_creeper", "armor");
    public static final ModelLayerLocation BABY_ENDERMAN = registerMain("baby_enderman", "main");

    private static ModelLayerLocation registerMain(String name, String layer) {
        return new ModelLayerLocation(MekanismAdditions.id(name), layer);
    }
}
