package mekanism.tools.items;

import net.minecraft.world.item.ItemStack;

public interface IHazGlowEffect {
    int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel);
}
