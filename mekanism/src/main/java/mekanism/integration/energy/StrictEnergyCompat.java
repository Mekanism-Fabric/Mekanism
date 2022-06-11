package mekanism.integration.energy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.capabilities.Capabilities;
import mekanism.util.CapabilityUtils;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

@ParametersAreNonnullByDefault
public class StrictEnergyCompat implements IEnergyCompatItem {

    @Override
    public boolean isUsable() {
        return true;
    }

    @Nonnull
    @Override
    public ItemApiLookup<IStrictEnergyHandler, ContainerItemContext> getCapability() {
        return Capabilities.STRICT_ENERGY_CAPABILITY;
    }

    @Nonnull
    @Override
    public LazyOptional<IStrictEnergyHandler> getHandlerAs(IStrictEnergyHandler handler) {
        return LazyOptional.of(() -> handler);
    }

    @Nonnull
    @Override
    public LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(ItemStack provider, @Nullable Direction side) {
        return CapabilityUtils.getCapabilityItem(provider, getCapability());
    }
}