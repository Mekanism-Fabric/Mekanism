package mekanism.tools.material.impl.vanilla;

import mekanism.tools.material.VanillaPaxelMaterial;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public class GoldPaxelMaterialDefaults extends VanillaPaxelMaterial {

    @NotNull
    @Override
    public Tiers getVanillaTier() {
        return Tiers.GOLD;
    }

    @Override
    public float getPaxelDamage() {
        return 7;
    }

    @Override
    public String getConfigCommentName() {
        return "Gold";
    }
}