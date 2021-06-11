package mekanism.tools.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class SteelMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "steel";

    @Override
    public int getShieldDurability() {
        return 1_792;
    }

    @Override
    public float getAxeDamage() {
        return 4;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.0F;
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
        return 1_250;
    }

    @Override
    public float getPaxelEfficiency() {
        return 18;
    }

    @Override
    public int getDurability() {
        return 850;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 14;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 520;
            case LEGS  -> 600;
            case CHEST -> 640;
            case HEAD  -> 440;
            default    -> 0;
        };
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET, HEAD -> 3;
            case LEGS  -> 6;
            case CHEST -> 7;
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
        //return Ingredient.of(MekanismTags.Items.INGOTS_STEEL);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}
