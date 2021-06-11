package mekanism.tools.registries;

import mekanism.registration.ItemRegistry;
import mekanism.tools.MekanismTools;
import mekanism.tools.accessors.BlockTagsAccessor;
import mekanism.tools.items.*;
import mekanism.tools.materials.BaseMekanismMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.tag.Tag;

import java.util.Locale;
import java.util.function.Supplier;

public final class ToolItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismTools.MODID);

    public static final Tag.Identified<Block> PAXEL_MINEABLE = BlockTagsAccessor.register(MekanismTools.id("mineable/paxel").toString());

    public static final int REFINED_GLOWSTONE_LIGHT_LEVEL = 0xF000F0;

    public static final MekanismPaxelItem WOOD_PAXEL      = registerPaxel(ToolMaterials.WOOD);
    public static final MekanismPaxelItem STONE_PAXEL     = registerPaxel(ToolMaterials.STONE);
    public static final MekanismPaxelItem IRON_PAXEL      = registerPaxel(ToolMaterials.IRON);
    public static final MekanismPaxelItem DIAMOND_PAXEL   = registerPaxel(ToolMaterials.DIAMOND);
    public static final MekanismPaxelItem GOLD_PAXEL      = registerPaxel(ToolMaterials.GOLD);
    public static final MekanismPaxelItem NETHERITE_PAXEL = registerPaxel(ToolMaterials.NETHERITE);

    public static final MekanismPickaxeItem BRONZE_PICKAXE = registerPickaxe(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismAxeItem BRONZE_AXE = registerAxe(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismShovelItem BRONZE_SHOVEL = registerShovel(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismHoeItem BRONZE_HOE = registerHoe(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismSwordItem BRONZE_SWORD = registerSword(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismPaxelItem BRONZE_PAXEL = registerPaxel(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismArmorItem BRONZE_HELMET = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.HEAD);
    public static final MekanismArmorItem BRONZE_CHESTPLATE = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.CHEST);
    public static final MekanismArmorItem BRONZE_LEGGINGS = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.LEGS);
    public static final MekanismArmorItem BRONZE_BOOTS = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem BRONZE_SHIELD = registerShield(MekanismTools.config().config.bronzeMaterialStats);

    public static final MekanismPickaxeItem LAPIS_LAZULI_PICKAXE = registerPickaxe(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismAxeItem LAPIS_LAZULI_AXE = registerAxe(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismShovelItem LAPIS_LAZULI_SHOVEL = registerShovel(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismHoeItem LAPIS_LAZULI_HOE = registerHoe(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismSwordItem LAPIS_LAZULI_SWORD = registerSword(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismPaxelItem LAPIS_LAZULI_PAXEL = registerPaxel(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismArmorItem LAPIS_LAZULI_HELMET = registerArmor(MekanismTools.config().config.lapisLazuliMaterialStats, EquipmentSlot.HEAD);
    public static final MekanismArmorItem LAPIS_LAZULI_CHESTPLATE = registerArmor(MekanismTools.config().config.lapisLazuliMaterialStats, EquipmentSlot.CHEST);
    public static final MekanismArmorItem LAPIS_LAZULI_LEGGINGS = registerArmor(MekanismTools.config().config.lapisLazuliMaterialStats, EquipmentSlot.LEGS);
    public static final MekanismArmorItem LAPIS_LAZULI_BOOTS = registerArmor(MekanismTools.config().config.lapisLazuliMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem LAPIS_LAZULI_SHIELD = registerShield(MekanismToolsConfig.tools.lapisLazuli);

    public static final MekanismPickaxeItem OSMIUM_PICKAXE = registerPickaxe(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismAxeItem OSMIUM_AXE = registerAxe(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismShovelItem OSMIUM_SHOVEL = registerShovel(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismHoeItem OSMIUM_HOE = registerHoe(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismSwordItem OSMIUM_SWORD = registerSword(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismPaxelItem OSMIUM_PAXEL = registerPaxel(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismArmorItem OSMIUM_HELMET = registerArmor(MekanismTools.config().config.osmiumMaterialStats, EquipmentSlot.HEAD);
    public static final MekanismArmorItem OSMIUM_CHESTPLATE = registerArmor(MekanismTools.config().config.osmiumMaterialStats, EquipmentSlot.CHEST);
    public static final MekanismArmorItem OSMIUM_LEGGINGS = registerArmor(MekanismTools.config().config.osmiumMaterialStats, EquipmentSlot.LEGS);
    public static final MekanismArmorItem OSMIUM_BOOTS = registerArmor(MekanismTools.config().config.osmiumMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem OSMIUM_SHIELD = registerShield(MekanismToolsConfig.tools.osmium);

    public static final MekanismPickaxeItem REFINED_GLOWSTONE_PICKAXE = registerPickaxe(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismAxeItem REFINED_GLOWSTONE_AXE = registerAxe(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismShovelItem REFINED_GLOWSTONE_SHOVEL = registerShovel(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismHoeItem REFINED_GLOWSTONE_HOE = registerHoe(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismSwordItem REFINED_GLOWSTONE_SWORD = registerSword(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismPaxelItem REFINED_GLOWSTONE_PAXEL = registerPaxel(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismArmorItem REFINED_GLOWSTONE_HELMET = registerArmor(MekanismTools.config().config.refinedGlowstoneMaterialStats, EquipmentSlot.HEAD, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_CHESTPLATE = registerArmor(MekanismTools.config().config.refinedGlowstoneMaterialStats, EquipmentSlot.CHEST, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_LEGGINGS = registerArmor(MekanismTools.config().config.refinedGlowstoneMaterialStats, EquipmentSlot.LEGS, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_BOOTS = registerArmor(MekanismTools.config().config.refinedGlowstoneMaterialStats, EquipmentSlot.FEET, true);
    //public static final MekanismShieldItem REFINED_GLOWSTONE_SHIELD = registerShield(MekanismToolsConfig.tools.refinedGlowstone);

    public static final MekanismPickaxeItem REFINED_OBSIDIAN_PICKAXE = registerPickaxe(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismAxeItem REFINED_OBSIDIAN_AXE = registerAxe(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismShovelItem REFINED_OBSIDIAN_SHOVEL = registerShovel(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismHoeItem REFINED_OBSIDIAN_HOE = registerHoe(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismSwordItem REFINED_OBSIDIAN_SWORD = registerSword(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismPaxelItem REFINED_OBSIDIAN_PAXEL = registerPaxel(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismArmorItem REFINED_OBSIDIAN_HELMET = registerArmor(MekanismTools.config().config.refinedObsidianMaterialStats, EquipmentSlot.HEAD);
    public static final MekanismArmorItem REFINED_OBSIDIAN_CHESTPLATE = registerArmor(MekanismTools.config().config.refinedObsidianMaterialStats, EquipmentSlot.CHEST);
    public static final MekanismArmorItem REFINED_OBSIDIAN_LEGGINGS = registerArmor(MekanismTools.config().config.refinedObsidianMaterialStats, EquipmentSlot.LEGS);
    public static final MekanismArmorItem REFINED_OBSIDIAN_BOOTS = registerArmor(MekanismTools.config().config.refinedObsidianMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem REFINED_OBSIDIAN_SHIELD = registerShield(MekanismToolsConfig.tools.refinedObsidian);

    public static final MekanismPickaxeItem STEEL_PICKAXE = registerPickaxe(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismAxeItem STEEL_AXE = registerAxe(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismShovelItem STEEL_SHOVEL = registerShovel(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismHoeItem STEEL_HOE = registerHoe(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismSwordItem STEEL_SWORD = registerSword(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismPaxelItem STEEL_PAXEL = registerPaxel(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismArmorItem STEEL_HELMET = registerArmor(MekanismTools.config().config.steelMaterialStats, EquipmentSlot.HEAD);
    public static final MekanismArmorItem STEEL_CHESTPLATE = registerArmor(MekanismTools.config().config.steelMaterialStats, EquipmentSlot.CHEST);
    public static final MekanismArmorItem STEEL_LEGGINGS = registerArmor(MekanismTools.config().config.steelMaterialStats, EquipmentSlot.LEGS);
    public static final MekanismArmorItem STEEL_BOOTS = registerArmor(MekanismTools.config().config.steelMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem STEEL_SHIELD = registerShield(MekanismToolsConfig.tools.steel);

    public static void init() {

    }

    private static MekanismPaxelItem registerPaxel(ToolMaterials material) {
        return registerPaxel(material.name(), () -> new MekanismPaxelItem(material, getItemProperties(material)));
    }

    private static MekanismPaxelItem registerPaxel(BaseMekanismMaterial material) {
        return registerPaxel(material.getRegistryPrefix(), () -> new MekanismPaxelItem(material, getItemProperties(material)));
    }

    private static MekanismPaxelItem registerPaxel(String name, Supplier<? extends MekanismPaxelItem> supplier) {
        return register(name + "_paxel", supplier);
    }

    private static MekanismPickaxeItem registerPickaxe(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_pickaxe", () -> new MekanismPickaxeItem(material, getItemProperties(material)));
    }

    private static MekanismAxeItem registerAxe(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_axe", () -> new MekanismAxeItem(material, getItemProperties(material)));
    }

    private static MekanismShovelItem registerShovel(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_shovel", () -> new MekanismShovelItem(material, getItemProperties(material)));
    }

    private static MekanismHoeItem registerHoe(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_hoe", () -> new MekanismHoeItem(material, getItemProperties(material)));
    }

    private static MekanismSwordItem registerSword(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_sword", () -> new MekanismSwordItem(material, getItemProperties(material)));
    }

    private static MekanismArmorItem registerArmor(BaseMekanismMaterial material, EquipmentSlot slot) {
        return registerArmor(material, slot, false);
    }
    private static MekanismArmorItem registerArmor(BaseMekanismMaterial material, EquipmentSlot slot, boolean makesPiglinsNeutral) {
        String suffix = switch (slot) {
            case HEAD  -> "_helmet";
            case CHEST -> "_chestplate";
            case LEGS  -> "_leggings";
            default    -> "_boots";
        };

        return register(material.getRegistryPrefix() + suffix, () -> new MekanismArmorItem(material, slot, getItemProperties(material), makesPiglinsNeutral));
    }


    private static <T extends Item> T register(String name, Supplier<? extends T> supplier) {
        return ITEMS.register(name.toLowerCase(Locale.ROOT), supplier);
    }

    private static Item.Settings getItemProperties(ToolMaterial material) {
        FabricItemSettings properties = ItemRegistry.getMekBaseProperties();

        if (material == ToolMaterials.NETHERITE) {
            properties = properties.fireproof();
        } else if (material instanceof BaseMekanismMaterial && !((BaseMekanismMaterial)material).burnsInFire()) {
            properties = properties.fireproof();
        }

        return properties;
    }
}
