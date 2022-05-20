package mekanism;

import mekanism.registries.MekanismItems;
import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabMekanism extends CreativeModeTab {
    private static final TranslatableComponent GROUP_NAME = new TranslatableComponent("constants.mekanism.mod_name");

    private static int getGroupIndex() {
        ((ItemGroupExtensions) CreativeModeTab.TAB_BREWING).fabric_expandArray();
        return CreativeModeTab.TABS.length - 1;
    }

    public CreativeTabMekanism() {
        super(getGroupIndex(), Mekanism.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return MekanismItems.ATOMIC_ALLOY.getDefaultInstance();
    }

    @Override
    public Component getDisplayName() {
        return GROUP_NAME;
    }
}
