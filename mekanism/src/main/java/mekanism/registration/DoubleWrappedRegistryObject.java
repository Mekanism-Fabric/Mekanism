package mekanism.registration;

import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@ParametersAreNonnullByDefault
public class DoubleWrappedRegistryObject<PRIMARY, SECONDARY> implements INamedEntry {

    private final ResourceLocation identifier;
    private final PRIMARY primaryRO;
    private final SECONDARY secondaryRO;

    public DoubleWrappedRegistryObject(ResourceLocation identifier, PRIMARY primaryRO, SECONDARY secondaryRO) {
        this.identifier = identifier;
        this.primaryRO = primaryRO;
        this.secondaryRO = secondaryRO;
    }

    @NotNull
    public PRIMARY getPrimary() {
        return primaryRO;
    }

    @NotNull
    public SECONDARY getSecondary() {
        return secondaryRO;
    }

    @Override
    public String getInternalRegistryName() {
        return identifier.getPath();
    }
}