package mekanism.tools.material;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import net.minecraft.world.item.Tier;

public abstract class VanillaPaxelMaterial implements IPaxelMaterial {

    @NotNull
    public abstract Tier getVanillaTier();

    @NotNull
    public String getRegistryPrefix() {
        return getVanillaTier().toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getPaxelHarvestLevel() {
        return getVanillaTier().getLevel();
    }

    @Override
    public int getPaxelMaxUses() {
        return 2 * getVanillaTier().getUses();
    }

    @Override
    public float getPaxelEfficiency() {
        return getVanillaTier().getSpeed();
    }

    @Override
    public int getPaxelEnchantability() {
        return getVanillaTier().getEnchantmentValue();
    }
}