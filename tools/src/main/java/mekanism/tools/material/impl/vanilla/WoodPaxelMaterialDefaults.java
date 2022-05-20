package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public class WoodPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public Tiers getVanillaTier() {
        return Tiers.WOOD;
    }

    @Override
    public float getPaxelDamage() {
        return 7;
    }

    @Override
    public String getConfigCommentName() {
        return "Wood";
    }
}