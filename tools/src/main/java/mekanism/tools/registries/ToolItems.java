package mekanism.tools.registries;

import mekanism.registration.ItemRegistry;
import mekanism.tools.MekanismTools;
import mekanism.tools.accessors.BlockTagsAccessor;
import mekanism.tools.items.MekanismAxeItem;
import mekanism.tools.items.MekanismPaxelItem;
import mekanism.tools.items.MekanismPickaxeItem;
import mekanism.tools.materials.BaseMekanismMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.tag.Tag;

import java.util.Locale;
import java.util.function.Supplier;

public final class ToolItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismTools.MODID);

    public static final Tag.Identified<Block> PAXEL_MINEABLE = BlockTagsAccessor.register(MekanismTools.id("mineable/paxel").toString());

    public static final MekanismPaxelItem WOOD_PAXEL      = registerPaxel(ToolMaterials.WOOD);
    public static final MekanismPaxelItem STONE_PAXEL     = registerPaxel(ToolMaterials.STONE);
    public static final MekanismPaxelItem IRON_PAXEL      = registerPaxel(ToolMaterials.IRON);
    public static final MekanismPaxelItem DIAMOND_PAXEL   = registerPaxel(ToolMaterials.DIAMOND);
    public static final MekanismPaxelItem GOLD_PAXEL      = registerPaxel(ToolMaterials.GOLD);
    public static final MekanismPaxelItem NETHERITE_PAXEL = registerPaxel(ToolMaterials.NETHERITE);

    public static final MekanismPickaxeItem BRONZE_PICKAXE = registerPickaxe(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismAxeItem BRONZE_AXE = registerAxe(MekanismTools.config().config.bronzeMaterialStats);
    //public static final MekanismShovelItem BRONZE_SHOVEL = registerShovel(MekanismTools.config().config.bronzeMaterialStats);
    //public static final MekanismHoeItem BRONZE_HOE = registerHoe(MekanismTools.config().config.bronzeMaterialStats);
    //public static final MekanismSwordItem BRONZE_SWORD = registerSword(MekanismTools.config().config.bronzeMaterialStats);
    public static final MekanismPaxelItem BRONZE_PAXEL = registerPaxel(MekanismTools.config().config.bronzeMaterialStats);
    //public static final MekanismArmorItem BRONZE_HELMET = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.HEAD);
    //public static final MekanismArmorItem BRONZE_CHESTPLATE = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.CHEST);
    //public static final MekanismArmorItem BRONZE_LEGGINGS = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.LEGS);
    //public static final MekanismArmorItem BRONZE_BOOTS = registerArmor(MekanismTools.config().config.bronzeMaterialStats, EquipmentSlot.FEET);
    //public static final MekanismShieldItem BRONZE_SHIELD = registerShield(MekanismTools.config().config.bronzeMaterialStats);

    public static final MekanismPickaxeItem LAPIS_LAZULI_PICKAXE = registerPickaxe(MekanismTools.config().config.lapisLazuliMaterialStats);
    public static final MekanismAxeItem LAPIS_LAZULI_AXE = registerAxe(MekanismTools.config().config.lapisLazuliMaterialStats);
    //public static final MekanismShovelItem LAPIS_LAZULI_SHOVEL = registerShovel(MekanismToolsConfig.tools.lapisLazuli);
    //public static final MekanismHoeItem LAPIS_LAZULI_HOE = registerHoe(MekanismToolsConfig.tools.lapisLazuli);
    //public static final MekanismSwordItem LAPIS_LAZULI_SWORD = registerSword(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismPaxelItem LAPIS_LAZULI_PAXEL = registerPaxel(MekanismTools.config().config.lapisLazuliMaterialStats);
    //public static final MekanismArmorItem LAPIS_LAZULI_HELMET = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlotType.HEAD);
    //public static final MekanismArmorItem LAPIS_LAZULI_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlotType.CHEST);
    //public static final MekanismArmorItem LAPIS_LAZULI_LEGGINGS = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlotType.LEGS);
    //public static final MekanismArmorItem LAPIS_LAZULI_BOOTS = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlotType.FEET);
    //public static final MekanismShieldItem LAPIS_LAZULI_SHIELD = registerShield(MekanismToolsConfig.tools.lapisLazuli);

    public static final MekanismPickaxeItem OSMIUM_PICKAXE = registerPickaxe(MekanismTools.config().config.osmiumMaterialStats);
    public static final MekanismAxeItem OSMIUM_AXE = registerAxe(MekanismTools.config().config.osmiumMaterialStats);
    //public static final MekanismShovelItem OSMIUM_SHOVEL = registerShovel(MekanismToolsConfig.tools.osmium);
    //public static final MekanismHoeItem OSMIUM_HOE = registerHoe(MekanismToolsConfig.tools.osmium);
    //public static final MekanismSwordItem OSMIUM_SWORD = registerSword(MekanismToolsConfig.tools.osmium);
    public static final MekanismPaxelItem OSMIUM_PAXEL = registerPaxel(MekanismTools.config().config.osmiumMaterialStats);
    //public static final MekanismArmorItem OSMIUM_HELMET = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlotType.HEAD);
    //public static final MekanismArmorItem OSMIUM_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlotType.CHEST);
    //public static final MekanismArmorItem OSMIUM_LEGGINGS = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlotType.LEGS);
    //public static final MekanismArmorItem OSMIUM_BOOTS = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlotType.FEET);
    //public static final MekanismShieldItem OSMIUM_SHIELD = registerShield(MekanismToolsConfig.tools.osmium);

    public static final MekanismPickaxeItem REFINED_GLOWSTONE_PICKAXE = registerPickaxe(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    public static final MekanismAxeItem REFINED_GLOWSTONE_AXE = registerAxe(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    //public static final MekanismShovelItem REFINED_GLOWSTONE_SHOVEL = registerShovel(MekanismToolsConfig.tools.refinedGlowstone);
    //public static final MekanismHoeItem REFINED_GLOWSTONE_HOE = registerHoe(MekanismToolsConfig.tools.refinedGlowstone);
    //public static final MekanismSwordItem REFINED_GLOWSTONE_SWORD = registerSword(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismPaxelItem REFINED_GLOWSTONE_PAXEL = registerPaxel(MekanismTools.config().config.refinedGlowstoneMaterialStats);
    //public static final MekanismArmorItem REFINED_GLOWSTONE_HELMET = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlotType.HEAD, true);
    //public static final MekanismArmorItem REFINED_GLOWSTONE_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlotType.CHEST, true);
    //public static final MekanismArmorItem REFINED_GLOWSTONE_LEGGINGS = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlotType.LEGS, true);
    //public static final MekanismArmorItem REFINED_GLOWSTONE_BOOTS = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlotType.FEET, true);
    //public static final MekanismShieldItem REFINED_GLOWSTONE_SHIELD = registerShield(MekanismToolsConfig.tools.refinedGlowstone);

    public static final MekanismPickaxeItem REFINED_OBSIDIAN_PICKAXE = registerPickaxe(MekanismTools.config().config.refinedObsidianMaterialStats);
    public static final MekanismAxeItem REFINED_OBSIDIAN_AXE = registerAxe(MekanismTools.config().config.refinedObsidianMaterialStats);
    //public static final MekanismShovelItem REFINED_OBSIDIAN_SHOVEL = registerShovel(MekanismToolsConfig.tools.refinedObsidian);
    //public static final MekanismHoeItem REFINED_OBSIDIAN_HOE = registerHoe(MekanismToolsConfig.tools.refinedObsidian);
    //public static final MekanismSwordItem REFINED_OBSIDIAN_SWORD = registerSword(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismPaxelItem REFINED_OBSIDIAN_PAXEL = registerPaxel(MekanismTools.config().config.refinedObsidianMaterialStats);
    //public static final MekanismArmorItem REFINED_OBSIDIAN_HELMET = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlotType.HEAD);
    //public static final MekanismArmorItem REFINED_OBSIDIAN_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlotType.CHEST);
    //public static final MekanismArmorItem REFINED_OBSIDIAN_LEGGINGS = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlotType.LEGS);
    //public static final MekanismArmorItem REFINED_OBSIDIAN_BOOTS = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlotType.FEET);
    //public static final MekanismShieldItem REFINED_OBSIDIAN_SHIELD = registerShield(MekanismToolsConfig.tools.refinedObsidian);

    public static final MekanismPickaxeItem STEEL_PICKAXE = registerPickaxe(MekanismTools.config().config.steelMaterialStats);
    public static final MekanismAxeItem STEEL_AXE = registerAxe(MekanismTools.config().config.steelMaterialStats);
    //public static final MekanismShovelItem STEEL_SHOVEL = registerShovel(MekanismToolsConfig.tools.steel);
    //public static final MekanismHoeItem STEEL_HOE = registerHoe(MekanismToolsConfig.tools.steel);
    //public static final MekanismSwordItem STEEL_SWORD = registerSword(MekanismToolsConfig.tools.steel);
    public static final MekanismPaxelItem STEEL_PAXEL = registerPaxel(MekanismTools.config().config.steelMaterialStats);
    //public static final MekanismArmorItem STEEL_HELMET = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlotType.HEAD);
    //public static final MekanismArmorItem STEEL_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlotType.CHEST);
    //public static final MekanismArmorItem STEEL_LEGGINGS = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlotType.LEGS);
    //public static final MekanismArmorItem STEEL_BOOTS = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlotType.FEET);
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
