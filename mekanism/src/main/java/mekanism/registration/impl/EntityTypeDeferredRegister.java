package mekanism.registration.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import mekanism.Mekanism;
import mekanism.registration.WrappedDeferredRegister;
import mekanism.registration.impl.EntityTypeRegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class EntityTypeDeferredRegister extends WrappedDeferredRegister<EntityType<?>> {

    public EntityTypeDeferredRegister(String modid) {
        super(modid, Registry.ENTITY_TYPE);
    }

    public <ENTITY extends LivingEntity> EntityTypeRegistryObject<ENTITY> register(String name, EntityType.Builder<ENTITY> builder, Supplier<AttributeSupplier.Builder> attributes) {
        EntityTypeRegistryObject<ENTITY> entityTypeRO = register(name, builder);
        FabricDefaultAttributeRegistry.register(entityTypeRO.getEntityType(), attributes.get());
        return entityTypeRO;
    }

    public <ENTITY extends Entity> EntityTypeRegistryObject<ENTITY> register(String name, EntityType.Builder<ENTITY> builder) {
        return register(name, () -> builder.build(name), EntityTypeRegistryObject::new);
    }

}