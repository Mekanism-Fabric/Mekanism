package mekanism.item.interfaces;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IModeItem {

    /**
     * Changes the current mode of the item
     *
     * @param player               The player who made the mode change.
     * @param stack                The stack to change the mode of
     * @param shift                The amount to shift the mode by, may be negative for indicating the mode should decrease.
     * @param displayChangeMessage {@code true} if a message should be displayed when the mode changes
     */
    void changeMode(@NotNull PlayerEntity player, @NotNull ItemStack stack, int shift, boolean displayChangeMessage);

    default boolean supportsSlotType(ItemStack stack, @NotNull EquipmentSlot slotType) {
        return slotType == EquipmentSlot.MAINHAND || slotType == EquipmentSlot.OFFHAND;
    }

    @Nullable
    default Text getScrollTextComponent(@NotNull ItemStack stack) {
        return null;
    }

    static boolean isModeItem(@NotNull PlayerEntity player, @NotNull EquipmentSlot slotType) {
        return isModeItem(player, slotType, true);
    }

    static boolean isModeItem(@NotNull PlayerEntity player, @NotNull EquipmentSlot slotType, boolean allowRadial) {
        return isModeItem(player.getEquippedStack(slotType), slotType, allowRadial);
    }

    static boolean isModeItem(@NotNull ItemStack stack, @NotNull EquipmentSlot slotType) {
        return isModeItem(stack, slotType, true);
    }

    static boolean isModeItem(@NotNull ItemStack stack, @NotNull EquipmentSlot slotType, boolean allowRadial) {
        return !stack.isEmpty() && stack.getItem() instanceof IModeItem &&
               ((IModeItem) stack.getItem()).supportsSlotType(stack, slotType) &&
               (allowRadial || !(stack.getItem() instanceof IRadialModeItem));
    }
}