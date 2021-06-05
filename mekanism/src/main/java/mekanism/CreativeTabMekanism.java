package mekanism;

import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabMekanism extends ItemGroup {
    private static int getGroupIndex() {
        ((ItemGroupExtensions) ItemGroup.BREWING).fabric_expandArray();
        return ItemGroup.GROUPS.length - 1;
    }

    public CreativeTabMekanism() {
        super(getGroupIndex(), Mekanism.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return ItemStack.EMPTY;
    }
}
