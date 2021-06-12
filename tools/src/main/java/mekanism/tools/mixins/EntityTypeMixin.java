package mekanism.tools.mixins;

import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
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
    public void spawn(ServerWorld world, @Nullable NbtCompound itemNbt, @Nullable Text name, @Nullable PlayerEntity player, BlockPos pos, SpawnReason spawnReason, boolean alignPosition, boolean invertY, CallbackInfoReturnable<T> callbackInfo, T entity) {
        if (!(entity instanceof MobEntity)) return;

        EntitySpawnedEvent.EVENT.invoker().onEntitySpawned(
            (MobEntity) entity, world, pos.getX(), pos.getY(), pos.getZ(), null, spawnReason
        );
    }
}