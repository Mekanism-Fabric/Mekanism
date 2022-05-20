package mekanism.tools.registries;

import mekanism.tools.MekanismTools;
import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.config.ToolsConfig;
import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import java.util.Random;

public final class ToolEvents {

    public static void init() {

        EntitySpawnedEvent.EVENT.register(ToolEvents::onEntitySpawned);

    }

    private static void onEntitySpawned(Mob entity, Level world, float x, float y, float z, BaseSpawner spawnerLogic, MobSpawnType spawnReason) {
        if (entity instanceof Zombie || entity instanceof Skeleton || entity instanceof Piglin) {
            //Don't bother calculating random numbers unless the instanceof checks pass
            Random random = world.getRandom();
            double chance = random.nextDouble();
            if (Double.compare(chance, MekanismToolsConfig.tools.armorSpawnRate.getAsDouble()) < 0) {
                //We can only spawn refined glowstone armor on piglins
                int armorType = entity instanceof Piglin ? 0 : random.nextInt(6);

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
        if (entity.getItemBySlot(slot).isEmpty()) {
            entity.setItemSlot(slot, item);
        }
    }

    private static void setEntityArmorWithChance(Random random, LivingEntity entity, ItemLike sword, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots, ToolsConfig.ArmorSpawnChanceConfig chanceConfig) {
        if (entity instanceof Zombie && random.nextDouble() < chanceConfig.swordChance.get()) {
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
