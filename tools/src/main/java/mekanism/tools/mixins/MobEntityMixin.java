package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        ),
        method = "disablePlayerShield"
    )
    private boolean disablePlayerShieldIsOf(ItemStack playerStack, Item item) {
        if (playerStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) return true;

        return playerStack.isOf(item);
    }

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"
        ),
        method = "disablePlayerShield"
    )
    private void disablePlayerShield(ItemCooldownManager itemCooldownManager, Item item, int duration, PlayerEntity player, ItemStack mobStack, ItemStack playerStack) {
        if (playerStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            itemCooldownManager.set(playerStack.getItem(), duration);
        } else {
            itemCooldownManager.set(item, duration);
        }
    }

}
