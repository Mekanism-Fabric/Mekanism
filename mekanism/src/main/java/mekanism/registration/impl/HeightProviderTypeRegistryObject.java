package mekanism.registration.impl;

import mekanism.registration.WrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;

public class HeightProviderTypeRegistryObject<PROVIDER extends HeightProvider> extends WrappedRegistryObject<HeightProviderType<PROVIDER>> {

    public HeightProviderTypeRegistryObject(ResourceLocation identifier, HeightProviderType<PROVIDER> registryObject) {
        super(identifier, registryObject);
    }
}