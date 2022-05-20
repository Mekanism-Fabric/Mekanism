package mekanism.tools.material.impl;

import mekanism.tags.MekanismTags;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

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
        switch (slotType) {
            case FEET:
                return 260;
            case LEGS:
                return 300;
            case CHEST:
                return 320;
            case HEAD:
                return 220;
        }
        return 0;
    }

    @Override
    public int getDefenseForSlot(@NotNull EquipmentSlot slotType) {
        switch (slotType) {
            case FEET:
                return 3;
            case LEGS:
                return 6;
            case CHEST:
                return 8;
            case HEAD:
                return 3;
        }
        return 0;
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