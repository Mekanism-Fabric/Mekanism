package mekanism.api.providers;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public interface IEntityTypeProvider extends IBaseProvider {

    /**
     * Gets the entity type this provider represents.
     */
    @NotNull
    EntityType<?> getEntityType();

    @Override
    default ResourceLocation getRegistryName() {
        return getEntityType().getDefaultLootTable();
    }

    @Override
    default Component getTextComponent() {
        return getEntityType().getDescription();
    }

    @Override
    default String getTranslationKey() {
        return getEntityType().getDescriptionId();
    }
}