package mekanism.util;

import dev.architectury.core.RegistryEntry;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import it.unimi.dsi.fastutil.bytes.ByteConsumer;
import it.unimi.dsi.fastutil.floats.FloatConsumer;
import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import it.unimi.dsi.fastutil.shorts.ShortConsumer;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import mekanism.api.Coord4D;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class NBTUtils {

    private NBTUtils() {
    }

    public static void setByteIfPresent(CompoundTag nbt, String key, ByteConsumer setter) {
        if (nbt.contains(key, Tag.TAG_BYTE)) {
            setter.accept(nbt.getByte(key));
        }
    }

    public static void setBooleanIfPresent(CompoundTag nbt, String key, BooleanConsumer setter) {
        if (nbt.contains(key, Tag.TAG_BYTE)) {
            setter.accept(nbt.getBoolean(key));
        }
    }

    public static void setShortIfPresent(CompoundTag nbt, String key, ShortConsumer setter) {
        if (nbt.contains(key, Tag.TAG_SHORT)) {
            setter.accept(nbt.getShort(key));
        }
    }

    public static void setIntIfPresent(CompoundTag nbt, String key, IntConsumer setter) {
        if (nbt.contains(key, Tag.TAG_INT)) {
            setter.accept(nbt.getInt(key));
        }
    }

    public static void setLongIfPresent(CompoundTag nbt, String key, LongConsumer setter) {
        if (nbt.contains(key, Tag.TAG_LONG)) {
            setter.accept(nbt.getLong(key));
        }
    }

    public static void setFloatIfPresent(CompoundTag nbt, String key, FloatConsumer setter) {
        if (nbt.contains(key, Tag.TAG_FLOAT)) {
            setter.accept(nbt.getFloat(key));
        }
    }

    public static void setDoubleIfPresent(CompoundTag nbt, String key, DoubleConsumer setter) {
        if (nbt.contains(key, Tag.TAG_DOUBLE)) {
            setter.accept(nbt.getDouble(key));
        }
    }

    public static void setByteArrayIfPresent(CompoundTag nbt, String key, Consumer<byte[]> setter) {
        if (nbt.contains(key, Tag.TAG_BYTE_ARRAY)) {
            setter.accept(nbt.getByteArray(key));
        }
    }

    public static void setStringIfPresent(CompoundTag nbt, String key, Consumer<String> setter) {
        if (nbt.contains(key, Tag.TAG_STRING)) {
            setter.accept(nbt.getString(key));
        }
    }

    public static void setListIfPresent(CompoundTag nbt, String key, int type, Consumer<ListTag> setter) {
        if (nbt.contains(key, Tag.TAG_LIST)) {
            setter.accept(nbt.getList(key, type));
        }
    }

    public static void setCompoundIfPresent(CompoundTag nbt, String key, Consumer<CompoundTag> setter) {
        if (nbt.contains(key, Tag.TAG_COMPOUND)) {
            setter.accept(nbt.getCompound(key));
        }
    }

    public static void setIntArrayIfPresent(CompoundTag nbt, String key, Consumer<int[]> setter) {
        if (nbt.contains(key, Tag.TAG_INT_ARRAY)) {
            setter.accept(nbt.getIntArray(key));
        }
    }

    public static void setLongArrayIfPresent(CompoundTag nbt, String key, Consumer<long[]> setter) {
        if (nbt.contains(key, Tag.TAG_LONG_ARRAY)) {
            setter.accept(nbt.getLongArray(key));
        }
    }

    public static boolean hasOldUUID(CompoundTag nbt, String key) {
        return nbt.contains(key + "Most", Tag.TAG_ANY_NUMERIC) && nbt.contains(key + "Least", Tag.TAG_ANY_NUMERIC);
    }

    public static UUID getOldUUID(CompoundTag nbt, String key) {
        return new UUID(nbt.getLong(key + "Most"), nbt.getLong(key + "Least"));
    }

    public static void setUUIDIfPresent(CompoundTag nbt, String key, Consumer<UUID> setter) {
        if (nbt.hasUUID(key)) {
            setter.accept(nbt.getUUID(key));
        } else if (hasOldUUID(nbt, key)) {
            setter.accept(getOldUUID(nbt, key));
        }
    }

    public static void setUUIDIfPresentElse(CompoundTag nbt, String key, Consumer<UUID> setter, Runnable notPresent) {
        if (nbt.hasUUID(key)) {
            setter.accept(nbt.getUUID(key));
        } else if (hasOldUUID(nbt, key)) {
            setter.accept(getOldUUID(nbt, key));
        } else {
            notPresent.run();
        }
    }

    public static void setBlockPosIfPresent(CompoundTag nbt, String key, Consumer<BlockPos> setter) {
        if (nbt.contains(key, Tag.TAG_COMPOUND)) {
            setter.accept(NbtUtils.readBlockPos(nbt.getCompound(key)));
        }
    }

    public static void setCoord4DIfPresent(CompoundTag nbt, String key, Consumer<Coord4D> setter) {
        if (nbt.contains(key, Tag.TAG_COMPOUND)) {
            setter.accept(Coord4D.read(nbt.getCompound(key)));
        }
    }

//    public static void setFluidStackIfPresent(NbtCompound nbt, String key, Consumer<FluidStack> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(FluidStack.loadFluidStackFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setBoxedChemicalIfPresent(NbtCompound nbt, String key, Consumer<BoxedChemical> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(BoxedChemical.read(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setGasIfPresent(NbtCompound nbt, String key, Consumer<Gas> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(Gas.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setGasStackIfPresent(NbtCompound nbt, String key, Consumer<GasStack> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(GasStack.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setInfuseTypeIfPresent(NbtCompound nbt, String key, Consumer<InfuseType> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(InfuseType.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setInfusionStackIfPresent(NbtCompound nbt, String key, Consumer<InfusionStack> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(InfusionStack.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setPigmentIfPresent(NbtCompound nbt, String key, Consumer<Pigment> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(Pigment.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setPigmentStackIfPresent(NbtCompound nbt, String key, Consumer<PigmentStack> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(PigmentStack.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setSlurryIfPresent(NbtCompound nbt, String key, Consumer<Slurry> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(Slurry.readFromNBT(nbt.getCompound(key)));
//        }
//    }
//
//    public static void setSlurryStackIfPresent(NbtCompound nbt, String key, Consumer<SlurryStack> setter) {
//        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
//            setter.accept(SlurryStack.readFromNBT(nbt.getCompound(key)));
//        }
//    }

    public static void setFloatingLongIfPresent(CompoundTag nbt, String key, FloatingLongConsumer setter) {
        if (nbt.contains(key, Tag.TAG_STRING)) {
            try {
                setter.accept(FloatingLong.parseFloatingLong(nbt.getString(key)));
            } catch (NumberFormatException e) {
                setter.accept(FloatingLong.ZERO);
            }
        }
    }

    public static void setItemStackIfPresent(CompoundTag nbt, String key, Consumer<ItemStack> setter) {
        if (nbt.contains(key, Tag.TAG_COMPOUND)) {
            setter.accept(ItemStack.of(nbt.getCompound(key)));
        }
    }

    public static void setResourceLocationIfPresent(CompoundTag nbt, String key, Consumer<ResourceLocation> setter) {
        if (nbt.contains(key, Tag.TAG_STRING)) {
            ResourceLocation value = ResourceLocation.tryParse(nbt.getString(key));
            if (value != null) {
                setter.accept(value);
            }
        }
    }

    public static void setResourceLocationIfPresentElse(CompoundTag nbt, String key, Consumer<ResourceLocation> setter, Runnable notPresent) {
        if (nbt.contains(key, Tag.TAG_STRING)) {
            ResourceLocation value = ResourceLocation.tryParse(nbt.getString(key));
            if (value == null) {
                notPresent.run();
            } else {
                setter.accept(value);
            }
        }
    }

    public static <REG extends RegistryEntry<REG>> void setRegistryEntryIfPresentElse(CompoundTag nbt, String key, Registry<REG> registry,
                                                                                      Consumer<REG> setter, Runnable notPresent) {
        setResourceLocationIfPresentElse(nbt, key, rl -> {
            REG reg = registry.get(rl);
            if (reg == null) {
                notPresent.run();
            } else {
                setter.accept(reg);
            }
        }, notPresent);
    }

    public static <ENUM extends Enum<ENUM>> void setEnumIfPresent(CompoundTag nbt, String key, Int2ObjectFunction<ENUM> indexLookup, Consumer<ENUM> setter) {
        if (nbt.contains(key, Tag.TAG_INT)) {
            setter.accept(indexLookup.apply(nbt.getInt(key)));
        }
    }

    public static <V extends RegistryEntry<V>> V readRegistryEntry(CompoundTag nbt, String key, Registry<V> registry, V fallback) {
        if (nbt.contains(key, Tag.TAG_STRING)) {
            ResourceLocation rl = ResourceLocation.tryParse(nbt.getString(key));
            if (rl != null) {
                V result = registry.get(rl);
                if (result != null) {
                    return result;
                }
            }
        }
        return fallback;
    }
}