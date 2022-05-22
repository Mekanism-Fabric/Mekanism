package mekanism.registration;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.heightproviders.HeightProviderType;

import java.util.function.Supplier;

public class DeferredRegister<T> {
    private final String modid;
    private final Class<T> superType;
    private final Registry<T> type;
    private final ResourceKey<Registry<T>> key;

    public static <B> DeferredRegister<B> create(Registry<B> reg, String modid) {
        return new DeferredRegister<>(reg, modid);
    }

    public static <B> DeferredRegister<B> create(Class<B> base, String modid)
    {
        return new DeferredRegister<>(base, modid);
    }

    public static <T> DeferredRegister<T> create(ResourceKey<Registry<T>> key, String modid) {
        return new DeferredRegister<>(key, modid);
    }

    private DeferredRegister(Registry<T> reg, String modid) {
        this(reg, null, modid, null);
    }

    private DeferredRegister(Class<T> base, String modid) {
        this(FabricRegistryBuilder.createSimple(base, new ResourceLocation(modid, base.getName())).buildAndRegister(), base, modid, null);
    }

    private DeferredRegister(ResourceKey<Registry<T>> key, String modid) {
        this((Registry<T>) Registry.REGISTRY.get(key.location()), null, modid, null);
    }

    private DeferredRegister(Registry<T> reg, Class<T> superType, String modid, ResourceKey<Registry<T>> key) {
        this.modid = modid;
        this.superType = superType;
        this.type = reg;
        this.key = key;
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
