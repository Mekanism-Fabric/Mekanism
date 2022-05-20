package mekanism.item.gear;

import mekanism.item.interfaces.ISpecialGear;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class ItemSpecialArmor extends ArmorItem implements ISpecialGear {

    protected ItemSpecialArmor(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }
    /*
        TODO
    */
//    @Override
//    private Identifier getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return "mekanism:render/null_armor.png";
//    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return material.getEnchantmentValue() > 0 && super.isEnchantable(stack);
    }

}