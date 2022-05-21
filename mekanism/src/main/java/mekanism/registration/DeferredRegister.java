package mekanism.registration;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class DeferredRegister<T> {
    private final String modid;
    private final Class<T> superType;
    private final Registry<T> type;

    public static <B> DeferredRegister<B> create(Registry<B> reg, String modid) {
        return new DeferredRegister<>(reg, modid);
    }

    public static <B> DeferredRegister<B> create(Class<B> base, String modid)
    {
        return new DeferredRegister<>(base, modid);
    }

    private DeferredRegister(Registry<T> reg, String modid) {
        this(reg, null, modid);
    }

    private DeferredRegister(Class<T> base, String modid) {
        this(FabricRegistryBuilder.createSimple(base, new Identifier(modid, base.getName())).buildAndRegister(), base, modid);
    }

    private DeferredRegister(Registry<T> reg, Class<T> superType, String modid) {
        this.modid = modid;
        this.superType = superType;
        this.type = reg;
    }

    public Identifier id(String path) {
        return new Identifier(modid, path);
    }

    public <I extends T> I register(final String name, final Supplier<? extends I> sup) {
        return register(id(name), sup);
    }

    public <I extends T> I register(final Identifier identifier, final Supplier<? extends I> sup) {
        return Registry.register(type, identifier, sup.get());
    }
}
