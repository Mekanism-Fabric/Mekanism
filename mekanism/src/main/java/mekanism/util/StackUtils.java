package mekanism.util;

import java.util.ArrayList;
import java.util.List;

import io.github.fabricators_of_create.porting_lib.transfer.item.ItemHandlerHelper;
import mekanism.api.inventory.IInventorySlot;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StackUtils {

    private StackUtils() {
    }

    public static ItemStack size(ItemStack stack, int size) {
        if (size <= 0 || stack.isEmpty()) {
            return ItemStack.EMPTY;
        }

        ItemStack variant1 = stack.copy();
        variant1.setCount(size);
        return variant1;
    }

    public static List<ItemStack> getMergeRejects(@NotNull List<IInventorySlot> orig, @NotNull List<IInventorySlot> toAdd) {
        List<ItemStack> ret = new ArrayList<>();
        for (int i = 0; i < toAdd.size(); i++) {
            IInventorySlot toAddSlot = toAdd.get(i);
            if (!toAddSlot.isEmpty()) {
                ItemStack reject = getMergeReject(orig.get(i).getStack(), toAddSlot.getStack());
                if (!reject.isEmpty()) {
                    ret.add(reject);
                }
            }
        }
        return ret;
    }

    public static void merge(@NotNull List<IInventorySlot> orig, @NotNull List<IInventorySlot> toAdd) {
        for (int i = 0; i < toAdd.size(); i++) {
            IInventorySlot toAddSlot = toAdd.get(i);
            if (!toAddSlot.isEmpty()) {
                IInventorySlot origSlot = orig.get(i);
                origSlot.setStack(merge(origSlot.getStack(), toAddSlot.getStack()));
            }
        }
    }

    private static ItemStack merge(ItemStack orig, ItemStack toAdd) {
        if (orig.isEmpty()) {
            return toAdd;
        }
        if (toAdd.isEmpty() || !ItemHandlerHelper.canItemStacksStack(orig, toAdd)) {
            return orig;
        }
        return size(orig, Math.min(orig.getMaxStackSize(), orig.getCount() + toAdd.getCount()));
    }

    private static ItemStack getMergeReject(ItemStack orig, ItemStack toAdd) {
        if (orig.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (toAdd.isEmpty() || !ItemHandlerHelper.canItemStacksStack(orig, toAdd)) {
            return orig;
        }
        int newSize = orig.getCount() + toAdd.getCount();
        if (newSize > orig.getMaxStackSize()) {
            return size(orig, newSize - orig.getMaxStackSize());
        }
        return size(orig, newSize);
    }

    /**
     * Get state for placement for a generic item, with our fake player
     *
     * @param stack  the item to place
     * @param pos    where
     * @param player our fake player, usually
     *
     * @return the result of {@link Block#getStateForPlacement(BlockPlaceContext)}, or null if it cannot be placed in that location
     */
    @Nullable
    public static BlockState getStateForPlacement(ItemStack stack, BlockPos pos, Player player) {
        return Block.byItem(stack.getItem()).getStateForPlacement(new BlockPlaceContext(new UseOnContext(player, InteractionHand.MAIN_HAND,
              new BlockHitResult(Vec3.ZERO, Direction.UP, pos, false))));
    }
}