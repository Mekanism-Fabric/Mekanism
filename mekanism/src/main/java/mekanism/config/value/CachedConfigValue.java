package mekanism.config.value;

import mekanism.config.IMekanismConfig;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CachedConfigValue<T> extends CachedResolvableConfigValue<T, T> {

    protected CachedConfigValue(IMekanismConfig config, ConfigValue<T> internal) {
        super(config, internal);
    }

    public static <T> CachedConfigValue<T> wrap(IMekanismConfig config, ConfigValue<T> internal) {
        return new CachedConfigValue<>(config, internal);
    }

    @Override
    protected T resolve(T encoded) {
        return encoded;
    }

    @Override
    protected T encode(T value) {
        return value;
    }
}