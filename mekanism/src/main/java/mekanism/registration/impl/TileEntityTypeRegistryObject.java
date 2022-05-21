package mekanism.registration.impl;

import mekanism.registration.WrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.NotNull;

public class TileEntityTypeRegistryObject<TILE extends BlockEntity> extends WrappedRegistryObject<BlockEntityType<TILE>> {

    public TileEntityTypeRegistryObject(ResourceLocation identifier, BlockEntityType<TILE> registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    public BlockEntityType<TILE> getTileEntityType() {
        return get();
    }
}
