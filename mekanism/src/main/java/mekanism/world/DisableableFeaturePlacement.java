package mekanism.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import java.util.Random;
import java.util.function.BooleanSupplier;
import mekanism.config.MekanismConfig;
import mekanism.registries.MekanismPlacementModifiers;
import mekanism.resource.ore.OreType.OreVeinType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DisableableFeaturePlacement extends PlacementFilter {

    public static final Codec<DisableableFeaturePlacement> CODEC = RecordCodecBuilder.create(builder -> builder.group(
          OreVeinType.CODEC.optionalFieldOf("oreVeinType").forGetter(config -> Optional.ofNullable(config.oreVeinType)),
          Codec.BOOL.fieldOf("retroGen").forGetter(config -> config.retroGen)
    ).apply(builder, (oreType, retroGen) -> {
        if (oreType.isPresent()) {
            OreVeinType type = oreType.get();
            return new DisableableFeaturePlacement(type, MekanismConfig.world.getVeinConfig(type).shouldGenerate(), retroGen);
        }
        return new DisableableFeaturePlacement(null, MekanismConfig.world.salt.shouldGenerate, retroGen);
    }));

    private final BooleanSupplier enabledSupplier;
    @Nullable
    private final OreVeinType oreVeinType;
    private final boolean retroGen;

    public DisableableFeaturePlacement(@Nullable OreVeinType oreVeinType, BooleanSupplier enabledSupplier, boolean retroGen) {
        this.oreVeinType = oreVeinType;
        this.enabledSupplier = enabledSupplier;
        this.retroGen = retroGen;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext context, @NotNull Random random, @NotNull BlockPos pos) {
        if (enabledSupplier.getAsBoolean()) {
            //If we are enabled, and we are either not a retrogen feature or retrogen is enabled, generate
            return !retroGen || MekanismConfig.world.enableRegeneration.get();
        }
        return false;
    }

    @NotNull
    @Override
    public PlacementModifierType<?> type() {
        return MekanismPlacementModifiers.DISABLEABLE.get();
    }
}