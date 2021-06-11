package mekanism.tools.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class LapisLazuliMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "lapis_lazuli";

    @Override
    public int getShieldDurability() {
        return 582;
    }

    @Override
    public float getAxeDamage() {
        return 6;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -3.1F;
    }

    @Override
    public float getPaxelDamage() {
        return 6;
    }

    @Override
    public int getPaxelHarvestLevel() {
        return 2;
    }

    @Override
    public int getPaxelMaxUses() {
        return 250;
    }

    @Override
    public float getPaxelEfficiency() {
        return 6;
    }

    @Override
    public int getDurability() {
        return 200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 169;
            case LEGS  -> 195;
            case CHEST -> 208;
            case HEAD  -> 143;
            default    -> 0;
        };
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET, HEAD -> 2;
            case LEGS  -> 6;
            case CHEST -> 5;
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
        return 10;
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
        // ToDo: Update once we add tags/items for this.
        //return Ingredient.fromTag(Tags.Items.GEMS_LAPIS);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}
