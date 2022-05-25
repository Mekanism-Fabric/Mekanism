package mekanism.resource.ore;

import mekanism.block.BlockOre;
import mekanism.item.block.ItemBlockTooltip;
import mekanism.registration.impl.BlockRegistryObject;

public record OreBlockType(BlockRegistryObject<BlockOre, ItemBlockTooltip<BlockOre>> stone,
                           BlockRegistryObject<BlockOre, ItemBlockTooltip<BlockOre>> deepslate) {

    public BlockOre stoneBlock() {
        return stone.getBlock();
    }

    public BlockOre deepslateBlock() {
        return deepslate.getBlock();
    }
}