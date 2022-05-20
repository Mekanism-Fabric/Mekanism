package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public class DiamondPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public Tiers getVanillaTier() {
        return Tiers.DIAMOND;
    }

    @Override
    public float getPaxelDamage() {
        return 6;
    }

    @Override
    public String getConfigCommentName() {
        return "Diamond";
    }
}