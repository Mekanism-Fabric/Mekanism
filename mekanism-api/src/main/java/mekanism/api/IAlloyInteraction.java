package mekanism.api;

import mekanism.api.tier.AlloyTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Implement this class in your TileEntity if it can interact with Mekanism alloys.
 *
 * @author aidancbrady
 */
public interface IAlloyInteraction {

    /**
     * Called when a player right-clicks this block with an alloy.
     *
     * @param player - the player right-clicking the block
     * @param stack  - the stack of alloy being right-clicked
     * @param tier   - the tier of the alloy
     */
    void onAlloyInteraction(PlayerEntity player, ItemStack stack, @NotNull AlloyTier tier);
}