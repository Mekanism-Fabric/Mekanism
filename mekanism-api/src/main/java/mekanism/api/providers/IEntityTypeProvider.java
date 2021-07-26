package mekanism.api.providers;

import net.minecraft.entity.EntityType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public interface IEntityTypeProvider extends IBaseProvider {

    /**
     * Gets the entity type this provider represents.
     */
    @NotNull
    EntityType<?> getEntityType();

    @Override
    default Text getRegistryName() {
        return getEntityType().getName();
    }

    @Override
    default Text getTextComponent() {
        return getEntityType().getName();
    }

    @Override
    default String getTranslationKey() {
        return getEntityType().getTranslationKey();
    }
}