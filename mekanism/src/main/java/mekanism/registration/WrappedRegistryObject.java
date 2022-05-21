package mekanism.registration;

import mekanism.api.annotations.ParametersAreNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@ParametersAreNonnullByDefault
public class WrappedRegistryObject<T> implements Supplier<T>, INamedEntry {

    protected ResourceLocation identifier;
    protected T registryObject;

    protected WrappedRegistryObject(ResourceLocation identifier, T registryObject) {
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
