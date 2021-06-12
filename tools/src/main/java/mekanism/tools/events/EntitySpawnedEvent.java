package mekanism.tools.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;

public final class EntitySpawnedEvent {
    public static Event<EntitySpawned> EVENT = EventFactory.createArrayBacked(EntitySpawned.class,
        (listeners) -> (entity, world, x, y, z, spawnerLogic, spawnReason) -> {
            for (EntitySpawned callback : listeners) {
                callback.onEntitySpawned(entity, world, x, y, z, spawnerLogic, spawnReason);
            }
        }
    );

    @FunctionalInterface
    public interface EntitySpawned {
        void onEntitySpawned(MobEntity entity, World world, float x, float y, float z, MobSpawnerLogic spawnerLogic, SpawnReason spawnReason);
    }
}
