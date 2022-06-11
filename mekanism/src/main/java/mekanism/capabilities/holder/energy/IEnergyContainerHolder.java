package mekanism.capabilities.holder.energy;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mekanism.api.energy.IEnergyContainer;
import mekanism.capabilities.holder.IHolder;
import net.minecraft.core.Direction;

public interface IEnergyContainerHolder extends IHolder {

    @Nonnull
    List<IEnergyContainer> getEnergyContainers(@Nullable Direction side);
}