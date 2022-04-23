package mekanism.registration.impl;

import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.ModuleData;
import mekanism.api.providers.IModuleDataProvider;
import mekanism.registration.WrappedRegistryObject;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class ModuleRegistryObject<MODULE extends ICustomModule<MODULE>> extends WrappedRegistryObject<ModuleData<MODULE>> implements IModuleDataProvider<MODULE> {

    public ModuleRegistryObject(Identifier identifier, ModuleData<MODULE> registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    @Override
    public ModuleData<MODULE> getModuleData() {
        return get();
    }
}