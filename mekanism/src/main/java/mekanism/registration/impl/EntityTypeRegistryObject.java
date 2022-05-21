package mekanism.registration.impl;

import mekanism.api.providers.IEntityTypeProvider;
import mekanism.registration.WrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class EntityTypeRegistryObject<ENTITY extends Entity> extends WrappedRegistryObject<EntityType<ENTITY>> implements IEntityTypeProvider {

    public EntityTypeRegistryObject(ResourceLocation identifier, EntityType<ENTITY> registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    @Override
    public EntityType<ENTITY> getEntityType() {
        return get();
    }
}