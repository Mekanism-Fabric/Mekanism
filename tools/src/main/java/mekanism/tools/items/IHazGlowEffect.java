package mekanism.tools.items;

import net.minecraft.item.ItemStack;

public interface IHazGlowEffect {
    int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel);
}
