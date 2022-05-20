package mekanism.tools.material.impl;

import mekanism.tags.MekanismTags;
import mekanism.tools.material.BaseMekanismMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class LapisLazuliMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 224;
    }

    @Override
    public float getAxeDamage() {
        return 4;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getUses() {
        return 128;
    }

    @Override
    public float getSpeed() {
        return 9;
    }

    @Override
    public float getAttackDamageBonus() {
        return 1;
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getCommonEnchantability() {
        return 32;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot slotType) {
        switch (slotType) {
            case FEET:
                return 130;
            case LEGS:
                return 150;
            case CHEST:
                return 160;
            case HEAD:
                return 110;
        }
        return 0;
    }

    @Override
    public int getDefenseForSlot(@NotNull EquipmentSlot slotType) {
        switch (slotType) {
            case FEET:
                return 1;
            case LEGS:
                return 3;
            case CHEST:
                return 4;
            case HEAD:
                return 1;
        }
        return 0;
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Lapis Lazuli";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "lapis_lazuli";
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.of(MekanismTags.Items.GEMS_LAPIS);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}