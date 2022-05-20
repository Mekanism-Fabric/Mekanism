package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public class StonePaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public Tiers getVanillaTier() {
        return Tiers.STONE;
    }

    @Override
    public float getPaxelDamage() {
        return 8;
    }

    @Override
    public String getConfigCommentName() {
        return "Stone";
    }
}