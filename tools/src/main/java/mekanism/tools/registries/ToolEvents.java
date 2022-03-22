package mekanism.tools.registries;

import mekanism.tools.MekanismTools;
import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.config.ToolsConfig;
import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;

import java.util.Random;

public final class ToolEvents {

    public static void init() {

        EntitySpawnedEvent.EVENT.register(ToolEvents::onEntitySpawned);

    }

    private static void onEntitySpawned(MobEntity entity, World world, float x, float y, float z, MobSpawnerLogic spawnerLogic, SpawnReason spawnReason) {
        if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity || entity instanceof PiglinEntity) {
            //Don't bother calculating random numbers unless the instanceof checks pass
            Random random = world.getRandom();
            double chance = random.nextDouble();
            if (Double.compare(chance, MekanismToolsConfig.tools.armorSpawnRate.getAsDouble()) < 0) {
                //We can only spawn refined glowstone armor on piglins
                int armorType = entity instanceof PiglinEntity ? 0 : random.nextInt(6);

                if (armorType == 0) {
                    setEntityArmorWithChance(random, entity, ToolItems.REFINED_GLOWSTONE_SWORD, ToolItems.REFINED_GLOWSTONE_HELMET, ToolItems.REFINED_GLOWSTONE_CHESTPLATE,
                        ToolItems.REFINED_GLOWSTONE_LEGGINGS, ToolItems.REFINED_GLOWSTONE_BOOTS, MekanismToolsConfig.tools.refinedGlowstoneSpawnRate);
                } else if (armorType == 1) {
                    setEntityArmorWithChance(random, entity, ToolItems.LAPIS_LAZULI_SWORD, ToolItems.LAPIS_LAZULI_HELMET, ToolItems.LAPIS_LAZULI_CHESTPLATE,
                        ToolItems.LAPIS_LAZULI_LEGGINGS, ToolItems.LAPIS_LAZULI_BOOTS, MekanismToolsConfig.tools.lapisLazuliSpawnRate);
                } else if (armorType == 2) {
                    setEntityArmorWithChance(random, entity, ToolItems.REFINED_OBSIDIAN_SWORD, ToolItems.REFINED_OBSIDIAN_HELMET, ToolItems.REFINED_OBSIDIAN_CHESTPLATE,
                        ToolItems.REFINED_OBSIDIAN_LEGGINGS, ToolItems.REFINED_OBSIDIAN_BOOTS, MekanismToolsConfig.tools.refinedObsidianSpawnRate);
                } else if (armorType == 3) {
                    setEntityArmorWithChance(random, entity, ToolItems.STEEL_SWORD, ToolItems.STEEL_HELMET, ToolItems.STEEL_CHESTPLATE, ToolItems.STEEL_LEGGINGS,
                        ToolItems.STEEL_BOOTS, MekanismToolsConfig.tools.steelSpawnRate);
                } else if (armorType == 4) {
                    setEntityArmorWithChance(random, entity, ToolItems.BRONZE_SWORD, ToolItems.BRONZE_HELMET, ToolItems.BRONZE_CHESTPLATE, ToolItems.BRONZE_LEGGINGS,
                        ToolItems.BRONZE_BOOTS, MekanismToolsConfig.tools.bronzeSpawnRate);
                } else {//armorType == 5
                    setEntityArmorWithChance(random, entity, ToolItems.OSMIUM_SWORD, ToolItems.OSMIUM_HELMET, ToolItems.OSMIUM_CHESTPLATE, ToolItems.OSMIUM_LEGGINGS,
                        ToolItems.OSMIUM_BOOTS, MekanismToolsConfig.tools.osmiumSpawnRate);
                }
            }
        }
    }

    private static void setStackIfEmpty(LivingEntity entity, EquipmentSlot slot, ItemStack item) {
        if (entity.getEquippedStack(slot).isEmpty()) {
            entity.equipStack(slot, item);
        }
    }

    private static void setEntityArmorWithChance(Random random, LivingEntity entity, ItemConvertible sword, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ToolsConfig.ArmorSpawnChanceConfig chanceConfig) {
        if (entity instanceof ZombieEntity && random.nextDouble() < chanceConfig.swordChance.get()) {
            setStackIfEmpty(entity, EquipmentSlot.MAINHAND, new ItemStack(sword));
        }
        if (random.nextDouble() < chanceConfig.helmetChance.get()) {
            setStackIfEmpty(entity, EquipmentSlot.HEAD, new ItemStack(helmet));
        }
        if (random.nextDouble() < chanceConfig.chestplateChance.get()) {
            setStackIfEmpty(entity, EquipmentSlot.CHEST, new ItemStack(chestplate));
        }
        if (random.nextDouble() < chanceConfig.leggingsChance.get()) {
            setStackIfEmpty(entity, EquipmentSlot.LEGS, new ItemStack(leggings));
        }
        if (random.nextDouble() < chanceConfig.bootsChance.get()) {
            setStackIfEmpty(entity, EquipmentSlot.FEET, new ItemStack(boots));
        }
    }

}
