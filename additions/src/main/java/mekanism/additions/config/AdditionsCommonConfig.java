package mekanism.additions.config;

import mekanism.additions.registries.AdditionsEntityTypes;
import mekanism.api.providers.IEntityTypeProvider;
import mekanism.config.BaseMekanismConfig;
import mekanism.config.IMekanismConfig;
import mekanism.config.value.CachedBooleanValue;
import mekanism.config.value.CachedDoubleValue;
import mekanism.config.value.CachedResourceLocationListValue;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig.Type;

public class AdditionsCommonConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;

    public final SpawnConfig babyCreeper;
    public final SpawnConfig babyEnderman;
    public final SpawnConfig babySkeleton;
    public final SpawnConfig babyStray;
    public final SpawnConfig babyWitherSkeleton;

    AdditionsCommonConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Mekanism Additions Common Config. This config is not sync'd between server and client.").push("additions-common");
        builder.comment("Config options regarding spawning of entities.").push("spawning");
        babyCreeper = new SpawnConfig(this, builder, "baby creepers", AdditionsEntityTypes.BABY_CREEPER, () -> EntityType.CREEPER);
        babyEnderman = new SpawnConfig(this, builder, "baby endermen", AdditionsEntityTypes.BABY_ENDERMAN, () -> EntityType.ENDERMAN);
        babySkeleton = new SpawnConfig(this, builder, "baby skeletons", AdditionsEntityTypes.BABY_SKELETON, () -> EntityType.SKELETON);
        babyStray = new SpawnConfig(this, builder, "baby strays", AdditionsEntityTypes.BABY_STRAY, () -> EntityType.STRAY);
        babyWitherSkeleton = new SpawnConfig(this, builder, "baby wither skeletons", AdditionsEntityTypes.BABY_WITHER_SKELETON, () -> EntityType.WITHER_SKELETON);
        builder.pop(2);
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "additions-common";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public Type getConfigType() {
        return Type.COMMON;
    }

    public static class SpawnConfig {

        public final CachedBooleanValue shouldSpawn;
        public final CachedDoubleValue weightPercentage;
        public final CachedDoubleValue minSizePercentage;
        public final CachedDoubleValue maxSizePercentage;
        public final CachedDoubleValue spawnCostPerEntityPercentage;
        public final CachedDoubleValue maxSpawnCostPercentage;
        public final CachedResourceLocationListValue biomeBlackList;
        public final CachedResourceLocationListValue structureBlackList;
        public final IEntityTypeProvider entityTypeProvider;
        public final IEntityTypeProvider parentTypeProvider;

        private SpawnConfig(IMekanismConfig config, ForgeConfigSpec.Builder builder, String name, IEntityTypeProvider entityTypeProvider,
                            IEntityTypeProvider parentTypeProvider) {
            this.entityTypeProvider = entityTypeProvider;
            this.parentTypeProvider = parentTypeProvider;
            builder.comment("Config options regarding " + name + ".").push(name.replace(" ", "-"));
            this.shouldSpawn = CachedBooleanValue.wrap(config, builder.comment("Enable the spawning of " + name + ". Think baby zombies.")
                    .worldRestart()
                    .define("shouldSpawn", true));
            this.weightPercentage = CachedDoubleValue.wrap(config, builder.comment("The multiplier for weight of " + name + " spawns, compared to the adult mob.")
                    .worldRestart()
                    .defineInRange("weightPercentage", 0.5, 0, 100));
            this.minSizePercentage = CachedDoubleValue.wrap(config, builder.comment("The multiplier for minimum group size of " + name + " spawns, compared to the adult mob.")
                    .worldRestart()
                    .defineInRange("minSizePercentage", 0.5, 0, 100));
            this.maxSizePercentage = CachedDoubleValue.wrap(config, builder.comment("The multiplier for maximum group size of " + name + " spawns, compared to the adult mob.")
                    .worldRestart()
                    .defineInRange("maxSizePercentage", 0.5, 0, 100));
            this.spawnCostPerEntityPercentage = CachedDoubleValue.wrap(config, builder.comment("The multiplier for spawn cost per entity of " + name + " spawns, compared to the adult mob.")
                    .worldRestart()
                    .defineInRange("spawnCostPerEntityPercentage", 1D, 0, 100));
            this.maxSpawnCostPercentage = CachedDoubleValue.wrap(config, builder.comment("The multiplier for max spawn cost of " + name + " spawns, compared to the adult mob.")
                    .worldRestart()
                    .defineInRange("maxSpawnCostPercentage", 1D, 0, 100));
            this.biomeBlackList = CachedResourceLocationListValue.define(config, builder.comment("The list of biome ids that " + name + " will not spawn in even if the normal mob variant can spawn.")
                    .worldRestart(), "biomeBlackList", BuiltinRegistries.BIOME::containsKey);
            this.structureBlackList = CachedResourceLocationListValue.define(config, builder.comment("The list of structure ids that " + name + " will not spawn in even if the normal mob variant can spawn.")
                    .worldRestart(), "structureBlackList", BuiltinRegistries.TEMPLATE_POOL::containsKey);
            builder.pop();
        }
    }
}