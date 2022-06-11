package mekanism.integration.energy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.util.CapabilityUtils;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

@ParametersAreNonnullByDefault
public interface IEnergyCompatItem {

    /**
     * Whether this energy compat is actually enabled.
     *
     * @return if this energy compat is enabled.
     */
    boolean isUsable();

    /**
     * Gets the capability this compat integrates with.
     *
     * @return The capability this compat is integrating with.
     */
    @Nonnull
    ItemApiLookup<?, ContainerItemContext> getCapability();

    /**
     * Checks if a given capability matches the capability that this {@link IEnergyCompatItem} is for.
     *
     * @param capability Capability to check
     *
     * @return {@code true} if the capability matches, {@code false} if it doesn't.
     */
    default boolean isMatchingCapability(ItemApiLookup<?, ContainerItemContext> capability) {
        return capability == getCapability();
    }

    /**
     * Checks if the given provider has this capability.
     *
     * @param provider Capability provider
     *
     * @return {@code true} if the provider has this {@link IEnergyCompatItem}'s capability, {@code false} otherwise
     *
     * @implNote The capabilities should be kept lazy so that they are not resolved if they are not needed yet.
     */
    default boolean isCapabilityPresent(ItemStack provider) {
        return CapabilityUtils.getCapabilityItem(provider, getCapability()).isPresent();
    }

    /**
     * Gets the {@link IStrictEnergyHandler} as a lazy optional for the capability this energy compat is for.
     *
     * @param handler The handler to wrap
     *
     * @return A lazy optional for this capability
     */
    @Nonnull
    LazyOptional<?> getHandlerAs(IStrictEnergyHandler handler);

    /**
     * Wraps the capability implemented in the provider into a lazy optional {@link IStrictEnergyHandler}, or returns {@code LazyOptional.empty()} if the capability is
     * not implemented.
     *
     * @param provider Capability provider
     * @param side     Side
     *
     * @return The capability implemented in the provider into an {@link IStrictEnergyHandler}, or {@code null} if the capability is not implemented.
     */
    @Nonnull
    LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(ItemStack provider, @Nullable Direction side);
}