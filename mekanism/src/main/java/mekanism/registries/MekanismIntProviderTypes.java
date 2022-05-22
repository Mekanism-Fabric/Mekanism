package mekanism.registries;

import mekanism.Mekanism;
import mekanism.registration.impl.IntProviderTypeDeferredRegister;
import mekanism.registration.impl.IntProviderTypeRegistryObject;
import mekanism.world.ConfigurableConstantInt;
import mekanism.world.ConfigurableUniformInt;

public class MekanismIntProviderTypes {

    private MekanismIntProviderTypes() {
    }

    public static final IntProviderTypeDeferredRegister INT_PROVIDER_TYPES = new IntProviderTypeDeferredRegister(Mekanism.MODID);

    public static final IntProviderTypeRegistryObject<ConfigurableConstantInt> CONFIGURABLE_CONSTANT = INT_PROVIDER_TYPES.register("configurable_constant", ConfigurableConstantInt.CODEC);
    public static final IntProviderTypeRegistryObject<ConfigurableUniformInt> CONFIGURABLE_UNIFORM = INT_PROVIDER_TYPES.register("configurable_uniform", ConfigurableUniformInt.CODEC);

    public static void init() {
    }

}