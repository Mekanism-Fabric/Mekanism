package mekanism.tile.interfaces;

public interface IComparatorSupport {

    default boolean supportsComparator() {
        return true;
    }

    int getRedstoneLevel();

    int getCurrentRedstoneLevel();
}