package mekanism.additions.accessors;

import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Creeper.class)
public interface CreeperEntityAccessor {

    @Accessor("explosionRadius")
    int getExplosionRadius();

    @Invoker("spawnLingeringCloud")
    void spawnLingeringCloud();

}
