package mekanism.config.value;

import mekanism.api.functions.ByteSupplier;
import mekanism.config.IMekanismConfig;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CachedByteValue extends CachedValue<Byte> implements ByteSupplier {

    private boolean resolved;
    private byte cachedValue;

    private CachedByteValue(IMekanismConfig config, ConfigValue<Byte> internal) {
        super(config, internal);
    }

    public static CachedByteValue wrap(IMekanismConfig config, ConfigValue<Byte> internal) {
        return new CachedByteValue(config, internal);
    }

    public byte get() {
        if (!resolved) {
            //If we don't have a cached value or need to resolve it again, get it from the actual ConfigValue
            cachedValue = internal.get();
            resolved = true;
        }
        return cachedValue;
    }

    @Override
    public byte getAsByte() {
        return get();
    }

    public void set(byte value) {
        internal.set(value);
        cachedValue = value;
    }

    @Override
    protected boolean clearCachedValue(boolean checkChanged) {
        if (!resolved) {
            //Isn't cached don't need to clear it or run any invalidation listeners
            return false;
        }
        byte oldCachedValue = cachedValue;
        resolved = false;
        //Return if we are meant to check the changed ones, and it is different than it used to be
        return checkChanged && oldCachedValue != get();
    }
}