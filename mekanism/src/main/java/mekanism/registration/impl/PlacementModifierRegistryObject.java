package mekanism.registration.impl;

import mekanism.registration.WrappedRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class PlacementModifierRegistryObject<PROVIDER extends PlacementModifier> extends WrappedRegistryObject<PlacementModifierType<PROVIDER>> {

    public PlacementModifierRegistryObject(ResourceLocation identifier, PlacementModifierType<PROVIDER> registryObject) {
        super(identifier, registryObject);
    }
}