package mekanism.api;

import mekanism.api.annotations.INBTSerializable;
import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DataHandlerUtils {

    private DataHandlerUtils() {
    }

    /**
     * Helper to read and load a list of containers from a {@link ListTag}
     */
    public static void readContainers(List<? extends INBTSerializable<CompoundTag>> containers, ListTag storedContainers) {
        readContents(containers, storedContainers, getTagByType(containers));
    }

    /**
     * Helper to read and load a list of containers to a {@link ListTag}
     */
    public static ListTag writeContainers(List<? extends INBTSerializable<CompoundTag>> containers) {
        return writeContents(containers, getTagByType(containers));
    }

    /**
     * Helper to read and load a list of handler contents from a {@link ListTag}
     */
    public static void readContents(List<? extends INBTSerializable<CompoundTag>> contents, ListTag storedContents, String key) {
        int size = contents.size();
        for (int tagCount = 0; tagCount < storedContents.size(); tagCount++) {
            CompoundTag tagCompound = storedContents.getCompound(tagCount);
            byte id = tagCompound.getByte(key);
            if (id >= 0 && id < size) {
                contents.get(id).deserializeNBT(tagCompound);
            }
        }
    }

    /**
     * Helper to read and load a list of handler contents to a {@link ListTag}
     */
    public static ListTag writeContents(List<? extends INBTSerializable<CompoundTag>> contents, String key) {
        ListTag storedContents = new ListTag();
        for (int tank = 0; tank < contents.size(); tank++) {
            CompoundTag tagCompound = contents.get(tank).serializeNBT();
            if (!tagCompound.isEmpty()) {
                tagCompound.putByte(key, (byte) tank);
                storedContents.add(tagCompound);
            }
        }
        return storedContents;
    }

    // keep this only for backwards compat
    private static String getTagByType(List<? extends INBTSerializable<CompoundTag>> containers) {
        if (containers.isEmpty()) {
            return NBTConstants.CONTAINER;
        }
        INBTSerializable<CompoundTag> obj = containers.get(0);
//        if (obj instanceof IChemicalTank || obj instanceof IFluidTank) {
//            return NBTConstants.TANK;
//        } else if (obj instanceof IHeatCapacitor || obj instanceof IEnergyContainer) {
//            return NBTConstants.CONTAINER;
//        } else if (obj instanceof IInventorySlot) {
//            return NBTConstants.SLOT;
//        }
        return NBTConstants.CONTAINER;
    }

    /**
     * Helper to calculate what the maximum id is in a list of contents.
     */
    public static int getMaxId(ListTag storedContents, String key) {
        int maxId = -1;
        for (int tagCount = 0; tagCount < storedContents.size(); tagCount++) {
            byte id = storedContents.getCompound(tagCount).getByte(key);
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }
}