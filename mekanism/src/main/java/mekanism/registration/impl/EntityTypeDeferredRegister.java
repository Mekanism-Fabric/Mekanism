package mekanism.registration.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import mekanism.Mekanism;
import mekanism.registration.WrappedDeferredRegister;
import mekanism.registration.impl.EntityTypeRegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.registry.Registry;

public class EntityTypeDeferredRegister extends WrappedDeferredRegister<EntityType<?>> {

    private Map<EntityTypeRegistryObject<? extends LivingEntity>, Supplier<DefaultAttributeContainer.Builder>> livingEntityAttributes = new HashMap<>();

    public EntityTypeDeferredRegister(String modid) {
        super(modid, Registry.ENTITY_TYPE);
    }

    public <ENTITY extends LivingEntity> EntityTypeRegistryObject<ENTITY> register(String name, EntityType.Builder<ENTITY> builder, Supplier<DefaultAttributeContainer.Builder> attributes) {
        EntityTypeRegistryObject<ENTITY> entityTypeRO = register(name, builder);
        livingEntityAttributes.put(entityTypeRO, attributes);
        return entityTypeRO;
    }

    public <ENTITY extends Entity> EntityTypeRegistryObject<ENTITY> register(String name, EntityType.Builder<ENTITY> builder) {
        return register(name, () -> builder.build(name), EntityTypeRegistryObject::new);
    }

    private void registerEntityAttributes(EntityType<? extends LivingEntity> type, DefaultAttributeContainer.Builder builder) {

        if (livingEntityAttributes == null) {
            Mekanism.logger.error("GlobalEntityTypeAttributes have already been set. This should not happen.");
        } else {
            //Register our living entity attributes
            for (Map.Entry<EntityTypeRegistryObject<? extends LivingEntity>, Supplier<DefaultAttributeContainer.Builder>> entry : livingEntityAttributes.entrySet()) {
                FabricDefaultAttributeRegistry.register(type, builder);
            }
            //And set the map to null to allow it to be garbage collected
            livingEntityAttributes = null;
        }
    }
}