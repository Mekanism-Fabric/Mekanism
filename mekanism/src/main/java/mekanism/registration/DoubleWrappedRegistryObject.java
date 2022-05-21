package mekanism.registration;

import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.minecraft.util.Identifier;
import net.minecraft.util.annotation.FieldsAreNonnullByDefault;
import org.jetbrains.annotations.NotNull;

@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
public class DoubleWrappedRegistryObject<PRIMARY, SECONDARY> implements INamedEntry {

    private final Identifier identifier;
    private final PRIMARY primaryRO;
    private final SECONDARY secondaryRO;

    public DoubleWrappedRegistryObject(Identifier identifier, PRIMARY primaryRO, SECONDARY secondaryRO) {
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