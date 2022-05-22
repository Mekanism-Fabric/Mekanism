package mekanism.world;

import com.mojang.serialization.Codec;
import java.util.Random;
import mekanism.config.MekanismConfig;
import mekanism.registries.MekanismIntProviderTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import org.jetbrains.annotations.NotNull;

public class ConfigurableUniformInt extends IntProvider {

    public static final ConfigurableUniformInt SALT = new ConfigurableUniformInt();
    public static final Codec<ConfigurableUniformInt> CODEC = Codec.unit(SALT);

    private ConfigurableUniformInt() {
    }

    @Override
    public int sample(@NotNull Random random) {
        return Mth.randomBetweenInclusive(random, getMinValue(), getMaxValue());
    }

    @Override
    public int getMinValue() {
        return MekanismConfig.world.salt.minRadius.get();
    }

    @Override
    public int getMaxValue() {
        return MekanismConfig.world.salt.maxRadius.get();
    }

    @NotNull
    @Override
    public IntProviderType<?> getType() {
        return MekanismIntProviderTypes.CONFIGURABLE_UNIFORM.get();
    }

    @Override
    public String toString() {
        return "[" + getMinValue() + "-" + getMaxValue() + "]";
    }
}