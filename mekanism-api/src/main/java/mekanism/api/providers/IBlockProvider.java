package mekanism.api.providers;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public interface IBlockProvider extends IItemProvider {

    @NotNull
    Block getBlock();

    @Override
    default Identifier getRegistryName() {
        //Make sure to use the block's registry name in case it somehow doesn't match
        return getBlock().getLootTableId();
    }

    @Override
    default String getTranslationKey() {
        return getBlock().getTranslationKey();
    }
}