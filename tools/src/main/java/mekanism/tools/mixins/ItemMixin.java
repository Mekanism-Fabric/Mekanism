package mekanism.tools.mixins;

import mekanism.tools.items.IHazCustomMaxDamage;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow @Final private int maxDamage;

    @Inject(
        at = @At("RETURN"),
        method = "getMaxDamage",
        cancellable = true
    )
    public void getMaxDamage(CallbackInfoReturnable<Integer> callbackInfo) {
        Item self = (Item) (Object) this;

        if (self instanceof IHazCustomMaxDamage) {
            callbackInfo.setReturnValue(((IHazCustomMaxDamage) self).getCustomMaxDamage(this.maxDamage));
        }
    }

}
