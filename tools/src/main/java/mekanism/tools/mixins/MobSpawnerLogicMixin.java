package mekanism.tools.mixins;

import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;

@Mixin(MobSpawnerLogic.class)
public abstract class MobSpawnerLogicMixin {

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/mob/MobEntity;initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/entity/EntityData;"
        ),
        method = "serverTick",
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    public void serverTick(ServerWorld world, BlockPos pos, CallbackInfo callbackInfo, boolean bl, int i, NbtCompound nbtCompound, Optional<EntityType<?>> optional, NbtList nbtList, int j, double d, double e, double f, Entity entity) {
        EntitySpawnedEvent.EVENT.invoker().onEntitySpawned((MobEntity) entity, world, (float)entity.getX(), (float)entity.getY(), (float)entity.getZ(), (MobSpawnerLogic) (Object) this, SpawnReason.SPAWNER);
    }

}
