package mekanism.capabilities.resolver;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface ICapabilityResolverBlock {

    /**
     * Gets the list of capabilities this resolver is able to resolve.
     *
     * @return List of capabilities this resolver can resolve.
     */
    List<BlockApiLookup<?, @Nullable Direction>> getSupportedCapabilities();

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
    <T> LazyOptional<T> resolve(BlockApiLookup<T, @Nullable Direction> capability, @Nullable Direction side);

    /**
     * Invalidates the given capability on the given side.
     *
     * @param capability Capability
     */
    void invalidate(BlockApiLookup<?, @Nullable Direction> capability, @Nullable Direction side);

    /**
     * Invalidates all cached capabilities.
     */
    void invalidateAll();
}