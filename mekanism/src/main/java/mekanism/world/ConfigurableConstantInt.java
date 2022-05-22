package mekanism.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntSupplier;
import mekanism.config.MekanismConfig;
import mekanism.registries.MekanismIntProviderTypes;
import mekanism.resource.ore.OreType.OreVeinType;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigurableConstantInt extends IntProvider {

    public static final Codec<ConfigurableConstantInt> CODEC = RecordCodecBuilder.create(builder -> builder.group(
          OreVeinType.CODEC.optionalFieldOf("oreVeinType").forGetter(config -> Optional.ofNullable(config.oreVeinType))
    ).apply(builder, oreType -> {
        if (oreType.isPresent()) {
            OreVeinType type = oreType.get();
            return new ConfigurableConstantInt(type, MekanismConfig.world.getVeinConfig(type).perChunk());
        }
        return new ConfigurableConstantInt(null, MekanismConfig.world.salt.perChunk);
    }));

    @Nullable
    private final OreVeinType oreVeinType;
    private final IntSupplier value;

    public ConfigurableConstantInt(@Nullable OreVeinType oreVeinType, IntSupplier value) {
        this.oreVeinType = oreVeinType;
        this.value = value;
    }

    public int getValue() {
        return this.value.getAsInt();
    }

    @Override
    public int sample(@NotNull Random random) {
        return getValue();
    }

    @Override
    public int getMinValue() {
        return getValue();
    }

    @Override
    public int getMaxValue() {
        return getValue();
    }

    @NotNull
    @Override
    public IntProviderType<?> getType() {
        return MekanismIntProviderTypes.CONFIGURABLE_CONSTANT.get();
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}