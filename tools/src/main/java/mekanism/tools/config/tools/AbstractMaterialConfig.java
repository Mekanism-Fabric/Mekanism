package mekanism.tools.config.tools;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.tools.materials.BaseMekanismMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMaterialConfig extends BaseMekanismMaterial {

    @ConfigEntry.Gui.Excluded
    protected final BaseMekanismMaterial DEFAULT;

    public abstract int getHelmetDurability();
    public abstract int getChestplateDurability();
    public abstract int getLeggingDurability();
    public abstract int getBootDurability();

    public abstract int getHelmetArmor();
    public abstract int getChestplateArmor();
    public abstract int getLeggingArmor();
    public abstract int getBootArmor();

    protected AbstractMaterialConfig(BaseMekanismMaterial defaultMaterial) {
        this.DEFAULT = defaultMaterial;
    }

    @Override
    public @NotNull String getRegistryPrefix() {
        return DEFAULT.getRegistryPrefix();
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD  -> getHelmetDurability();
            case CHEST -> getChestplateDurability();
            case LEGS  -> getLeggingDurability();
            case FEET  -> getBootDurability();
            default    -> DEFAULT.getDurability(slot);
        };
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD  -> getHelmetArmor();
            case CHEST -> getChestplateArmor();
            case LEGS  -> getLeggingArmor();
            case FEET  -> getBootArmor();
            default    -> DEFAULT.getProtectionAmount(slot);
        };
    }

    @Override
    public SoundEvent getEquipSound() {
        return DEFAULT.getEquipSound();
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return DEFAULT.getRepairIngredient();
    }
}
