package mekanism.tile.interfaces;

import mekanism.api.Coord4D;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface ITileWrapper {

    BlockPos getTilePos();

    Level getTileWorld();

    default Coord4D getTileCoord() {
        return new Coord4D(getTilePos(), getTileWorld());
    }
}