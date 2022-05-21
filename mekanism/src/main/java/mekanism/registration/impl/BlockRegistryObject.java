package mekanism.registration.impl;

import mekanism.api.providers.IBlockProvider;
import mekanism.registration.DoubleWrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BlockRegistryObject<BLOCK extends Block, ITEM extends Item> extends DoubleWrappedRegistryObject<BLOCK, ITEM> implements IBlockProvider {

    public BlockRegistryObject(ResourceLocation identifier, BLOCK blockRegistryObject, ITEM itemRegistryObject) {
        super(identifier, blockRegistryObject, itemRegistryObject);
    }

    @NotNull
    @Override
    public BLOCK getBlock() {
        return getPrimary();
    }

    @NotNull
    @Override
    public ITEM getItem() {
        return getSecondary();
    }
}
