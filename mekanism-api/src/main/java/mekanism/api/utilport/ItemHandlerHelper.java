package mekanism.api.utilport;

import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.minecraft.item.ItemStack;

public class ItemHandlerHelper {
    public static boolean canItemStacksStack(ItemStack itemStack, ItemStack itemStack1) {
        ItemVariant variant = ItemVariant.of(itemStack);
        return variant.matches(itemStack1);
    }
}
