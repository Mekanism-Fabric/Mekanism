package mekanism.util;

import java.util.UUID;

import dev.architectury.core.RegistryEntry;
import mekanism.api.NBTConstants;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO - V11: Rewrite this into a helper object that gets made for a stack so that we can easier make sure it doesn't add any extra data when we don't want it
// And then for some things we may want when they go back to a full empty state make the NBT go away
public final class ItemDataUtils {

    private ItemDataUtils() {
    }

    @NotNull
    public static NbtCompound getDataMap(ItemStack stack) {
        initStack(stack);
        return stack.getNbt().getCompound(NBTConstants.MEK_DATA);
    }

    @Nullable
    public static NbtCompound getDataMapIfPresent(ItemStack stack) {
        return hasDataTag(stack) ? getDataMap(stack) : null;
    }

    @NotNull
    public static NbtCompound getDataMapIfPresentNN(ItemStack stack) {
        return hasDataTag(stack) ? getDataMap(stack) : new NbtCompound();
    }

    public static boolean hasData(ItemStack stack, String key, int type) {
        return hasDataTag(stack) && getDataMap(stack).contains(key, type);
    }

    public static boolean hasUUID(ItemStack stack, String key) {
        return hasDataTag(stack) && getDataMap(stack).containsUuid(key);
    }

    public static void removeData(ItemStack stack, String key) {
        if (hasDataTag(stack)) {
            NbtCompound dataMap = getDataMap(stack);
            dataMap.remove(key);
            if (dataMap.isEmpty()) {
                //If our data map no longer has any elements after removing a piece of stored data
                // then remove the data tag to make the stack nice and clean again
                stack.getNbt().remove(NBTConstants.MEK_DATA);
            }
        }
    }

    public static <V extends RegistryEntry<V>> V getRegistryEntry(ItemStack stack, String key, Registry<V> registry, V fallback) {
        return hasDataTag(stack) ? NBTUtils.readRegistryEntry(getDataMap(stack), key, registry, fallback) : fallback;
    }

    public static int getInt(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getInt(key) : 0;
    }

    public static long getLong(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getLong(key) : 0;
    }

    public static boolean getBoolean(ItemStack stack, String key) {
        return hasDataTag(stack) && getDataMap(stack).getBoolean(key);
    }

    public static double getDouble(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getDouble(key) : 0;
    }

    public static String getString(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getString(key) : "";
    }

    public static NbtCompound getCompound(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getCompound(key) : new NbtCompound();
    }

    @Nullable
    public static UUID getUniqueID(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getUuid(key) : null;
    }

    public static NbtList getList(ItemStack stack, String key) {
        return hasDataTag(stack) ? getDataMap(stack).getList(key, NbtElement.COMPOUND_TYPE) : new NbtList();
    }

    public static void setInt(ItemStack stack, String key, int i) {
        initStack(stack);
        getDataMap(stack).putInt(key, i);
    }

    public static void setLong(ItemStack stack, String key, long l) {
        initStack(stack);
        getDataMap(stack).putLong(key, l);
    }

    public static void setBoolean(ItemStack stack, String key, boolean b) {
        initStack(stack);
        getDataMap(stack).putBoolean(key, b);
    }

    public static void setDouble(ItemStack stack, String key, double d) {
        initStack(stack);
        getDataMap(stack).putDouble(key, d);
    }

    public static void setString(ItemStack stack, String key, String s) {
        initStack(stack);
        getDataMap(stack).putString(key, s);
    }

    public static void setCompound(ItemStack stack, String key, NbtCompound tag) {
        initStack(stack);
        getDataMap(stack).put(key, tag);
    }

    public static void setUUID(ItemStack stack, String key, UUID uuid) {
        initStack(stack);
        getDataMap(stack).putUuid(key, uuid);
    }

    public static void setList(ItemStack stack, String key, NbtList tag) {
        initStack(stack);
        getDataMap(stack).put(key, tag);
    }

    private static boolean hasDataTag(ItemStack stack) {
        return stack.getNbt() != null && stack.getNbt().contains(NBTConstants.MEK_DATA, NbtElement.COMPOUND_TYPE);
    }

    private static void initStack(ItemStack stack) {
        NbtCompound tag = stack.getOrCreateNbt();
        if (!tag.contains(NBTConstants.MEK_DATA, NbtElement.COMPOUND_TYPE)) {
            tag.put(NBTConstants.MEK_DATA, new NbtCompound());
        }
    }
}