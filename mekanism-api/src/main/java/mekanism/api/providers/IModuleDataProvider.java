package mekanism.api.providers;

import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.ModuleData;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public interface IModuleDataProvider<MODULE extends ICustomModule<MODULE>> extends IBaseProvider {

    /**
     * Gets the module data this provider represents.
     */
    @NotNull
    ModuleData<MODULE> getModuleData();

    @Override
    default ResourceLocation getRegistryName() {
        return getModuleData().getRegistryName();
    }

    @Override
    default String getTranslationKey() {
        return getModuleData().getTranslationKey();
    }
}