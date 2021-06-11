package mekanism.tools.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class RefinedObsidianMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "refined_obsidian";

    @Override
    public int getShieldDurability() {
        return 2_240;
    }

    @Override
    public float getAxeDamage() {
        return 2;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2;
    }

    @Override
    public float getPaxelDamage() {
        return 4;
    }

    @Override
    public int getPaxelHarvestLevel() {
        return 3;
    }

    @Override
    public int getPaxelMaxUses() {
        return 3_000;
    }

    @Override
    public float getPaxelEfficiency() {
        return 25;
    }

    @Override
    public int getDurability() {
        return 2_500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20;
    }

    @Override
    public float getAttackDamage() {
        return 10;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 40;
    }

    @Override
    public boolean burnsInFire() {
        return false;
    }

    @Override
    public float getToughness() {
        return 4;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 650;
            case LEGS  -> 750;
            case CHEST -> 800;
            case HEAD  -> 550;
            default    -> 0;
        };
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET, HEAD -> 5;
            case LEGS  -> 8;
            case CHEST -> 12;
            default    -> 0;
        };
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return name;
    }

    @Override
    public int getPaxelEnchantability() {
        return 50;
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
        // ToDo: Update once we add tags/items for this.
        //return Ingredient.of(MekanismTags.Items.INGOTS_REFINED_OBSIDIAN);
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }

}
