package mekanism.config.value;

import mekanism.config.IMekanismConfig;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * @param <TYPE> The type this {@link CachedResolvableConfigValue} resolves to
 * @param <REAL> The real type that the {@link ConfigValue} holds
 */
public abstract class CachedResolvableConfigValue<TYPE, REAL> extends CachedValue<REAL> implements Supplier<TYPE> {

    @Nullable
    private TYPE cachedValue;

    protected CachedResolvableConfigValue(IMekanismConfig config, ConfigValue<REAL> internal) {
        super(config, internal);
    }

    protected abstract TYPE resolve(REAL encoded);

    protected abstract REAL encode(TYPE value);

    @NotNull
    @Override
    public TYPE get() {
        if (cachedValue == null) {
            //If we don't have a cached value, resolve it from the actual ConfigValue
            cachedValue = resolve(internal.get());
        }
        return cachedValue;
    }

    public void set(TYPE value) {
        internal.set(encode(value));
        cachedValue = value;
    }

    @Override
    protected boolean clearCachedValue(boolean checkChanged) {
        if (cachedValue == null) {
            //Isn't cached don't need to clear it or run any invalidation listeners
            return false;
        }
        TYPE oldCachedValue = cachedValue;
        cachedValue = null;
        //Return if we are meant to check the changed ones, and it is different than it used to be
        return checkChanged && !oldCachedValue.equals(get());
    }
}