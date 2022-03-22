package mekanism.api.gear.config;

import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Boolean implementation of {@link ModuleConfigData}.
 */
public final class ModuleBooleanData implements ModuleConfigData<Boolean> {

    private boolean value;

    /**
     * Creates a new {@link ModuleBooleanData} with a default value of {@code true}.
     */
    public ModuleBooleanData() {
        this(true);
    }

    /**
     * Creates a new {@link ModuleBooleanData} with the given default value.
     *
     * @param def Default value.
     */
    public ModuleBooleanData(boolean def) {
        value = def;
    }

    @NotNull
    @Override
    public Boolean get() {
        return value;
    }

    @Override
    public void set(Boolean val) {
        value = Objects.requireNonNull(val, "Value cannot be null.");
    }

    @Override
    public void read(String name, NbtCompound tag) {
        Objects.requireNonNull(tag, "Tag cannot be null.");
        Objects.requireNonNull(name, "Name cannot be null.");
        value = tag.getBoolean(name);
    }

    @Override
    public void write(String name, NbtCompound tag) {
        Objects.requireNonNull(tag, "Tag cannot be null.");
        Objects.requireNonNull(name, "Name cannot be null.");
        tag.putBoolean(name, value);
    }
}