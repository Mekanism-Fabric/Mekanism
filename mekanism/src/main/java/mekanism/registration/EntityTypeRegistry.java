package mekanism.registration;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntityTypeRegistry {
    private final String modid;

    public EntityTypeRegistry(String modid) {
        this.modid = modid;
    }

    public <ENTITY extends LivingEntity> EntityType<ENTITY> register(String name, EntityType.Builder<ENTITY> builder, Supplier<DefaultAttributeContainer.Builder> attributes) {
        Identifier id = new Identifier(modid, name);
        EntityType<ENTITY> entityType = Registry.register(Registry.ENTITY_TYPE, id, builder.build(id.toString()));
        FabricDefaultAttributeRegistry.register(entityType, attributes.get());
        return entityType;
    }
}
