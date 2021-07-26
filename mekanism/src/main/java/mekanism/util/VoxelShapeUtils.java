package mekanism.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import mekanism.Mekanism;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.data.client.model.VariantSettings.Rotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public final class VoxelShapeUtils {

    private static final Vector3d fromOrigin = new Vector3d(-0.5, -0.5, -0.5);

    /**
     * Prints out an easy to copy paste string representing the cuboid of a shape
     */
    public static void print(double x1, double y1, double z1, double x2, double y2, double z2) {
        Mekanism.LOGGER.info("box({}, {}, {}, {}, {}, {}),", Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2),
              Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));
    }

    /**
     * Prints out a set of strings that make copy pasting easier, for simplifying a voxel shape
     */
    public static void printSimplified(String name, VoxelShape shape) {
        Mekanism.LOGGER.info("Simplified: {}", name);
        shape.simplify().getBoundingBoxes().forEach(box -> print(box.minX * 16, box.minY * 16, box.minZ * 16, box.maxX * 16, box.maxY * 16, box.maxZ * 16));
    }

    /**
     * Rotates an {@link Box} to a specific side, similar to how the block states rotate models.
     *
     * @param box  The {@link Box} to rotate
     * @param side The side to rotate it to.
     *
     * @return The rotated {@link Box}
     */
    public static Box rotate(Box box, Direction side) {
        switch (side) {
            case DOWN:
                return box;
            case UP:
                return new Box(box.minX, -box.minY, -box.minZ, box.maxX, -box.maxY, -box.maxZ);
            case NORTH:
                return new Box(box.minX, -box.minZ, box.minY, box.maxX, -box.maxZ, box.maxY);
            case SOUTH:
                return new Box(-box.minX, -box.minZ, -box.minY, -box.maxX, -box.maxZ, -box.maxY);
            case WEST:
                return new Box(box.minY, -box.minZ, -box.minX, box.maxY, -box.maxZ, -box.maxX);
            case EAST:
                return new Box(-box.minY, -box.minZ, box.minX, -box.maxY, -box.maxZ, box.maxX);
        }
        return box;
    }

    /**
     * Rotates an {@link Box} to a according to a specific rotation.
     *
     * @param box      The {@link Box} to rotate
     * @param rotation The rotation we are performing.
     *
     * @return The rotated {@link Box}
     */
    public static Box rotate(Box box, Rotation rotation) {
        switch (rotation) {
            case R0:
                return box;
            case R90:
                return new Box(-box.minZ, box.minY, box.minX, -box.maxZ, box.maxY, box.maxX);
            case R180:
                return new Box(-box.minX, box.minY, -box.minZ, -box.maxX, box.maxY, -box.maxZ);
            case R270:
                return new Box(box.minZ, box.minY, -box.minX, box.maxZ, box.maxY, -box.maxX);
        }
        return box;
    }

    /**
     * Rotates an {@link Box} to a specific side horizontally. This is a default most common rotation setup as to {@link #rotate(Box, Rotation)}
     *
     * @param box  The {@link Box} to rotate
     * @param side The side to rotate it to.
     *
     * @return The rotated {@link Box}
     */
    public static Box rotateHorizontal(Box box, Direction side) {
        switch (side) {
            case NORTH:
                return rotate(box, Rotation.R0);
            case SOUTH:
                return rotate(box, Rotation.R180);
            case WEST:
                return rotate(box, Rotation.R270);
            case EAST:
                return rotate(box, Rotation.R90);
        }
        return box;
    }

    /**
     * Rotates a {@link VoxelShape} to a specific side, similar to how the block states rotate models.
     *
     * @param shape The {@link VoxelShape} to rotate
     * @param side  The side to rotate it to.
     *
     * @return The rotated {@link VoxelShape}
     */
    public static VoxelShape rotate(VoxelShape shape, Direction side) {
        return rotate(shape, box -> rotate(box, side));
    }

    /**
     * Rotates a {@link VoxelShape} to a according to a specific rotation.
     *
     * @param shape    The {@link VoxelShape} to rotate
     * @param rotation The rotation we are performing.
     *
     * @return The rotated {@link VoxelShape}
     */
    public static VoxelShape rotate(VoxelShape shape, Rotation rotation) {
        return rotate(shape, box -> rotate(box, rotation));
    }

    /**
     * Rotates a {@link VoxelShape} to a specific side horizontally. This is a default most common rotation setup as to {@link #rotate(VoxelShape, Rotation)}
     *
     * @param shape The {@link VoxelShape} to rotate
     * @param side  The side to rotate it to.
     *
     * @return The rotated {@link VoxelShape}
     */
    public static VoxelShape rotateHorizontal(VoxelShape shape, Direction side) {
        return rotate(shape, box -> rotateHorizontal(box, side));
    }

    /**
     * Rotates a {@link VoxelShape} using a specific transformation function for each {@link Box} in the {@link VoxelShape}.
     *
     * @param shape          The {@link VoxelShape} to rotate
     * @param rotateFunction The transformation function to apply to each {@link Box} in the {@link VoxelShape}.
     *
     * @return The rotated {@link VoxelShape}
     */
    public static VoxelShape rotate(VoxelShape shape, UnaryOperator<Box> rotateFunction) {
        List<VoxelShape> rotatedPieces = new ArrayList<>();
        //Explode the voxel shape into bounding boxes
        List<Box> sourceBoundingBoxes = shape.getBoundingBoxes();
        //Rotate them and convert them each back into a voxel shape
        for (Box sourceBoundingBox : sourceBoundingBoxes) {
            //Make the bounding box be centered around the middle, and then move it back after rotating
            rotatedPieces.add(VoxelShapes.cuboid(rotateFunction.apply(sourceBoundingBox.offset(fromOrigin.x, fromOrigin.y, fromOrigin.z))
                  .offset(-fromOrigin.x, -fromOrigin.z, -fromOrigin.z)));
        }
        //return the recombined rotated voxel shape
        return combine(rotatedPieces);
    }

    /**
     * Used for mass combining shapes
     *
     * @param shapes The list of {@link VoxelShape}s to include
     *
     * @return A simplified {@link VoxelShape} including everything that is part of any of the input shapes.
     */
    public static VoxelShape combine(VoxelShape... shapes) {
        return batchCombine(VoxelShapes.empty(), BooleanBiFunction.OR, true, shapes);
    }

    /**
     * Used for mass combining shapes
     *
     * @param shapes The collection of {@link VoxelShape}s to include
     *
     * @return A simplified {@link VoxelShape} including everything that is part of any of the input shapes.
     */
    public static VoxelShape combine(Collection<VoxelShape> shapes) {
        return batchCombine(VoxelShapes.empty(), BooleanBiFunction.OR, true, shapes);
    }

    /**
     * Used for cutting shapes out of a full cube
     *
     * @param shapes The list of {@link VoxelShape}s to cut out
     *
     * @return A {@link VoxelShape} including everything that is not part of any of the input shapes.
     */
    public static VoxelShape exclude(VoxelShape... shapes) {
        return batchCombine(VoxelShapes.fullCube(), BooleanBiFunction.ONLY_FIRST, true, shapes);
    }

    /**
     * Used for mass combining shapes using a specific {@link BooleanBiFunction} and a given start shape.
     *
     * @param initial  The {@link VoxelShape} to start with
     * @param function The {@link BooleanBiFunction} to perform
     * @param simplify True if the returned shape should run {@link VoxelShape#simplify()}, False otherwise
     * @param shapes   The collection of {@link VoxelShape}s to include
     *
     * @return A {@link VoxelShape} based on the input parameters.
     *
     * @implNote We do not do any simplification until after combining all the shapes, and then only if the {@code simplify} is True. This is because there is a
     * performance hit in calculating the simplified shape each time if we still have more changers we are making to it.
     */
    public static VoxelShape batchCombine(VoxelShape initial, BooleanBiFunction function, boolean simplify, Collection<VoxelShape> shapes) {
        VoxelShape combinedShape = initial;
        for (VoxelShape shape : shapes) {
            combinedShape = VoxelShapes.combine(combinedShape, shape, function);
        }
        return simplify ? combinedShape.simplify() : combinedShape;
    }

    /**
     * Used for mass combining shapes using a specific {@link BooleanBiFunction} and a given start shape.
     *
     * @param initial  The {@link VoxelShape} to start with
     * @param function The {@link BooleanBiFunction} to perform
     * @param simplify True if the returned shape should run {@link VoxelShape#simplify()}, False otherwise
     * @param shapes   The list of {@link VoxelShape}s to include
     *
     * @return A {@link VoxelShape} based on the input parameters.
     *
     * @implNote We do not do any simplification until after combining all the shapes, and then only if the {@code simplify} is True. This is because there is a
     * performance hit in calculating the simplified shape each time if we still have more changers we are making to it.
     */
    public static VoxelShape batchCombine(VoxelShape initial, BooleanBiFunction function, boolean simplify, VoxelShape... shapes) {
        VoxelShape combinedShape = initial;
        for (VoxelShape shape : shapes) {
            combinedShape = VoxelShapes.combine(combinedShape, shape, function);
        }
        return simplify ? combinedShape.simplify() : combinedShape;
    }

    public static void setShape(VoxelShape shape, VoxelShape[] dest, boolean verticalAxis) {
        setShape(shape, dest, verticalAxis, false);
    }

    public static void setShape(VoxelShape shape, VoxelShape[] dest, boolean verticalAxis, boolean invert) {
        Direction[] dirs = verticalAxis ? EnumUtils.DIRECTIONS : EnumUtils.HORIZONTAL_DIRECTIONS;
        for (Direction side : dirs) {
            dest[verticalAxis ? side.ordinal() : side.ordinal() - 2] = verticalAxis ? VoxelShapeUtils.rotate(shape, invert ? side.getOpposite() : side) : VoxelShapeUtils.rotateHorizontal(shape, side);
        }
    }

    public static void setShape(VoxelShape shape, VoxelShape[] dest) {
        setShape(shape, dest, false, false);
    }
}