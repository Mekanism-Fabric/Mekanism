package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(
        at = @At("HEAD"),
        method = "getEquipmentSlotForItem",
        cancellable = true
    )
    private static void getPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> callbackInfo) {
        if (stack.getItem() instanceof MekanismShieldItem) callbackInfo.setReturnValue(EquipmentSlot.OFFHAND);
    }

}
