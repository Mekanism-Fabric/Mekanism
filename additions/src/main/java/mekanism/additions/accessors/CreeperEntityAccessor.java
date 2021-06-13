package mekanism.additions.accessors;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CreeperEntity.class)
public interface CreeperEntityAccessor {

    @Accessor
    int getExplosionRadius();

    @Invoker
    void invokeSpawnEffectsCloud();

}
