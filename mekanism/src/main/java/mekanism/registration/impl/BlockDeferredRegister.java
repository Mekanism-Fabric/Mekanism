package mekanism.registration.impl;

import mekanism.api.providers.IBlockProvider;
import mekanism.registration.DoubleDeferredRegister;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockDeferredRegister extends DoubleDeferredRegister<Block, Item> {

    private final List<IBlockProvider> allBlocks = new ArrayList<>();

    public BlockDeferredRegister(String modid) {
        super(modid, Registry.BLOCK, Registry.ITEM);
    }

    //public BlockRegistryObject<Block, BlockItem> register(String name, AbstractBlock.Settings properties) {
    //    return registerDefaultProperties(name, () -> new Block(BlockStateHelper.applyLightLevelAdjustments(properties)), BlockItem::new);
    //}

    public <BLOCK extends Block> BlockRegistryObject<BLOCK, BlockItem> register(String name, Supplier<? extends BLOCK> blockSupplier) {
        return registerDefaultProperties(name, blockSupplier, BlockItem::new);
    }

    public <BLOCK extends Block, ITEM extends BlockItem> BlockRegistryObject<BLOCK, ITEM> registerDefaultProperties(String name, Supplier<? extends BLOCK> blockSupplier, BiFunction<BLOCK, Item.Settings, ITEM> itemCreator) {
        return register(name, blockSupplier, block -> itemCreator.apply(block, ItemDeferredRegister.getMekBaseProperties()));
    }

    public <BLOCK extends Block, ITEM extends BlockItem> BlockRegistryObject<BLOCK, ITEM> register(String name, Supplier<? extends BLOCK> blockSupplier, Function<BLOCK, ITEM> itemCreator) {
        BlockRegistryObject<BLOCK, ITEM> registeredBlock = register(name, blockSupplier, itemCreator, BlockRegistryObject::new);
        allBlocks.add(registeredBlock);
        return registeredBlock;
    }

    public List<IBlockProvider> getAllBlocks() {
        return allBlocks;
    }
}
