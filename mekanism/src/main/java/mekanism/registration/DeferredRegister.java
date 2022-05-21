package mekanism.registration;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

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
        this(FabricRegistryBuilder.createSimple(base, new ResourceLocation(modid, base.getName())).buildAndRegister(), base, modid);
    }

    private DeferredRegister(Registry<T> reg, Class<T> superType, String modid) {
        this.modid = modid;
        this.superType = superType;
        this.type = reg;
    }

    public ResourceLocation id(String path) {
        return new ResourceLocation(modid, path);
    }

    public <I extends T> I register(final String name, final Supplier<? extends I> sup) {
        return register(id(name), sup);
    }

    public <I extends T> I register(final ResourceLocation identifier, final Supplier<? extends I> sup) {
        return Registry.register(type, identifier, sup.get());
    }
}
