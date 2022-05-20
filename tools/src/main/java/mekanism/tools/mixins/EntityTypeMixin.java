package mekanism.tools.mixins;

import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin<T extends Entity> {

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/world/ServerWorld;spawnEntityAndPassengers(Lnet/minecraft/entity/Entity;)V"
        ),
        method = "spawn",
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    public void spawn(ServerLevel world, @Nullable CompoundTag itemNbt, @Nullable Component name, @Nullable Player player, BlockPos pos, MobSpawnType spawnReason, boolean alignPosition, boolean invertY, CallbackInfoReturnable<T> callbackInfo, T entity) {
        if (!(entity instanceof Mob)) return;

        EntitySpawnedEvent.EVENT.invoker().onEntitySpawned(
            (Mob) entity, world, pos.getX(), pos.getY(), pos.getZ(), null, spawnReason
        );
    }
}