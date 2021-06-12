package mekanism.tools.mixins;

import mekanism.tools.events.EntitySpawnedEvent;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SpawnHelper.class)
public abstract class SpawnHelperMixin {

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/mob/MobEntity;initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/entity/EntityData;"
        ),
        method = "spawnEntitiesInChunk(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/SpawnHelper$Checker;Lnet/minecraft/world/SpawnHelper$Runner;)V",
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    private static void spawnEntitiesInChunk(SpawnGroup group, ServerWorld world, Chunk chunk, BlockPos pos, SpawnHelper.Checker checker, SpawnHelper.Runner runner, CallbackInfo callbackInfo, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, int i, BlockPos.Mutable mutable, int j, int k, int l, int m, int n, SpawnSettings.SpawnEntry spawnEntry, EntityData entityData, int o, int p, int q, double d, double e, PlayerEntity playerEntity, double f, MobEntity mobEntity) {
        EntitySpawnedEvent.EVENT.invoker().onEntitySpawned(mobEntity, world, (float) d, (float) i, (float) e, null, SpawnReason.NATURAL);
    }
}

