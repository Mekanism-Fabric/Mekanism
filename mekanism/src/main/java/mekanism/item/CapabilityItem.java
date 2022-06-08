package mekanism.item;

import mekanism.capabilities.ItemCapabilityWrapper.ItemCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CapabilityItem extends Item {

    protected CapabilityItem(Properties properties) {
        super(properties);
    }

    protected void gatherCapabilities(List<ItemCapability> capabilities, ItemStack stack, CompoundTag nbt) {
    }

}