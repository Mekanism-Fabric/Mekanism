package mekanism.registries;

import mekanism.Mekanism;
import mekanism.registration.impl.HeightProviderTypeDeferredRegister;
import mekanism.registration.impl.HeightProviderTypeRegistryObject;
import mekanism.world.height.ConfigurableHeightProvider;

public class MekanismHeightProviderTypes {

    private MekanismHeightProviderTypes() {
    }

    public static final HeightProviderTypeDeferredRegister HEIGHT_PROVIDER_TYPES = new HeightProviderTypeDeferredRegister(Mekanism.MODID);

    public static final HeightProviderTypeRegistryObject<ConfigurableHeightProvider> CONFIGURABLE = HEIGHT_PROVIDER_TYPES.register("configurable", ConfigurableHeightProvider.CODEC);

    public static void init() {
    }
}