package mekanism.tools.mixins;

import mekanism.tools.items.IHazPiglinInfluence;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public abstract class PiglinBrainMixin {

    @Inject(
        at = @At("RETURN"),
        method = "isWearingGold",
        cancellable = true
    )
    private static void wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> callbackInfo) {
        if (callbackInfo.getReturnValue()) return;

        for (ItemStack itemstack : entity.getArmorSlots()) {
            Item item = itemstack.getItem();

            if (item instanceof IHazPiglinInfluence && ((IHazPiglinInfluence) item).isPiglinCalming()) {
                callbackInfo.setReturnValue(true);
            }
        }
    }
}
