package mekanism.api.providers;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public interface IBlockProvider extends IItemProvider {

    @NotNull
    Block getBlock();

    @Deprecated//TODO - 1.17: Remove this as we don't actually use this
    default boolean blockMatches(ItemStack otherStack) {
        Item item = otherStack.getItem();
        return item instanceof BlockItem && blockMatches(((BlockItem) item).getBlock());
    }

    @Deprecated//TODO - 1.17: Remove this as we don't actually use this
    default boolean blockMatches(Block other) {
        return getBlock() == other;
    }

    @Override
    default Text getRegistryName() {
        //Make sure to use the block's registry name in case it somehow doesn't match
        return getBlock().getName();
    }

    @Override
    default String getTranslationKey() {
        return getBlock().getTranslationKey();
    }
}