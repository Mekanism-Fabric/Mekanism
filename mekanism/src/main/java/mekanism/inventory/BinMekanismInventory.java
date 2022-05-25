package mekanism.inventory;

import java.util.Collections;
import java.util.List;
import mekanism.api.inventory.IInventorySlot;
import mekanism.block.attribute.Attribute;
import mekanism.inventory.slot.BinInventorySlot;
import mekanism.item.block.ItemBlockBin;
import mekanism.tier.BinTier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BinMekanismInventory extends ItemStackMekanismInventory {

    private BinInventorySlot binSlot;

    private BinMekanismInventory(@NotNull ItemStack stack) {
        super(stack);
    }

    @NotNull
    @Override
    protected List<IInventorySlot> getInitialInventory() {
        binSlot = BinInventorySlot.create(this, Attribute.getTier(((ItemBlockBin) stack.getItem()).getBlock(), BinTier.class));
        return Collections.singletonList(binSlot);
    }

    @Nullable
    public static BinMekanismInventory create(@NotNull ItemStack stack) {
        if (!stack.isEmpty() && stack.getItem() instanceof ItemBlockBin) {
            return new BinMekanismInventory(stack);
        }
        return null;
    }

    public BinInventorySlot getBinSlot() {
        return binSlot;
    }
}