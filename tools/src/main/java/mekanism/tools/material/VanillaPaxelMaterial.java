package mekanism.tools.material;

import net.minecraft.item.ToolMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public abstract class VanillaPaxelMaterial implements IPaxelMaterial {

    @NotNull
    public abstract ToolMaterial getVanillaTier();

    @NotNull
    public String getRegistryPrefix() {
        return getVanillaTier().toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getPaxelHarvestLevel() {
        return getVanillaTier().getMiningLevel();
    }

    @Override
    public int getPaxelMaxUses() {
        return 2 * getVanillaTier().getDurability();
    }

    @Override
    public float getPaxelEfficiency() {
        return getVanillaTier().getMiningSpeedMultiplier();
    }

    @Override
    public int getPaxelEnchantability() {
        return getVanillaTier().getEnchantability();
    }
}