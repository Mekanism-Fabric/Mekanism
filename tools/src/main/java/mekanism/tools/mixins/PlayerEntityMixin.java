package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
        ),
        method = "hurtCurrentlyUsedShield"
    )
    protected boolean damageShield(ItemStack itemStack, Item item) {
        if (itemStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            return true;
        }

        return itemStack.is(item);
    }

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemCooldowns;addCooldown(Lnet/minecraft/world/item/Item;I)V"
        ),
        method = "disableShield"
    )
    public void disableShield(ItemCooldowns itemCooldownManager, Item item, int duration) {
        Item activeItem = this.useItem.getItem();

        if (activeItem instanceof MekanismShieldItem && item == Items.SHIELD) {
            itemCooldownManager.addCooldown(activeItem, duration);
        } else {
            itemCooldownManager.addCooldown(item, duration);
        }

    }
}
