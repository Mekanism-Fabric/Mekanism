package mekanism.registration.impl;

import com.mojang.datafixers.types.Type;
import mekanism.registration.WrappedDeferredRegister;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class TileEntityTypeDeferredRegister extends WrappedDeferredRegister<BlockEntityType<?>> {
    public TileEntityTypeDeferredRegister(String modid) {
        super(modid, Registry.BLOCK_ENTITY_TYPE);
    }

    // Use vanilla BlockEntityFactory?
    public <TILE extends BlockEntity> TileEntityTypeRegistryObject<TILE> register(BlockRegistryObject<?, ?> block, FabricBlockEntityTypeBuilder.Factory<? extends TILE> factory) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, block.getInternalRegistryName());

        //Note: There is no data fixer type as forge does not currently have a way exposing data fixers to mods yet
        return register(block.getInternalRegistryName(), () -> FabricBlockEntityTypeBuilder.<TILE>create(factory::create, block.getBlock()).build(type), TileEntityTypeRegistryObject::new);
    }
}
