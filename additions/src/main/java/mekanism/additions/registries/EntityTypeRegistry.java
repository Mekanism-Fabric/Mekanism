package mekanism.additions.registries;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntityTypeRegistry {
    private final String modid;

    public EntityTypeRegistry(String modid) {
        this.modid = modid;
    }

    public <ENTITY extends LivingEntity> EntityType<ENTITY> register(String name, EntityType.Builder<ENTITY> builder, Supplier<AttributeSupplier.Builder> attributes) {
        ResourceLocation id = new ResourceLocation(modid, name);
        EntityType<ENTITY> entityType = Registry.register(Registry.ENTITY_TYPE, id, builder.build(id.toString()));
        FabricDefaultAttributeRegistry.register(entityType, attributes.get());
        return entityType;
    }
}
