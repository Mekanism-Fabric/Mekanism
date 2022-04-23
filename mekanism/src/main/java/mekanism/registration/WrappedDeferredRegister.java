package mekanism.registration;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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

    protected <I extends T, W extends WrappedRegistryObject<I>> W register(String name, Supplier<? extends I> sup, BiFunction<Identifier, I, W> objectWrapper) {
        return register(id(name), sup, objectWrapper);
    }

    protected <I extends T, W extends WrappedRegistryObject<I>> W register(Identifier identifier, Supplier<? extends I> sup, BiFunction<Identifier, I, W> objectWrapper) {
        return objectWrapper.apply(identifier, internal.register(identifier, sup));
    }

    public Identifier id(String path) {
        return internal.id(path);
    }
}
