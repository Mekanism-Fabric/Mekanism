package mekanism;

import mekanism.registries.MekanismItems;
import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class CreativeTabMekanism extends ItemGroup {
    private static final TranslatableText GROUP_NAME = new TranslatableText("constants.mekanism.mod_name");

    private static int getGroupIndex() {
        ((ItemGroupExtensions) ItemGroup.BREWING).fabric_expandArray();
        return ItemGroup.GROUPS.length - 1;
    }

    public CreativeTabMekanism() {
        super(getGroupIndex(), Mekanism.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return MekanismItems.ATOMIC_ALLOY.getItemStack();
    }

    @Override
    public Text getDisplayName() {
        return GROUP_NAME;
    }
}
