package mekanism.registration;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class WrappedDeferredRegister<T> {

    protected final DeferredRegister<T> internal;

    protected WrappedDeferredRegister(String modid, Registry<T> registry) {
        internal = DeferredRegister.create(registry, modid);
    }

    protected WrappedDeferredRegister(String modid, Class<T> base) {
        internal = DeferredRegister.create(base, modid);
    }

    protected <I extends T, W extends WrappedRegistryObject<I>> W register(String name, Supplier<? extends I> sup, BiFunction<ResourceLocation, I, W> objectWrapper) {
        return register(id(name), sup, objectWrapper);
    }

    protected <I extends T, W extends WrappedRegistryObject<I>> W register(ResourceLocation identifier, Supplier<? extends I> sup, BiFunction<ResourceLocation, I, W> objectWrapper) {
        return objectWrapper.apply(identifier, internal.register(identifier, sup));
    }

    public ResourceLocation id(String path) {
        return internal.id(path);
    }
}
