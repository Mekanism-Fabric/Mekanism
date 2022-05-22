package mekanism.block.interfaces;

import mekanism.registration.impl.TileEntityTypeRegistryObject;
import mekanism.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IHasTileEntity<TILE extends BlockEntity> extends EntityBlock {

    TileEntityTypeRegistryObject<? extends TILE> getTileType();

    default TILE createDummyBlockEntity() {
        return createDummyBlockEntity(((Block) this).defaultBlockState());
    }

    default TILE createDummyBlockEntity(@NotNull BlockState state) {
        return newBlockEntity(BlockPos.ZERO, state);
    }

    @Override
    default TILE newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return getTileType().get().create(pos, state);
    }

    @Nullable
    @Override
    default <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        TileEntityTypeRegistryObject<? extends TILE> type = getTileType();
        return blockEntityType == type.get() ? (BlockEntityTicker<T>) type.getTicker(level.isClientSide) : null;
    }

    default boolean triggerBlockEntityEvent(@NotNull BlockState state, Level level, BlockPos pos, int id, int param) {
        BlockEntity blockEntity = WorldUtils.getTileEntity(level, pos);
        return blockEntity != null && blockEntity.triggerEvent(id, param);
    }
}