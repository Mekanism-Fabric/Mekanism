package mekanism.registration.impl;

import mekanism.api.providers.IEntityTypeProvider;
import mekanism.registration.WrappedRegistryObject;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class EntityTypeRegistryObject<ENTITY extends Entity> extends WrappedRegistryObject<EntityType<ENTITY>> implements IEntityTypeProvider {

    public EntityTypeRegistryObject(Identifier identifier, EntityType<ENTITY> registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    @Override
    public EntityType<ENTITY> getEntityType() {
        return get();
    }
}