//package mekanism.tile.interfaces;
//
//import java.util.List;
//import java.util.Set;
//import mekanism.api.Upgrade;
//import mekanism.api.Upgrade.IUpgradeInfoHandler;
//import mekanism.util.UpgradeUtils;
//import net.minecraft.network.chat.Component;
//
//public interface ITileUpgradable extends IUpgradeTile, IUpgradeInfoHandler {
//
//    Set<Upgrade> getSupportedUpgrade();
//
//    @Override
//    default List<Component> getInfo(Upgrade upgrade) {
//        return upgrade == Upgrade.SPEED ? UpgradeUtils.getExpScaledInfo(this, upgrade) : UpgradeUtils.getMultScaledInfo(this, upgrade);
//    }
//}