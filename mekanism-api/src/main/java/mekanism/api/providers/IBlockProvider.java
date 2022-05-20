package mekanism.api.providers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public interface IBlockProvider extends IItemProvider {

    @NotNull
    Block getBlock();

    @Override
    default ResourceLocation getRegistryName() {
        //Make sure to use the block's registry name in case it somehow doesn't match
        return getBlock().getLootTable();
    }

    @Override
    default String getTranslationKey() {
        return getBlock().getDescriptionId();
    }
}