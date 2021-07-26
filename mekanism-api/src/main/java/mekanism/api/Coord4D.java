package mekanism.api;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

/**
 * Coord4D - an integer-based way to keep track of and perform operations on blocks in a Minecraft-based environment. This also takes in account the dimension the
 * coordinate is in.
 *
 * @author aidancbrady
 */
public class Coord4D {//TODO - V11: Continue working on replacing uses of this with BlockPos/GlobalPos where appropriate

    private final int x;
    private final int y;
    private final int z;
    public final RegistryKey<World> dimension;
    private final int hashCode;

    /**
     * Creates a Coord4D from an entity's position, rounded down.
     *
     * @param entity Entity to create the Coord4D from
     */
    public Coord4D(Entity entity) {
        this(entity.getBlockPos(), entity.getEntityWorld());
    }

    /**
     * Creates a Coord4D from the defined x, y, z, and dimension values.
     *
     * @param x         X coordinate
     * @param y         Y coordinate
     * @param z         Z coordinate
     * @param dimension Dimension ID
     */
    public Coord4D(double x, double y, double z, RegistryKey<World> dimension) {
        this.x = MathHelper.floor(x);
        this.y = MathHelper.floor(y);
        this.z = MathHelper.floor(z);
        this.dimension = dimension;
        this.hashCode = initHashCode();
    }

    /**
     * Creates a Coord4D from the defined position, and world values.
     *
     * @param pos   Position (x, y, z)
     * @param world World
     */
    public Coord4D(BlockPos pos, World world) {//TODO - 1.17: Switch this to taking Vector3i as position
        this(pos, world.getRegistryKey());
    }

    /**
     * Creates a Coord4D from the defined position, and dimension values.
     *
     * @param pos       Position (x, y, z)
     * @param dimension Dimension ID
     */
    public Coord4D(BlockPos pos, RegistryKey<World> dimension) {//TODO - 1.17: Switch this to taking Vector3i as position
        this(pos.getX(), pos.getY(), pos.getZ(), dimension);
    }

    /**
     * Returns a new Coord4D from a defined TileEntity's x, y and z values.
     *
     * @param tile - TileEntity at the location that will represent this Coord4D
     *
     * @return the Coord4D object from the TileEntity
     */
    public static Coord4D get(BlockEntity tile) {//TODO - 1.17: Move this to a constructor or move the other helper constructors to a get method
        return new Coord4D(tile.getPos(), tile.getWorld());
    }

    /**
     * Returns a new Coord4D from a tag compound.
     *
     * @param tag - tag compound to read from
     *
     * @return the Coord4D from the tag compound
     */
    public static Coord4D read(NbtCompound tag) {
        return new Coord4D(tag.getInt(NBTConstants.X), tag.getInt(NBTConstants.Y), tag.getInt(NBTConstants.Z),
              RegistryKey.of(Registry.WORLD_KEY, new Identifier(tag.getString(NBTConstants.DIMENSION))));
    }

    /**
     * Returns a new Coord4D from a PacketBuffer.
     *
     * @param dataStream - data input to read from
     *
     * @return the Coord4D from the data input
     */
    public static Coord4D read(PacketByteBuf dataStream) {
        return new Coord4D(dataStream.readBlockPos(), RegistryKey.of(Registry.WORLD_KEY, dataStream.readIdentifier()));
    }

    /**
     * Gets the X coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the Y coordinate.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets the Z coordinate.
     */
    public int getZ() {
        return this.z;
    }

    public BlockPos getPos() {
        return new BlockPos(x, y, z);
    }

    /**
     * Writes this Coord4D's data to an CompoundNBT.
     *
     * @param nbtTags - tag compound to write to
     *
     * @return the tag compound with this Coord4D's data
     */
    public NbtCompound write(NbtCompound nbtTags) {
        nbtTags.putInt(NBTConstants.X, x);
        nbtTags.putInt(NBTConstants.Y, y);
        nbtTags.putInt(NBTConstants.Z, z);
        nbtTags.putString(NBTConstants.DIMENSION, dimension.getValue().toString());
        return nbtTags;
    }

    /**
     * Writes this Coord4D's data to a PacketBuffer for packet transfer.
     *
     * @param dataStream - the PacketBuffer to add the data to
     */
    public void write(PacketByteBuf dataStream) {
        //Note: We write the position as a block pos over the network so that it can be packed more efficiently
        dataStream.writeBlockPos(getPos());
        dataStream.writeIdentifier(dimension.getValue());
    }

    /**
     * Translates this Coord4D by the defined x, y, and z values.
     *
     * @param x - x value to translate
     * @param y - y value to translate
     * @param z - z value to translate
     *
     * @return translated Coord4D
     */
    public Coord4D translate(int x, int y, int z) {
        return new Coord4D(this.x + x, this.y + y, this.z + z, dimension);
    }

    /**
     * Creates and returns a new Coord4D translated to the defined offsets of the side.
     *
     * @param side - side to translate this Coord4D to
     *
     * @return translated Coord4D
     */
    public Coord4D offset(Direction side) {
        return offset(side, 1);
    }

    /**
     * Creates and returns a new Coord4D translated to the defined offsets of the side by the defined amount.
     *
     * @param side   - side to translate this Coord4D to
     * @param amount - how far to translate this Coord4D
     *
     * @return translated Coord4D
     */
    public Coord4D offset(Direction side, int amount) {
        if (side == null || amount == 0) {
            return this;
        }
        return new Coord4D(x + (side.getOffsetX() * amount), y + (side.getOffsetY() * amount), z + (side.getOffsetZ() * amount), dimension);
    }

    /**
     * Gets the distance to a defined Coord4D.
     *
     * @param obj - the Coord4D to find the distance to
     *
     * @return the distance to the defined Coord4D
     */
    public double distanceTo(Coord4D obj) {
        return Math.sqrt(distanceToSquared(obj));
    }

    /**
     * Gets the distance to a defined Coord4D squared.
     *
     * @param obj the Coord4D to find the distance to
     *
     * @return the squared distance to the defined Coord4D
     */
    public double distanceToSquared(Coord4D obj) {
        int subX = x - obj.x;
        int subY = y - obj.y;
        int subZ = z - obj.z;
        return subX * subX + subY * subY + subZ * subZ;
    }

    @Override
    public String toString() {
        return "[Coord4D: " + x + ", " + y + ", " + z + ", dim=" + dimension.getValue() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Coord4D && ((Coord4D) obj).x == x && ((Coord4D) obj).y == y && ((Coord4D) obj).z == z && ((Coord4D) obj).dimension == dimension;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    private int initHashCode() {
        int code = 1;
        code = 31 * code + x;
        code = 31 * code + y;
        code = 31 * code + z;
        return 31 * code + dimension.hashCode();
    }
}