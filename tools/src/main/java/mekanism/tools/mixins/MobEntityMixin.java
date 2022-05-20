package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mob.class)
public abstract class MobEntityMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
        ),
        method = "maybeDisableShield"
    )
    private boolean disablePlayerShieldIsOf(ItemStack playerStack, Item item) {
        if (playerStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) return true;

        return playerStack.is(item);
    }

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemCooldowns;addCooldown(Lnet/minecraft/world/item/Item;I)V"
        ),
        method = "maybeDisableShield"
    )
    private void disablePlayerShield(ItemCooldowns itemCooldownManager, Item item, int duration, Player player, ItemStack mobStack, ItemStack playerStack) {
        if (playerStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            itemCooldownManager.addCooldown(playerStack.getItem(), duration);
        } else {
            itemCooldownManager.addCooldown(item, duration);
        }
    }

}
