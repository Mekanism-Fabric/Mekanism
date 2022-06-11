package mekanism.capabilities.holder;

import javax.annotation.Nullable;
import net.minecraft.core.Direction;

public interface IHolder {

    default boolean canInsert(@Nullable Direction direction) {
        return true;
    }

    default boolean canExtract(@Nullable Direction direction) {
        return true;
    }
}