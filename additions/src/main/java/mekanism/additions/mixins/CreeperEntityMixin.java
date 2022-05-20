package mekanism.additions.mixins;

import mekanism.additions.entities.BabyCreeperEntity;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class CreeperEntityMixin {

    @Inject(
        at = @At("HEAD"),
        method = "explodeCreeper",
        cancellable = true
    )
    private void explode(CallbackInfo callbackInfo) {
        Creeper self = (Creeper) (Object) this;

        if (self instanceof BabyCreeperEntity) {
            ((BabyCreeperEntity) self).doExplosion();
            callbackInfo.cancel();
        }
    }

}
