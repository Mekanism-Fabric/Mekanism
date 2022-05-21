package mekanism.tools.material;

import java.util.Locale;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

public abstract class VanillaPaxelMaterial implements IPaxelMaterial {

    @NotNull
    public abstract Tiers getVanillaTier();

    @NotNull
    public String getRegistryPrefix() {
        return getVanillaTier().name().toLowerCase(Locale.ROOT);
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