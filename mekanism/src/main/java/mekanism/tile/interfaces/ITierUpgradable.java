package mekanism.tile.interfaces;

import mekanism.upgrade.IUpgradeData;
import org.jetbrains.annotations.Nullable;

public interface ITierUpgradable {

    boolean canBeUpgraded();

    /**
     * @return The upgrade data for this block or null if something went wrong
     */
    @Nullable
    default IUpgradeData getUpgradeData() {
        return null;
    }
}