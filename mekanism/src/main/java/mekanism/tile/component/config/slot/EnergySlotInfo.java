package mekanism.tile.component.config.slot;

import java.util.List;
import mekanism.api.energy.IEnergyContainer;

public class EnergySlotInfo extends BaseSlotInfo {

    private final List<IEnergyContainer> containers;

    public EnergySlotInfo(boolean canInput, boolean canOutput, IEnergyContainer... containers) {
        this(canInput, canOutput, List.of(containers));
    }

    public EnergySlotInfo(boolean canInput, boolean canOutput, List<IEnergyContainer> containers) {
        super(canInput, canOutput);
        this.containers = containers;
    }

    public List<IEnergyContainer> getContainers() {
        return containers;
    }
}