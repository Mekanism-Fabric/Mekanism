package mekanism.item.interfaces;

import java.util.List;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public interface IItemHUDProvider {

    void addHUDStrings(List<Text> list, PlayerEntity player, ItemStack stack, EquipmentSlot slotType);
}