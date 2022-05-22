package mekanism.registries;

import mekanism.Mekanism;
import mekanism.registration.impl.PlacementModifierDeferredRegister;
import mekanism.registration.impl.PlacementModifierRegistryObject;
import mekanism.world.DisableableFeaturePlacement;

public class MekanismPlacementModifiers {

    private MekanismPlacementModifiers() {
    }

    public static final PlacementModifierDeferredRegister PLACEMENT_MODIFIERS = new PlacementModifierDeferredRegister(Mekanism.MODID);

    public static final PlacementModifierRegistryObject<DisableableFeaturePlacement> DISABLEABLE = PLACEMENT_MODIFIERS.register("disableable", DisableableFeaturePlacement.CODEC);

    public static void init() {
    }

}