package mekanism.api.gear.config;

import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;

/**
 * Class representing config data types that modules can make use of.
 *
 * @apiNote Currently Mekanism only has rendering/GUI support for handling {@link ModuleBooleanData} and {@link ModuleEnumData}; if more types are needed either open an
 * issue or create a PR implementing support for them.
 */
public interface ModuleConfigData<TYPE> {

    /**
     * Gets the value of this {@link ModuleConfigData}.
     *
     * @return Current value.
     */
    @NotNull
    TYPE get();

    /**
     * Sets the value of this {@link ModuleConfigData}.
     *
     * @param val Desired value.
     */
    void set(TYPE val);

    /**
     * Attempts to read a {@link ModuleConfigData} of this type with the given name from the given {@link CompoundNBT} and updates the current value to the stored value.
     *
     * @param name Name of the config data to read.
     * @param tag  Stored data.
     */
    void read(String name, CompoundTag tag);

    /**
     * Attempts to write the current value of this {@link ModuleConfigData} into the given {@link CompoundNBT} using the given name.
     *
     * @param name Name of the config data to write to.
     * @param tag  Data to store the value in.
     */
    void write(String name, CompoundTag tag);
}