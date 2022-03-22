package mekanism.config.value;

import java.util.function.LongSupplier;
import mekanism.config.IMekanismConfig;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CachedLongValue extends CachedValue<Long> implements LongSupplier {

    private boolean resolved;
    private long cachedValue;

    private CachedLongValue(IMekanismConfig config, ConfigValue<Long> internal) {
        super(config, internal);
    }

    public static CachedLongValue wrap(IMekanismConfig config, ConfigValue<Long> internal) {
        return new CachedLongValue(config, internal);
    }

    public long get() {
        if (!resolved) {
            //If we don't have a cached value or need to resolve it again, get it from the actual ConfigValue
            cachedValue = internal.get();
            resolved = true;
        }
        return cachedValue;
    }

    @Override
    public long getAsLong() {
        return get();
    }

    public void set(long value) {
        internal.set(value);
        cachedValue = value;
    }

    @Override
    protected boolean clearCachedValue(boolean checkChanged) {
        if (!resolved) {
            //Isn't cached don't need to clear it or run any invalidation listeners
            return false;
        }
        long oldCachedValue = cachedValue;
        resolved = false;
        //Return if we are meant to check the changed ones, and it is different than it used to be
        return checkChanged && oldCachedValue != get();
    }
}