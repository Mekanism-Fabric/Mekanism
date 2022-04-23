package mekanism.registration.impl;

import mekanism.api.providers.IBlockProvider;
import mekanism.registration.DoubleWrappedRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class BlockRegistryObject<BLOCK extends Block, ITEM extends Item> extends DoubleWrappedRegistryObject<BLOCK, ITEM> implements IBlockProvider {

    public BlockRegistryObject(Identifier identifier, BLOCK blockRegistryObject, ITEM itemRegistryObject) {
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
