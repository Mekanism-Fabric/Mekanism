package mekanism.registration;

import net.minecraft.data.client.model.BlockStateVariantMap;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DoubleDeferredRegister<PRIMARY, SECONDARY> {

    private final DeferredRegister<PRIMARY> primaryRegister;
    private final DeferredRegister<SECONDARY> secondaryRegister;

    public DoubleDeferredRegister(String modid, Registry<PRIMARY> primaryRegistry, Registry<SECONDARY> secondaryRegistry) {
        primaryRegister = DeferredRegister.create(primaryRegistry, modid);
        secondaryRegister = DeferredRegister.create(secondaryRegistry, modid);
    }

    public <P extends PRIMARY, S extends SECONDARY, W extends DoubleWrappedRegistryObject<P, S>> W register(String name, Supplier<? extends P> primarySupplier, Supplier<? extends S> secondarySupplier, BiFunction<P, S, W> objectWrapper) {
        return objectWrapper.apply(primaryRegister.register(name, primarySupplier), secondaryRegister.register(name, secondarySupplier));
    }

    public <P extends PRIMARY, S extends SECONDARY, W extends DoubleWrappedRegistryObject<P, S>> W register(String name, Supplier<? extends P> primarySupplier, Function<P, S> secondarySupplier, BlockStateVariantMap.TriFunction<Identifier, P, S, W> objectWrapper) {
        P primaryObject = primaryRegister.register(name, primarySupplier);
        return objectWrapper.apply(primaryRegister.id(name), primaryObject, secondaryRegister.register(name, () -> secondarySupplier.apply(primaryObject)));
    }
}
