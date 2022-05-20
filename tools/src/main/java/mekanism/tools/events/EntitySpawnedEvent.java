package mekanism.tools.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;

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
        void onEntitySpawned(Mob entity, Level world, float x, float y, float z, BaseSpawner spawnerLogic, MobSpawnType spawnReason);
    }
}
