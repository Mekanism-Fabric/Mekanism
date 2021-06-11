package mekanism.tools.mixins;

import mekanism.tools.items.IHazPiglinInfluence;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {

    @Inject(
        at = @At("RETURN"),
        method = "wearsGoldArmor",
        cancellable = true
    )
    private static void wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> callbackInfo) {
        if (callbackInfo.getReturnValue()) return;

        for (ItemStack itemstack : entity.getArmorItems()) {
            Item item = itemstack.getItem();

            if (item instanceof IHazPiglinInfluence) {
                callbackInfo.setReturnValue(((IHazPiglinInfluence) item).isPiglinCalming());
                return;
            }
        }
    }
}
