package mekanism.registration.impl;

import mekanism.registration.WrappedRegistryObject;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class TileEntityTypeRegistryObject<TILE extends BlockEntity> extends WrappedRegistryObject<BlockEntityType<TILE>> {

    public TileEntityTypeRegistryObject(Identifier identifier, BlockEntityType<TILE> registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    public BlockEntityType<TILE> getTileEntityType() {
        return get();
    }
}
