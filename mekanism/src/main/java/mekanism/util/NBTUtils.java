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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class NBTUtils {

    private NBTUtils() {
    }

    public static void setByteIfPresent(NbtCompound nbt, String key, ByteConsumer setter) {
        if (nbt.contains(key, NbtElement.BYTE_TYPE)) {
            setter.accept(nbt.getByte(key));
        }
    }

    public static void setBooleanIfPresent(NbtCompound nbt, String key, BooleanConsumer setter) {
        if (nbt.contains(key, NbtElement.BYTE_TYPE)) {
            setter.accept(nbt.getBoolean(key));
        }
    }

    public static void setShortIfPresent(NbtCompound nbt, String key, ShortConsumer setter) {
        if (nbt.contains(key, NbtElement.SHORT_TYPE)) {
            setter.accept(nbt.getShort(key));
        }
    }

    public static void setIntIfPresent(NbtCompound nbt, String key, IntConsumer setter) {
        if (nbt.contains(key, NbtElement.INT_TYPE)) {
            setter.accept(nbt.getInt(key));
        }
    }

    public static void setLongIfPresent(NbtCompound nbt, String key, LongConsumer setter) {
        if (nbt.contains(key, NbtElement.LONG_TYPE)) {
            setter.accept(nbt.getLong(key));
        }
    }

    public static void setFloatIfPresent(NbtCompound nbt, String key, FloatConsumer setter) {
        if (nbt.contains(key, NbtElement.FLOAT_TYPE)) {
            setter.accept(nbt.getFloat(key));
        }
    }

    public static void setDoubleIfPresent(NbtCompound nbt, String key, DoubleConsumer setter) {
        if (nbt.contains(key, NbtElement.DOUBLE_TYPE)) {
            setter.accept(nbt.getDouble(key));
        }
    }

    public static void setByteArrayIfPresent(NbtCompound nbt, String key, Consumer<byte[]> setter) {
        if (nbt.contains(key, NbtElement.BYTE_ARRAY_TYPE)) {
            setter.accept(nbt.getByteArray(key));
        }
    }

    public static void setStringIfPresent(NbtCompound nbt, String key, Consumer<String> setter) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            setter.accept(nbt.getString(key));
        }
    }

    public static void setListIfPresent(NbtCompound nbt, String key, int type, Consumer<NbtList> setter) {
        if (nbt.contains(key, NbtElement.LIST_TYPE)) {
            setter.accept(nbt.getList(key, type));
        }
    }

    public static void setCompoundIfPresent(NbtCompound nbt, String key, Consumer<NbtCompound> setter) {
        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
            setter.accept(nbt.getCompound(key));
        }
    }

    public static void setIntArrayIfPresent(NbtCompound nbt, String key, Consumer<int[]> setter) {
        if (nbt.contains(key, NbtElement.INT_ARRAY_TYPE)) {
            setter.accept(nbt.getIntArray(key));
        }
    }

    public static void setLongArrayIfPresent(NbtCompound nbt, String key, Consumer<long[]> setter) {
        if (nbt.contains(key, NbtElement.LONG_ARRAY_TYPE)) {
            setter.accept(nbt.getLongArray(key));
        }
    }

    public static boolean hasOldUUID(NbtCompound nbt, String key) {
        return nbt.contains(key + "Most", NbtElement.NUMBER_TYPE) && nbt.contains(key + "Least", NbtElement.NUMBER_TYPE);
    }

    public static UUID getOldUUID(NbtCompound nbt, String key) {
        return new UUID(nbt.getLong(key + "Most"), nbt.getLong(key + "Least"));
    }

    public static void setUUIDIfPresent(NbtCompound nbt, String key, Consumer<UUID> setter) {
        if (nbt.containsUuid(key)) {
            setter.accept(nbt.getUuid(key));
        } else if (hasOldUUID(nbt, key)) {
            setter.accept(getOldUUID(nbt, key));
        }
    }

    public static void setUUIDIfPresentElse(NbtCompound nbt, String key, Consumer<UUID> setter, Runnable notPresent) {
        if (nbt.containsUuid(key)) {
            setter.accept(nbt.getUuid(key));
        } else if (hasOldUUID(nbt, key)) {
            setter.accept(getOldUUID(nbt, key));
        } else {
            notPresent.run();
        }
    }

    public static void setBlockPosIfPresent(NbtCompound nbt, String key, Consumer<BlockPos> setter) {
        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
            setter.accept(NbtHelper.toBlockPos(nbt.getCompound(key)));
        }
    }

    public static void setCoord4DIfPresent(NbtCompound nbt, String key, Consumer<Coord4D> setter) {
        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
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

    public static void setFloatingLongIfPresent(NbtCompound nbt, String key, FloatingLongConsumer setter) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            try {
                setter.accept(FloatingLong.parseFloatingLong(nbt.getString(key)));
            } catch (NumberFormatException e) {
                setter.accept(FloatingLong.ZERO);
            }
        }
    }

    public static void setItemStackIfPresent(NbtCompound nbt, String key, Consumer<ItemStack> setter) {
        if (nbt.contains(key, NbtElement.COMPOUND_TYPE)) {
            setter.accept(ItemStack.fromNbt(nbt.getCompound(key)));
        }
    }

    public static void setResourceLocationIfPresent(NbtCompound nbt, String key, Consumer<Identifier> setter) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            Identifier value = Identifier.tryParse(nbt.getString(key));
            if (value != null) {
                setter.accept(value);
            }
        }
    }

    public static void setResourceLocationIfPresentElse(NbtCompound nbt, String key, Consumer<Identifier> setter, Runnable notPresent) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            Identifier value = Identifier.tryParse(nbt.getString(key));
            if (value == null) {
                notPresent.run();
            } else {
                setter.accept(value);
            }
        }
    }

    public static <REG extends RegistryEntry<REG>> void setRegistryEntryIfPresentElse(NbtCompound nbt, String key, Registry<REG> registry,
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

    public static <ENUM extends Enum<ENUM>> void setEnumIfPresent(NbtCompound nbt, String key, Int2ObjectFunction<ENUM> indexLookup, Consumer<ENUM> setter) {
        if (nbt.contains(key, NbtElement.INT_TYPE)) {
            setter.accept(indexLookup.apply(nbt.getInt(key)));
        }
    }

    public static <V extends RegistryEntry<V>> V readRegistryEntry(NbtCompound nbt, String key, Registry<V> registry, V fallback) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            Identifier rl = Identifier.tryParse(nbt.getString(key));
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