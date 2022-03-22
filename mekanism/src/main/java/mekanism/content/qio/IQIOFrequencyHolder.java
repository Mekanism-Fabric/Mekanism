//package mekanism.content.qio;
//
//import mekanism.lib.frequency.FrequencyType;
//import mekanism.lib.frequency.IFrequencyHandler;
//import mekanism.lib.security.ISecurityTile;
//import mekanism.tile.interfaces.ITileWrapper;
//import org.jetbrains.annotations.Nullable;
//
//public interface IQIOFrequencyHolder extends ISecurityTile, IFrequencyHandler, ITileWrapper {
//
//    @Nullable
//    default QIOFrequency getQIOFrequency() {
//        return getFrequency(FrequencyType.QIO);
//    }
//
//    default List<QIOFrequency> getPublicFrequencies() {
//        return getPublicCache(FrequencyType.QIO);
//    }
//
//    default List<QIOFrequency> getPrivateFrequencies() {
//        return getPrivateCache(FrequencyType.QIO);
//    }
//}
