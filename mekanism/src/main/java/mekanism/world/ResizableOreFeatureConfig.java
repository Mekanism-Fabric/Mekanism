package mekanism.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.IntSupplier;
import mekanism.api.functions.FloatSupplier;
import mekanism.config.MekanismConfig;
import mekanism.config.WorldConfig.OreVeinConfig;
import mekanism.resource.ore.OreType.OreVeinType;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;

public record ResizableOreFeatureConfig(List<TargetBlockState> targetStates, OreVeinType oreVeinType, IntSupplier size,
                                        FloatSupplier discardChanceOnAirExposure) implements FeatureConfiguration {

    public static final Codec<ResizableOreFeatureConfig> CODEC = RecordCodecBuilder.create(builder -> builder.group(
          Codec.list(TargetBlockState.CODEC).fieldOf("targets").forGetter(config -> config.targetStates),
          OreVeinType.CODEC.fieldOf("oreVeinType").forGetter(config -> config.oreVeinType)
    ).apply(builder, (targetStates, oreVeinType) -> {
        OreVeinConfig veinConfig = MekanismConfig.world.getVeinConfig(oreVeinType);
        return new ResizableOreFeatureConfig(targetStates, oreVeinType, veinConfig.maxVeinSize(), veinConfig.discardChanceOnAirExposure());
    }));
}