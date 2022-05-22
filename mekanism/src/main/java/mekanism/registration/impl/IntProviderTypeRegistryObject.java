package mekanism.registration.impl;

import mekanism.registration.WrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;

public class IntProviderTypeRegistryObject<PROVIDER extends IntProvider> extends WrappedRegistryObject<IntProviderType<PROVIDER>> {

    public IntProviderTypeRegistryObject(ResourceLocation identifier, IntProviderType<PROVIDER> registryObject) {
        super(identifier, registryObject);
    }
}