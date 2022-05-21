package mekanism.registration;

import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.minecraft.util.Identifier;
import net.minecraft.util.annotation.FieldsAreNonnullByDefault;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
public class WrappedRegistryObject<T> implements Supplier<T>, INamedEntry {

    protected Identifier identifier;
    protected T registryObject;

    protected WrappedRegistryObject(Identifier identifier, T registryObject) {
        this.identifier = identifier;
        this.registryObject = registryObject;
    }

    @NotNull
    @Override
    public T get() {
        return registryObject;
    }

    @Override
    public String getInternalRegistryName() {
        return identifier.getPath();
    }
}
