package mekanism.additions.content.blocktype;

import static mekanism.util.VoxelShapeUtils.setShape;
import static net.minecraft.block.Block.createCuboidShape;

import mekanism.util.EnumUtils;
import mekanism.util.VoxelShapeUtils;
import net.minecraft.util.shape.VoxelShape;

public final class BlockShapes {

    private BlockShapes() {
    }

    public static final VoxelShape[] GLOW_PANEL = new VoxelShape[EnumUtils.DIRECTIONS.length];

    static {
        setShape(VoxelShapeUtils.combine(
                createCuboidShape(4, 14, 4, 12, 16, 12),
                createCuboidShape(5, 13.5, 5, 11, 14, 11)
        ), GLOW_PANEL, true);
    }
}
