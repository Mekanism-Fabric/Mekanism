package mekanism.tools;

import me.shedaniel.autoconfig.AutoConfig;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.ToolsConfig;
import mekanism.tools.config.tools.mobarmorspawnrate.ISpawnChance;
import mekanism.tools.events.EntitySpawnedEvent;
import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MekanismTools implements ModInitializer {
    public static final String MODID = "mekanismtools";
    public static final Logger LOGGER = LogManager.getLogger();

    private static TOMLConfigSerializer<ToolsConfig> serializer;

    @Override
    public void onInitialize() {
        reloadConfig();

        ToolItems.init();

        EntitySpawnedEvent.EVENT.register((MobEntity entity, World world, float x, float y, float z, MobSpawnerLogic spawnerLogic, SpawnReason spawnReason) -> {
            if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity || entity instanceof PiglinEntity) {
                //Don't bother calculating random numbers unless the instanceof checks pass
                Random random = world.getRandom();
                double chance = random.nextDouble();
                if (chance < config().config.mobArmorSpawnRate.general) {
                    //We can only spawn refined glowstone armor on piglins
                    int armorType = entity instanceof PiglinEntity ? 0 : random.nextInt(6);

                    if (armorType == 0) {
                        setEntityArmorWithChance(random, entity, ToolItems.REFINED_GLOWSTONE_SWORD, ToolItems.REFINED_GLOWSTONE_HELMET, ToolItems.REFINED_GLOWSTONE_CHESTPLATE,
                            ToolItems.REFINED_GLOWSTONE_LEGGINGS, ToolItems.REFINED_GLOWSTONE_BOOTS, config().config.mobArmorSpawnRate.refinedGlowstone);
                    } else if (armorType == 1) {
                        setEntityArmorWithChance(random, entity, ToolItems.LAPIS_LAZULI_SWORD, ToolItems.LAPIS_LAZULI_HELMET, ToolItems.LAPIS_LAZULI_CHESTPLATE,
                            ToolItems.LAPIS_LAZULI_LEGGINGS, ToolItems.LAPIS_LAZULI_BOOTS, config().config.mobArmorSpawnRate.lapisLazuli);
                    } else if (armorType == 2) {
                        setEntityArmorWithChance(random, entity, ToolItems.REFINED_OBSIDIAN_SWORD, ToolItems.REFINED_OBSIDIAN_HELMET, ToolItems.REFINED_OBSIDIAN_CHESTPLATE,
                            ToolItems.REFINED_OBSIDIAN_LEGGINGS, ToolItems.REFINED_OBSIDIAN_BOOTS, config().config.mobArmorSpawnRate.refinedObsidian);
                    } else if (armorType == 3) {
                        setEntityArmorWithChance(random, entity, ToolItems.STEEL_SWORD, ToolItems.STEEL_HELMET, ToolItems.STEEL_CHESTPLATE, ToolItems.STEEL_LEGGINGS,
                            ToolItems.STEEL_BOOTS, config().config.mobArmorSpawnRate.steel);
                    } else if (armorType == 4) {
                        setEntityArmorWithChance(random, entity, ToolItems.BRONZE_SWORD, ToolItems.BRONZE_HELMET, ToolItems.BRONZE_CHESTPLATE, ToolItems.BRONZE_LEGGINGS,
                            ToolItems.BRONZE_BOOTS, config().config.mobArmorSpawnRate.bronze);
                    } else {//armorType == 5
                        setEntityArmorWithChance(random, entity, ToolItems.OSMIUM_SWORD, ToolItems.OSMIUM_HELMET, ToolItems.OSMIUM_CHESTPLATE, ToolItems.OSMIUM_LEGGINGS,
                            ToolItems.OSMIUM_BOOTS, config().config.mobArmorSpawnRate.osmium);
                    }
                }
            }
        });

        log(Level.INFO, "Tools Loaded");
    }

    public static ToolsConfig config() {
        if (serializer == null) {
            reloadConfig();
        }

        return serializer.getConfig();
    }

    public static void reloadConfig() {
        if (serializer == null) {
            AutoConfig.register(ToolsConfig.class, (definition, configClass) -> {
                serializer = new TOMLConfigSerializer<>(definition, configClass);
                return serializer;
            });
        } else {
            serializer.reloadFromDisk();
        }
    }

    private void setStackIfEmpty(LivingEntity entity, EquipmentSlot slot, ItemStack item) {
        if (entity.getEquippedStack(slot).isEmpty()) {
            entity.equipStack(slot, item);
        }
    }

    private void setEntityArmorWithChance(Random random, LivingEntity entity, ItemConvertible sword, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ISpawnChance chanceConfig) {
        if (entity instanceof ZombieEntity && random.nextDouble() < chanceConfig.getSwordChance()) {
            setStackIfEmpty(entity, EquipmentSlot.MAINHAND, new ItemStack(sword));
        }
        if (random.nextDouble() < chanceConfig.getHelmetChance()) {
            setStackIfEmpty(entity, EquipmentSlot.HEAD, new ItemStack(helmet));
        }
        if (random.nextDouble() < chanceConfig.getChestplateChance()) {
            setStackIfEmpty(entity, EquipmentSlot.CHEST, new ItemStack(chestplate));
        }
        if (random.nextDouble() < chanceConfig.getLeggingsChance()) {
            setStackIfEmpty(entity, EquipmentSlot.LEGS, new ItemStack(leggings));
        }
        if (random.nextDouble() < chanceConfig.getBootsChance()) {
            setStackIfEmpty(entity, EquipmentSlot.FEET, new ItemStack(boots));
        }
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static Identifier id(String path) {
        return new Identifier(MekanismTools.MODID, path);
    }
}
