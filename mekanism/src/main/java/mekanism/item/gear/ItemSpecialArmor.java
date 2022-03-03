package mekanism.item.gear;

import mekanism.item.interfaces.ISpecialGear;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public abstract class ItemSpecialArmor extends ArmorItem implements ISpecialGear {

    protected ItemSpecialArmor(ArmorMaterial material, EquipmentSlot slot, Settings properties) {
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
        return type.getEnchantability() > 0 && super.isEnchantable(stack);
    }

}