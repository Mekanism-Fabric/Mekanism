package mekanism.additions.mixins;

import mekanism.additions.entities.BabyCreeperEntity;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    @Inject(
        at = @At("HEAD"),
        method = "explode",
        cancellable = true
    )
    private void explode(CallbackInfo callbackInfo) {
        CreeperEntity self = (CreeperEntity) (Object) this;

        if (self instanceof BabyCreeperEntity) {
            ((BabyCreeperEntity) self).doExplosion();
            callbackInfo.cancel();
        }
    }

}
