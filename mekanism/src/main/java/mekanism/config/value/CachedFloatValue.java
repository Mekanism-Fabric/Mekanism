package mekanism.config.value;

import mekanism.api.functions.FloatSupplier;
import mekanism.config.IMekanismConfig;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

//TODO: Once https://github.com/MinecraftForge/MinecraftForge/pull/6464 is merged make this extend CachedPrimitiveValue<Float>
// and make it so that our get is cleaner
public class CachedFloatValue extends CachedValue<Double> implements FloatSupplier {

    private boolean resolved;
    private float cachedValue;

    private CachedFloatValue(IMekanismConfig config, ConfigValue<Double> internal) {
        super(config, internal);
    }

    public static CachedFloatValue wrap(IMekanismConfig config, ConfigValue<Double> internal) {
        return new CachedFloatValue(config, internal);
    }

    public float get() {
        if (!resolved) {
            //If we don't have a cached value or need to resolve it again, get it from the actual ConfigValue
            //Note: For now we have to get it out of a double as there is no FloatValue config type
            Double val = internal.get();
            if (val == null) {
                cachedValue = 0;
            } else if (val > Float.MAX_VALUE) {
                cachedValue = Float.MAX_VALUE;
            } else if (val < -Float.MAX_VALUE) {
                //Note: Float.MIN_VALUE is the smallest positive value a float can represent
                // the smallest value a float can represent overall is -Float.MAX_VALUE
                cachedValue = -Float.MAX_VALUE;
            } else {
                cachedValue = val.floatValue();
            }
            resolved = true;
        }
        return cachedValue;
    }

    @Override
    public float getAsFloat() {
        return get();
    }

    public void set(float value) {
        internal.set((double) value);
        cachedValue = value;
    }

    @Override
    protected boolean clearCachedValue(boolean checkChanged) {
        if (!resolved) {
            //Isn't cached don't need to clear it or run any invalidation listeners
            return false;
        }
        float oldCachedValue = cachedValue;
        resolved = false;
        //Return if we are meant to check the changed ones, and it is different than it used to be
        return checkChanged && oldCachedValue != get();
    }
}