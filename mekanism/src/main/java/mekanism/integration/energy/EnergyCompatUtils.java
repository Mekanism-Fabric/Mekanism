package mekanism.integration.energy;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import mekanism.api.energy.IStrictEnergyHandler;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class EnergyCompatUtils {

    private EnergyCompatUtils() {
    }

    private static final List<IEnergyCompatItem> energyCompats = List.of(
            //We always have our own energy capability as the first one we check
            new StrictEnergyCompat()
            //Note: We check the Flux Networks capability above Forge's so that we allow it to use the higher throughput amount supported by Flux Networks
            //new FNEnergyCompat(),
            //We do Fabric bois
            //new ForgeEnergyCompat()
            //new TREnergyCompat()
    );

    public static List<IEnergyCompatItem> getCompats() {
        return energyCompats;
    }

    /**
     * Checks if it is a known and enabled energy capability
     */
    public static boolean isEnergyCapability(@Nonnull ItemApiLookup<?, ContainerItemContext> capability) {
        //The capability may not be registered if the mod that adds it is not loaded. In which case we can just
        // short circuit and not check if
        if (capability != null) {
            for (IEnergyCompatItem energyCompat : energyCompats) {
                if (energyCompat.isMatchingCapability(capability)) {
                    return energyCompat.isUsable();
                }
            }
        }
        return false;
    }

    /**
     * Gets all enabled energy capability integrations.
     */
    public static List<ItemApiLookup<?, ContainerItemContext>> getEnabledEnergyCapabilities() {
        return energyCompats.stream().filter(IEnergyCompatItem::isUsable).map(IEnergyCompatItem::getCapability).collect(Collectors.toList());
    }

    private static boolean isTileValid(@Nullable BlockEntity tile) {
        return tile != null && !tile.isRemoved() && tile.hasLevel();
    }

    public static boolean hasStrictEnergyHandler(@Nonnull ItemStack stack) {
        return !stack.isEmpty() && hasStrictEnergyHandler(stack, null);
    }

    public static boolean hasStrictEnergyHandler(@Nullable BlockEntity tile, Direction side) {
        return isTileValid(tile) && hasStrictEnergyHandler(tile, side);
    }

    private static boolean hasStrictEnergyHandler(ItemStack provider, Direction side) {
        //Keep the things as lazy so that we don't have to resolve anything when we are just checking for existence
        for (IEnergyCompatItem energyCompat : energyCompats) {
            if (energyCompat.isUsable() && energyCompat.isCapabilityPresent(provider)) {
                return true;
            }
        }
        return false;
    }

    @Nullable//TODO: Transition usages of this to getLazyStrictEnergyHandler?
    public static IStrictEnergyHandler getStrictEnergyHandler(@Nonnull ItemStack stack) {
        return getLazyStrictEnergyHandler(stack).resolve().orElse(null);
    }

    @Nonnull
    public static LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(@Nonnull ItemStack stack) {
        return stack.isEmpty() ? LazyOptional.empty() : getLazyStrictEnergyHandler(stack, null);
    }

    @Nonnull
    public static LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(@Nullable BlockEntity tile, Direction side) {
        return isTileValid(tile) ? getLazyStrictEnergyHandler(tile, side) : LazyOptional.empty();
    }

    @Nonnull
    private static LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(ItemStack provider, Direction side) {
        //TODO: Eventually look into making it so that we cache the handler we get back. Maybe by passing a listener
        // to this that we can give to the capability as we wrap the result into
        for (IEnergyCompatItem energyCompat : energyCompats) {
            if (energyCompat.isUsable()) {
                LazyOptional<IStrictEnergyHandler> handler = energyCompat.getLazyStrictEnergyHandler(provider, side);
                if (handler.isPresent()) {
                    return handler;
                }
            }
        }
        return LazyOptional.empty();
    }

    /**
     * @apiNote It is expected that isEnergyCapability is called before calling this method
     */
    @Nonnull
    public static <T> LazyOptional<T> getEnergyCapability(@Nonnull ItemApiLookup<T, ContainerItemContext> capability, @Nonnull IStrictEnergyHandler handler) {
        //The capability may not be registered if the mod that adds it is not loaded. In which case we can just
        // short circuit and not check if
        if (capability != null) {
            //Note: The methods that call this method cache the returned lazy optional properly
            for (IEnergyCompatItem energyCompat : energyCompats) {
                if (energyCompat.isUsable() && energyCompat.isMatchingCapability(capability)) {
                    //Note: This is a little ugly but this extra method ensures that the supplier's type does not get prematurely resolved
                    return energyCompat.getHandlerAs(handler).cast();
                }
            }
        }
        return LazyOptional.empty();
    }

    /**
     * Whether IC2 power should be used, taking into account whether it is installed or another mod is providing its API.
     *
     * @return if IC2 power should be used
     */
//    public static boolean useIC2() {
//        //TODO: IC2
//        return Mekanism.hooks.IC2Loaded/* && EnergyNet.instance != null*/ && !MekanismConfig.general.blacklistIC2.get();
//    }
}