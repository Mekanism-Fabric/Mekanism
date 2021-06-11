package mekanism.tools.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class BronzeMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "bronze";

    @Override
    public int getShieldDurability() {
        return 1_568;
    }

    @Override
    public float getAxeDamage() {
        return 2;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.1F;
    }

    @Override
    public float getPaxelDamage() {
        return 8;
    }

    @Override
    public int getPaxelHarvestLevel() {
        return 3;
    }

    @Override
    public int getPaxelMaxUses() {
        return 1_100;
    }

    @Override
    public float getPaxelEfficiency() {
        return 16;
    }

    @Override
    public int getDurability() {
        return 800;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 14;
    }

    @Override
    public float getAttackDamage() {
        return 6;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 455;
            case LEGS  -> 525;
            case CHEST -> 560;
            case HEAD  -> 385;
            default    -> 0;
        };
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 2;
            case LEGS  -> 5;
            case CHEST -> 6;
            case HEAD  -> 3;
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
        return 14;
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
        //return Ingredient.fromTag(MekanismTags.Items.INGOTS_BRONZE);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}
