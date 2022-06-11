package mekanism.capabilities.resolver;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import mekanism.api.energy.ISidedStrictEnergyHandler;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.integration.energy.EnergyCompatUtils;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EnergyCapabilityResolverItem implements ICapabilityResolverItem {

    private final Map<ItemApiLookup<?, ContainerItemContext>, LazyOptional<?>> cachedCapabilities = new HashMap<>();
    private final IStrictEnergyHandler handler;

    public EnergyCapabilityResolverItem(IStrictEnergyHandler handler) {
        this.handler = handler;
    }

    @Override
    public List<ItemApiLookup<?, ContainerItemContext>> getSupportedCapabilities() {
        return EnergyCompatUtils.getEnabledEnergyCapabilities();
    }

    @Override
    public <T> LazyOptional<T> resolve(ItemApiLookup<T, ContainerItemContext> capability) {
        return getCachedOrResolve(capability, cachedCapabilities, handler);
    }

    @Override
    public void invalidate(ItemApiLookup<?, ContainerItemContext> capability) {
        invalidate(cachedCapabilities.get(capability));
    }

    @Override
    public void invalidateAll() {
        for (LazyOptional<?> lazyOptional : new ArrayList<>(cachedCapabilities.values())) {
            invalidate(lazyOptional);
        }
    }

    protected void invalidate(@Nullable LazyOptional<?> cachedCapability) {
        if (cachedCapability != null && cachedCapability.isPresent()) {
            cachedCapability.invalidate();
        }
    }

    public static <T> LazyOptional<T> getCachedOrResolve(ItemApiLookup<T, ContainerItemContext> capability, Map<ItemApiLookup<?, ContainerItemContext>, LazyOptional<?>> cachedCapabilities, IStrictEnergyHandler handler) {
        if (cachedCapabilities.containsKey(capability)) {
            //If we already contain a cached object for this lazy optional then get it and use it
            LazyOptional<?> cachedCapability = cachedCapabilities.get(capability);
            if (cachedCapability.isPresent()) {
                //If the capability is still present (valid), just return the cached object
                return cachedCapability.cast();
            }
        }
        LazyOptional<T> uncachedCapability = EnergyCompatUtils.getEnergyCapability(capability, handler);
        cachedCapabilities.put(capability, uncachedCapability);
        return uncachedCapability;
    }
}