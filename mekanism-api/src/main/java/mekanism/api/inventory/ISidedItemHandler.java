package mekanism.api.inventory;

import mekanism.api.Action;
import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface ISidedItemHandler  {

    /**
     * The side this {@link ISidedItemHandler} is for. This defaults to null, which is for internal use.
     */
//    @Nullable
//    default Direction getInventorySideFor() {
//        return null;
//    }

    /**
     * Overrides the stack in the given slot. This method is used by the standard Forge helper methods and classes. It is not intended for general use by other mods, and
     * the handler may throw an error if it is called unexpectedly.
     *
     * @param slot  Slot to modify
     * @param stack {@link ItemStack} to set slot to (may be empty).
     * @param side  The side we are interacting with the handler from (null for internal).
     *
     * @throws RuntimeException if the handler is called in a way that the handler was not expecting.
     */
    void setStackInSlot(int slot, ItemStack stack, @Nullable Direction side);

//    @Override
//    default void setItem(int slot, ItemStack stack) {
//        setStackInSlot(slot, stack, getInventorySideFor());
//    }

    /**
     * Returns the number of slots available
     *
     * @param side The side we are interacting with the handler from (null for internal).
     *
     * @return The number of slots available
     */
    int getSlots(@Nullable Direction side);

//    @Override
//    default int getContainerSize() {
//        return getSlots(getInventorySideFor());
//    }

    /**
     * Returns the {@link ItemStack} in a given slot.
     *
     * The result's stack size may be greater than the itemstack's max size.
     *
     * If the result is empty, then the slot is empty.
     *
     * <p>
     * <strong>IMPORTANT:</strong> This {@link ItemStack} <em>MUST NOT</em> be modified. This method is not for altering an inventory's contents. Any implementers who
     * are able to detect modification through this method should throw an exception.
     * </p>
     * <p>
     * <strong><em>SERIOUSLY: DO NOT MODIFY THE RETURNED ITEMSTACK</em></strong>
     * </p>
     *
     * @param slot Slot to query
     * @param side The side we are interacting with the handler from (null for internal).
     *
     * @return {@link ItemStack} in given slot. Empty {@link ItemStack} if the slot is empty.
     *
     * @apiNote <strong>IMPORTANT:</strong> Do not modify this {@link ItemStack}.
     */
    ItemStack getStackInSlot(int slot, @Nullable Direction side);

//    @Override
//    default ItemStack getItem(int slot) {
//        return getStackInSlot(slot, getInventorySideFor());
//    }

    /**
     * <p>
     * Inserts an {@link ItemStack} into the given slot and return the remainder. The {@link ItemStack} <em>should not</em> be modified in this function!
     * </p>
     * @param slot   Slot to insert into.
     * @param stack  {@link ItemStack} to insert. This must not be modified by the item handler.
     * @param side   The side we are interacting with the handler from (null for internal).
     * @param action The action to perform, either {@link Action#EXECUTE} or {@link Action#SIMULATE}
     *
     * @return The remaining {@link ItemStack} that was not inserted (if the entire stack is accepted, then return an empty {@link ItemStack}). May be the same as the
     * input {@link ItemStack} if unchanged, otherwise a new {@link ItemStack}. The returned ItemStack can be safely modified after
     *
     * @implNote The {@link ItemStack} <em>should not</em> be modified in this function!
     */
    ItemStack insertItem(int slot, ItemStack stack, @Nullable Direction side, Action action);

//    @Override
//    default ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
//        return insertItem(slot, stack, getInventorySideFor(), Action.get(!simulate));
//    }

    /**
     * Extracts an {@link ItemStack} from the given slot.
     * <p>
     * The returned value must be empty if nothing is extracted, otherwise its stack size must be less than or equal to {@code amount} and {@link
     * ItemStack#getMaxStackSize()}.
     * </p>
     *
     * @param slot   Slot to extract from.
     * @param amount Amount to extract (may be greater than the current stack's max limit)
     * @param side   The side we are interacting with the handler from (null for internal).
     * @param action The action to perform, either {@link Action#EXECUTE} or {@link Action#SIMULATE}
     *
     * @return {@link ItemStack} extracted from the slot, must be empty if nothing can be extracted. The returned {@link ItemStack} can be safely modified after, so item
     * handlers should return a new or copied stack.
     *
     * @implNote The returned {@link ItemStack} can be safely modified after, so a new or copied stack should be returned.
     */
    ItemStack extractItem(int slot, int amount, @Nullable Direction side, Action action);

//    @Override
//    default ItemStack extractItem(int slot, int amount, boolean simulate) {
//        return extractItem(slot, amount, getInventorySideFor(), Action.get(!simulate));
//    }

    /**
     * Retrieves the maximum stack size allowed to exist in the given slot.
     *
     * @param slot Slot to query.
     * @param side The side we are interacting with the handler from (null for internal).
     *
     * @return The maximum stack size allowed in the slot.
     */
    int getSlotLimit(int slot, @Nullable Direction side);

//    default int getMaxStackSize(int slot) {
//        return getSlotLimit(slot, getInventorySideFor());
//    }

    /**
     * <p>
     * This function re-implements the vanilla function {@link net.minecraft.world.Container#canPlaceItem(int, ItemStack)}. It should be used instead of simulated
     * insertions in cases where the contents and state of the inventory are irrelevant, mainly for the purpose of automation and logic (for instance, testing if a
     * minecart can wait to deposit its items into a full inventory, or if the items in the minecart can never be placed into the inventory and should move on).
     * </p>
     * <ul>
     * <li>isItemValid is false when insertion of the item is never valid.</li>
     * <li>When isItemValid is true, no assumptions can be made and insertion must be simulated case-by-case.</li>
     * <li>The actual items in the inventory, its fullness, or any other state are <strong>not</strong> considered by isItemValid.</li>
     * </ul>
     *
     * @param slot  Slot to query for validity
     * @param stack Stack to test with for validity
     * @param side  The side we are interacting with the handler from (null for internal).
     *
     * @return true if the slot can accept the {@link ItemStack}, not considering the current state of the inventory. false if the slot can never insert the {@link
     * ItemStack} in any situation.
     */
    boolean isItemValid(int slot, ItemStack stack, @Nullable Direction side);

//    @Override
//    default boolean canPlaceItem(int slot, ItemStack stack) {
//        return isItemValid(slot, stack, getInventorySideFor());
//    }
}