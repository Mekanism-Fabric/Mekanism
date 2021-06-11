package mekanism.tools.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class OsmiumMaterialDefaults extends BaseMekanismMaterial {

    public static final String name = "osmium";

    @Override
    public int getShieldDurability() {
        return 1_344;
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
        return 5;
    }

    @Override
    public int getPaxelHarvestLevel() {
        return 3;
    }

    @Override
    public int getPaxelMaxUses() {
        return 700;
    }

    @Override
    public float getPaxelEfficiency() {
        return 12;
    }

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET  -> 390;
            case LEGS  -> 450;
            case CHEST -> 480;
            case HEAD  -> 330;
            default    -> 0;
        };
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slotType) {
        return switch (slotType) {
            case FEET, HEAD -> 3;
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
        return 16;
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
        //return Ingredient.of(MekanismTags.Items.PROCESSED_RESOURCES.get(ResourceType.INGOT, PrimaryResource.OSMIUM));
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}
