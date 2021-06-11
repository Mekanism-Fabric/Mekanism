package mekanism.tools.materials;

import mekanism.tools.MekanismTools;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.jetbrains.annotations.NotNull;

public abstract class BaseMekanismMaterial implements ToolMaterial, ArmorMaterial {

    public abstract int getShieldDurability();

    public float getSwordDamage() {
        return 3;
    }

    public float getSwordAtkSpeed() {
        return -2.4F;
    }

    public float getShovelDamage() {
        return 1.5F;
    }

    public float getShovelAtkSpeed() {
        return -3.0F;
    }

    public abstract float getAxeDamage();

    public abstract float getAxeAtkSpeed();

    public float getPickaxeDamage() {
        return 1;
    }

    public float getPickaxeAtkSpeed() {
        return -2.8F;
    }

    public float getHoeDamage() {
        //Default to match the vanilla hoe's implementation of being negative the attack damage of the material
        return -getAttackDamage();
    }

    public float getHoeAtkSpeed() {
        return getAttackDamage() - 3.0F;
    }

    public abstract float getPaxelDamage();

    public float getPaxelAtkSpeed() {
        return -2.4F;
    }

    public abstract int getPaxelHarvestLevel();

    public abstract int getPaxelMaxUses();

    public abstract float getPaxelEfficiency();

    @NotNull
    public abstract String getRegistryPrefix();

    public abstract int getPaxelEnchantability();

    @Override
    public abstract int getEnchantability();

    public boolean burnsInFire() {
        return true;
    }

    @NotNull
    public abstract Ingredient getRepairIngredient();

    @NotNull
    @Override
    public String getName() {
        return MekanismTools.MODID + ":" + getRegistryPrefix();
    }

}
