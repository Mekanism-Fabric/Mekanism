package mekanism.tools.material.impl;

import mekanism.tags.MekanismTags;
import mekanism.tools.ToolsTags;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SteelMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 448;
    }

    @Override
    public float getAxeDamage() {
        return 7;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.0F;
    }

    @Override
    public int getUses() {
        return 500;
    }

    @Override
    public float getSpeed() {
        return 8;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getCommonEnchantability() {
        return 16;
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET -> 260;
            case LEGS -> 300;
            case CHEST -> 320;
            case HEAD -> 220;
            default -> 0;
        };
    }

    @Override
    public int getDefenseForSlot(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET -> 3;
            case LEGS -> 6;
            case CHEST -> 8;
            case HEAD -> 3;
            default -> 0;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Steel";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "steel";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return ToolsTags.Blocks.NEEDS_STEEL_TOOL;
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.of(MekanismTags.Items.INGOTS_STEEL);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}