package mekanism.capabilities;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import mekanism.Mekanism;
import mekanism.capabilities.resolver.ICapabilityResolverBlock;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.function.BooleanSupplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CapabilityCacheBlock {

    private final Map<BlockApiLookup<?, @Nullable Direction>, ICapabilityResolverBlock> capabilityResolvers = new HashMap<>();
    /**
     * List of unique resolvers to make invalidating all easier as some resolvers (energy) may support multiple capabilities.
     */
    private final List<ICapabilityResolverBlock> uniqueResolvers = new ArrayList<>();
    private final Set<BlockApiLookup<?, @Nullable Direction>> alwaysDisabled = new HashSet<>();
    private final Map<BlockApiLookup<?, @Nullable Direction>, List<BooleanSupplier>> semiDisabled = new HashMap<>();
//    private TileComponentConfig config;

    /**
     * Adds a capability resolver to the list of resolvers for this cache.
     */
    public void addCapabilityResolver(ICapabilityResolverBlock resolver) {
        uniqueResolvers.add(resolver);
        List<BlockApiLookup<?, @Nullable Direction>> supportedCapabilities = resolver.getSupportedCapabilities();
        for (BlockApiLookup<?, @Nullable Direction> supportedCapability : supportedCapabilities) {
            //Note: We add the capability regardless of if it is registered as we will just short circuit and always disable the capability
            // if it isn't in use by the time the capability is queried. In theory we shouldn't ever be getting created before the capabilities
            // have been registered, but just in case we ensure it works properly
            if (capabilityResolvers.put(supportedCapability, resolver) != null) {
                Mekanism.logger.warn("Multiple capability resolvers registered for {}. Overriding", supportedCapability.toString(), new Exception());
            }
        }
    }

    /**
     * Marks all the given capabilities as always being disabled.
     */
    public void addDisabledCapabilities(BlockApiLookup<?, @Nullable Direction>... capabilities) {
        Collections.addAll(alwaysDisabled, capabilities);
    }

    /**
     * Marks all the given capabilities as always being disabled.
     */
    public void addDisabledCapabilities(Collection<BlockApiLookup<?, @Nullable Direction>> capabilities) {
        alwaysDisabled.addAll(capabilities);
    }

    /**
     * Marks the given capability as having a check for sometimes being disabled.
     *
     * @implNote These "semi disabled" checks are stored in a list so that children can define more cases a capability should be disabled than the ones the parent already
     * wants them to be disabled in.
     */
    public void addSemiDisabledCapability(BlockApiLookup<?, @Nullable Direction> capability, BooleanSupplier checker) {
        semiDisabled.computeIfAbsent(capability, cap -> new ArrayList<>()).add(checker);
    }

    /**
     * Adds the given config component for use in checking if capabilities are disabled on a specific side.
     */
//    public void addConfigComponent(TileComponentConfig config) {
//        if (this.config != null) {
//            Mekanism.logger.warn("Config component already registered. Overriding", new Exception());
//        }
//        this.config = config;
//    }

    /**
     * Checks if the given capability is disabled for the specific side.
     *
     * @return {@code true} if the capability is disabled, {@code false} otherwise.
     */
//    public boolean isCapabilityDisabled(BlockApiLookup<?, @Nullable Direction> capability, @Nullable Direction side) {
//        //Treat unregistered capabilities as being disabled to skip and further logic relating to them
//        if (!capability.isRegistered() || alwaysDisabled.contains(capability)) {
//            return true;
//        }
//        if (semiDisabled.containsKey(capability)) {
//            List<BooleanSupplier> predicates = semiDisabled.get(capability);
//            for (BooleanSupplier predicate : predicates) {
//                if (predicate.getAsBoolean()) {
//                    return true;
//                }
//            }
//        }
//        if (config == null) {
//            return false;
//        }
//        return config.isCapabilityDisabled(capability, side);
//    }

    /**
     * Checks if the given capability can be resolved by this capability cache.
     */
    public boolean canResolve(BlockApiLookup<?, @Nullable Direction> capability) {
        return capabilityResolvers.containsKey(capability);
    }

    /**
     * Gets a capability on the given side, ensuring that it can be resolved and that it is not disabled.
     */
//    public <T> LazyOptional<T> getCapability(BlockApiLookup<T, @Nullable Direction> capability, @Nullable Direction side) {
//        if (!isCapabilityDisabled(capability, side) && canResolve(capability)) {
//            return getCapabilityUnchecked(capability, side);
//        }
//        return LazyOptional.empty();
//    }

    /**
     * Gets a capability on the given side not checking to ensure that it is not disabled.
     */
    public <T> LazyOptional<T> getCapabilityUnchecked(BlockApiLookup<T, @Nullable Direction> capability, @Nullable Direction side) {
        ICapabilityResolverBlock capabilityResolver = capabilityResolvers.get(capability);
        if (capabilityResolver == null) {
            return LazyOptional.empty();
        }
        return capabilityResolver.resolve(capability, side);
    }

    /**
     * Invalidates the given capability on the given side.
     *
     * @param capability Capability
     */
    public void invalidate(BlockApiLookup<?, @Nullable Direction> capability, @Nullable Direction side) {
        ICapabilityResolverBlock capabilityResolver = capabilityResolvers.get(capability);
        if (capabilityResolver != null) {
            capabilityResolver.invalidate(capability, side);
        }
    }

    /**
     * Invalidates all cached capabilities.
     */
    public void invalidateAll() {
        uniqueResolvers.forEach(ICapabilityResolverBlock::invalidateAll);
    }
}