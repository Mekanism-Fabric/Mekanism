package mekanism.tools.registries;

import mekanism.registration.ItemRegistry;
import mekanism.tools.MekanismTools;
import mekanism.tools.accessors.BlockTagsAccessor;
import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.items.*;
import mekanism.tools.material.BaseMekanismMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import java.util.Locale;
import java.util.function.Supplier;

public final class ToolItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismTools.MODID);

    public static final Tag.Named<Block> PAXEL_MINEABLE = BlockTagsAccessor.register(MekanismTools.id("mineable/paxel").toString());

    public static final int REFINED_GLOWSTONE_LIGHT_LEVEL = 0xF000F0;

    public static final MekanismPaxelItem WOOD_PAXEL      = registerPaxel(Tiers.WOOD);
    public static final MekanismPaxelItem STONE_PAXEL     = registerPaxel(Tiers.STONE);
    public static final MekanismPaxelItem IRON_PAXEL      = registerPaxel(Tiers.IRON);
    public static final MekanismPaxelItem DIAMOND_PAXEL   = registerPaxel(Tiers.DIAMOND);
    public static final MekanismPaxelItem GOLD_PAXEL      = registerPaxel(Tiers.GOLD);
    public static final MekanismPaxelItem NETHERITE_PAXEL = registerPaxel(Tiers.NETHERITE);

    public static final MekanismPickaxeItem BRONZE_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.bronze);
    public static final MekanismAxeItem BRONZE_AXE = registerAxe(MekanismToolsConfig.tools.bronze);
    public static final MekanismShovelItem BRONZE_SHOVEL = registerShovel(MekanismToolsConfig.tools.bronze);
    public static final MekanismHoeItem BRONZE_HOE = registerHoe(MekanismToolsConfig.tools.bronze);
    public static final MekanismSwordItem BRONZE_SWORD = registerSword(MekanismToolsConfig.tools.bronze);
    public static final MekanismPaxelItem BRONZE_PAXEL = registerPaxel(MekanismToolsConfig.tools.bronze);
    public static final MekanismArmorItem BRONZE_HELMET = registerArmor(MekanismToolsConfig.tools.bronze, EquipmentSlot.HEAD);
    public static final MekanismArmorItem BRONZE_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.bronze, EquipmentSlot.CHEST);
    public static final MekanismArmorItem BRONZE_LEGGINGS = registerArmor(MekanismToolsConfig.tools.bronze, EquipmentSlot.LEGS);
    public static final MekanismArmorItem BRONZE_BOOTS = registerArmor(MekanismToolsConfig.tools.bronze, EquipmentSlot.FEET);
    public static final MekanismShieldItem BRONZE_SHIELD = registerShield(MekanismToolsConfig.tools.bronze);

    public static final MekanismPickaxeItem LAPIS_LAZULI_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismAxeItem LAPIS_LAZULI_AXE = registerAxe(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismShovelItem LAPIS_LAZULI_SHOVEL = registerShovel(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismHoeItem LAPIS_LAZULI_HOE = registerHoe(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismSwordItem LAPIS_LAZULI_SWORD = registerSword(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismPaxelItem LAPIS_LAZULI_PAXEL = registerPaxel(MekanismToolsConfig.tools.lapisLazuli);
    public static final MekanismArmorItem LAPIS_LAZULI_HELMET = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlot.HEAD);
    public static final MekanismArmorItem LAPIS_LAZULI_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlot.CHEST);
    public static final MekanismArmorItem LAPIS_LAZULI_LEGGINGS = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlot.LEGS);
    public static final MekanismArmorItem LAPIS_LAZULI_BOOTS = registerArmor(MekanismToolsConfig.tools.lapisLazuli, EquipmentSlot.FEET);
    public static final MekanismShieldItem LAPIS_LAZULI_SHIELD = registerShield(MekanismToolsConfig.tools.lapisLazuli);

    public static final MekanismPickaxeItem OSMIUM_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.osmium);
    public static final MekanismAxeItem OSMIUM_AXE = registerAxe(MekanismToolsConfig.tools.osmium);
    public static final MekanismShovelItem OSMIUM_SHOVEL = registerShovel(MekanismToolsConfig.tools.osmium);
    public static final MekanismHoeItem OSMIUM_HOE = registerHoe(MekanismToolsConfig.tools.osmium);
    public static final MekanismSwordItem OSMIUM_SWORD = registerSword(MekanismToolsConfig.tools.osmium);
    public static final MekanismPaxelItem OSMIUM_PAXEL = registerPaxel(MekanismToolsConfig.tools.osmium);
    public static final MekanismArmorItem OSMIUM_HELMET = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlot.HEAD);
    public static final MekanismArmorItem OSMIUM_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlot.CHEST);
    public static final MekanismArmorItem OSMIUM_LEGGINGS = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlot.LEGS);
    public static final MekanismArmorItem OSMIUM_BOOTS = registerArmor(MekanismToolsConfig.tools.osmium, EquipmentSlot.FEET);
    public static final MekanismShieldItem OSMIUM_SHIELD = registerShield(MekanismToolsConfig.tools.osmium);

    public static final MekanismPickaxeItem REFINED_GLOWSTONE_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismAxeItem REFINED_GLOWSTONE_AXE = registerAxe(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismShovelItem REFINED_GLOWSTONE_SHOVEL = registerShovel(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismHoeItem REFINED_GLOWSTONE_HOE = registerHoe(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismSwordItem REFINED_GLOWSTONE_SWORD = registerSword(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismPaxelItem REFINED_GLOWSTONE_PAXEL = registerPaxel(MekanismToolsConfig.tools.refinedGlowstone);
    public static final MekanismArmorItem REFINED_GLOWSTONE_HELMET = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlot.HEAD, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlot.CHEST, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_LEGGINGS = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlot.LEGS, true);
    public static final MekanismArmorItem REFINED_GLOWSTONE_BOOTS = registerArmor(MekanismToolsConfig.tools.refinedGlowstone, EquipmentSlot.FEET, true);
    public static final MekanismShieldItem REFINED_GLOWSTONE_SHIELD = registerShield(MekanismToolsConfig.tools.refinedGlowstone);

    public static final MekanismPickaxeItem REFINED_OBSIDIAN_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismAxeItem REFINED_OBSIDIAN_AXE = registerAxe(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismShovelItem REFINED_OBSIDIAN_SHOVEL = registerShovel(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismHoeItem REFINED_OBSIDIAN_HOE = registerHoe(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismSwordItem REFINED_OBSIDIAN_SWORD = registerSword(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismPaxelItem REFINED_OBSIDIAN_PAXEL = registerPaxel(MekanismToolsConfig.tools.refinedObsidian);
    public static final MekanismArmorItem REFINED_OBSIDIAN_HELMET = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlot.HEAD);
    public static final MekanismArmorItem REFINED_OBSIDIAN_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlot.CHEST);
    public static final MekanismArmorItem REFINED_OBSIDIAN_LEGGINGS = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlot.LEGS);
    public static final MekanismArmorItem REFINED_OBSIDIAN_BOOTS = registerArmor(MekanismToolsConfig.tools.refinedObsidian, EquipmentSlot.FEET);
    public static final MekanismShieldItem REFINED_OBSIDIAN_SHIELD = registerShield(MekanismToolsConfig.tools.refinedObsidian);

    public static final MekanismPickaxeItem STEEL_PICKAXE = registerPickaxe(MekanismToolsConfig.tools.steel);
    public static final MekanismAxeItem STEEL_AXE = registerAxe(MekanismToolsConfig.tools.steel);
    public static final MekanismShovelItem STEEL_SHOVEL = registerShovel(MekanismToolsConfig.tools.steel);
    public static final MekanismHoeItem STEEL_HOE = registerHoe(MekanismToolsConfig.tools.steel);
    public static final MekanismSwordItem STEEL_SWORD = registerSword(MekanismToolsConfig.tools.steel);
    public static final MekanismPaxelItem STEEL_PAXEL = registerPaxel(MekanismToolsConfig.tools.steel);
    public static final MekanismArmorItem STEEL_HELMET = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlot.HEAD);
    public static final MekanismArmorItem STEEL_CHESTPLATE = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlot.CHEST);
    public static final MekanismArmorItem STEEL_LEGGINGS = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlot.LEGS);
    public static final MekanismArmorItem STEEL_BOOTS = registerArmor(MekanismToolsConfig.tools.steel, EquipmentSlot.FEET);
    public static final MekanismShieldItem STEEL_SHIELD = registerShield(MekanismToolsConfig.tools.steel);

    public static void init() {

    }

    private static MekanismPaxelItem registerPaxel(Tiers material) {
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

    private static MekanismShieldItem registerShield(BaseMekanismMaterial material) {
        return register(material.getRegistryPrefix() + "_shield", () -> new MekanismShieldItem(material, getItemProperties(material)));
    }

    private static <T extends Item> T register(String name, Supplier<? extends T> supplier) {
        return ITEMS.register(name.toLowerCase(Locale.ROOT), supplier);
    }

    private static Item.Properties getItemProperties(Tier material) {
        FabricItemSettings properties = ItemRegistry.getMekBaseProperties();

        if (material == Tiers.NETHERITE) {
            properties = properties.fireproof();
        } else if (material instanceof BaseMekanismMaterial && !((BaseMekanismMaterial)material).burnsInFire()) {
            properties = properties.fireproof();
        }

        return properties;
    }
}
