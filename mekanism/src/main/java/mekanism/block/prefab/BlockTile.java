package mekanism.block.prefab;

import mekanism.block.attribute.Attributes.AttributeRedstoneEmitter;
import mekanism.block.interfaces.IHasTileEntity;
import mekanism.block.states.IStateFluidLoggable;
import mekanism.content.blocktype.BlockTypeTile;
import mekanism.registration.impl.TileEntityTypeRegistryObject;
import mekanism.tile.base.TileEntityMekanism;
import mekanism.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public class BlockTile<TILE extends TileEntityMekanism, TYPE extends BlockTypeTile<TILE>> extends BlockBase<TYPE> implements IHasTileEntity<TILE> {

    public BlockTile(TYPE type) {
        this(type, UnaryOperator.identity());
    }

    public BlockTile(TYPE type, UnaryOperator<BlockBehaviour.Properties> propertiesModifier) {
        this(type, propertiesModifier.apply(BlockBehaviour.Properties.of(Material.METAL).strength(3.5F, 16).requiresCorrectToolForDrops()));
        //TODO - 1.18: Figure out what the resistance should be (it used to be different in 1.12)
    }

    public BlockTile(TYPE type, BlockBehaviour.Properties properties) {
        super(type, properties);
    }

    @Override
    public TileEntityTypeRegistryObject<TILE> getTileType() {
        return type.getTileType();
    }

//    @NotNull
//    @Override
//    @Deprecated
//    public InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand,
//          @NotNull BlockHitResult hit) {
//        TileEntityMekanism tile = WorldUtils.getTileEntity(TileEntityMekanism.class, world, pos);
//        if (tile == null) {
//            return InteractionResult.PASS;
//        } else if (world.isClientSide) {
//            return genericClientActivated(player, hand);
//        } else if (tile.tryWrench(state, player, hand, hit) != WrenchResult.PASS) {
//            return InteractionResult.SUCCESS;
//        }
//        return type.has(AttributeGui.class) ? tile.openGui(player) : InteractionResult.PASS;
//    }

//    @Override
//    protected float getDestroyProgress(@NotNull BlockState state, @NotNull Player player, @NotNull BlockGetter world, @NotNull BlockPos pos,
//          @Nullable BlockEntity tile) {
//        return MekanismAPI.getSecurityUtils().canAccess(player, tile) ? super.getDestroyProgress(state, player, world, pos, tile) : 0.0F;
//    }

//    @Override
//    public void animateTick(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Random random) {
//        super.animateTick(state, world, pos, random);
//        if (MekanismConfig.client.machineEffects.get() && type.has(AttributeParticleFX.class) && Attribute.isActive(state)) {
//            Direction facing = Attribute.getFacing(state);
//            for (Function<Random, Particle> particleFunction : type.get(AttributeParticleFX.class).getParticleFunctions()) {
//                Particle particle = particleFunction.apply(random);
//                Vec3 particlePos = particle.getPos();
//                if (facing == Direction.WEST) {
//                    particlePos = particlePos.yRot(90);
//                } else if (facing == Direction.EAST) {
//                    particlePos = particlePos.yRot(270);
//                } else if (facing == Direction.NORTH) {
//                    particlePos = particlePos.yRot(180);
//                }
//                particlePos = particlePos.add(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
//                world.addParticle(particle.getType(), particlePos.x, particlePos.y, particlePos.z, 0.0D, 0.0D, 0.0D);
//            }
//        }
//    }

//    @Override
//    @Deprecated
//    public void neighborChanged(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos,
//          boolean isMoving) {
//        if (!world.isClientSide) {
//            TileEntityMekanism tile = WorldUtils.getTileEntity(TileEntityMekanism.class, world, pos);
//            if (tile != null) {
//                tile.onNeighborChange(neighborBlock, neighborPos);
//            }
//        }
//    }

    @Override
    @Deprecated
    public boolean isSignalSource(@NotNull BlockState state) {
        return type.has(AttributeRedstoneEmitter.class);
    }

//    @Override
//    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
//        return type.has(AttributeRedstoneEmitter.class) || super.canConnectRedstone(state, world, pos, side);
//    }

    @Override
    @Deprecated
    public int getSignal(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull Direction side) {
        AttributeRedstoneEmitter<TileEntityMekanism> redstoneEmitter = type.get(AttributeRedstoneEmitter.class);
        if (redstoneEmitter != null) {
            TileEntityMekanism tile = WorldUtils.getTileEntity(TileEntityMekanism.class, world, pos);
            if (tile != null) {
                return redstoneEmitter.getRedstoneLevel(tile);
            }
        }
        return super.getSignal(state, world, pos, side);
    }

    public static class BlockTileModel<TILE extends TileEntityMekanism, BLOCK extends BlockTypeTile<TILE>> extends BlockTile<TILE, BLOCK> implements IStateFluidLoggable {

        public BlockTileModel(BLOCK type) {
            super(type);
        }

        public BlockTileModel(BLOCK type, BlockBehaviour.Properties properties) {
            super(type, properties);
        }
    }
}
