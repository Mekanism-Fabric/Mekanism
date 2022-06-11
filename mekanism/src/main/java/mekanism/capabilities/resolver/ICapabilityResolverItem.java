package mekanism.capabilities.resolver;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface ICapabilityResolverItem {

    /**
     * Gets the list of capabilities this resolver is able to resolve.
     *
     * @return List of capabilities this resolver can resolve.
     */
    List<ItemApiLookup<?, ContainerItemContext>> getSupportedCapabilities();

    /**
     * Resolves a given capability from a given side. This value should be cached for later invalidation, as well as quicker re-lookup.
     *
     * @param capability Capability
     *
     * @return LazyOptional for the given capability
     *
     * @apiNote This method should only be called with capabilities that are in {@link #getSupportedCapabilities()}
     * @implNote The result should be cached
     */
    <T> LazyOptional<T> resolve(ItemApiLookup<T, ContainerItemContext> capability);

    /**
     * Invalidates the given capability on the given side.
     *
     * @param capability Capability
     */
    void invalidate(ItemApiLookup<?, ContainerItemContext> capability);

    /**
     * Invalidates all cached capabilities.
     */
    void invalidateAll();
}