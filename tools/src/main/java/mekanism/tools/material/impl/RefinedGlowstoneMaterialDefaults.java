package mekanism.tools.material.impl;

import mekanism.tags.MekanismTags;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class RefinedGlowstoneMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 381;
    }

    @Override
    public float getAxeDamage() {
        return 6;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getUses() {
        return 384;
    }

    @Override
    public float getSpeed() {
        return 15;
    }

    @Override
    public float getAttackDamageBonus() {
        return 2;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getCommonEnchantability() {
        return 20;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot slotType) {
        switch (slotType) {
            case FEET:
                return 221;
            case LEGS:
                return 255;
            case CHEST:
                return 272;
            case HEAD:
                return 187;
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
        return "Refined Glowstone";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "refined_glowstone";
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.of(MekanismTags.Items.INGOTS_REFINED_GLOWSTONE);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}