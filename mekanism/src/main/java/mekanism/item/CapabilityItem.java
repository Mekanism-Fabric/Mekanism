package mekanism.item;

import mekanism.capabilities.ItemCapabilityWrapper;
import mekanism.capabilities.ItemCapabilityWrapper.ItemCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CapabilityItem extends Item {

    protected CapabilityItem(Properties properties) {
        super(properties);
    }

    protected void gatherCapabilities(List<ItemCapability> capabilities, ItemStack stack, CompoundTag nbt) {
    }

    private ItemCapabilityWrapper initCapabilities(ItemStack stack, CompoundTag nbt) {
        List<ItemCapability> capabilities = new ArrayList<>();
        gatherCapabilities(capabilities, stack, nbt);
//        if (capabilities.isEmpty()) {
//            return super.initCapabilities(stack, nbt);
//        }
        return new ItemCapabilityWrapper(stack, capabilities.toArray(ItemCapability[]::new));
    }

}