package mekanism.util;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import io.github.fabricators_of_create.porting_lib.util.NonNullConsumer;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapabilityUtils {

    private CapabilityUtils() {
    }

    @NotNull
    public static <T> LazyOptional<T> getCapabilityBlock(Level world, BlockPos pos, Direction direction, @Nullable BlockApiLookup<T, @Nullable Direction> cap) {
        if (cap == null) {
            return LazyOptional.empty();
        }
        return (LazyOptional<T>) cap.find(world, pos, direction);
    }

    @NotNull
    public static <T> LazyOptional<T> getCapabilityItem(ItemStack provider, @Nullable ItemApiLookup<T, ContainerItemContext> cap) {
        if (provider == null || cap == null) {
            return LazyOptional.empty();
        }
        return (LazyOptional<T>) cap.find(provider, null);
    }

    /**
     * Helper to add listeners that don't care about the data type to lazy optionals. This makes it so when we have {@code LazyOptional<?>} we can add a listener to it
     * without having to deal with the fact that one is "capture of ?" and the listener is "?".
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void addListener(@NotNull LazyOptional<?> lazyOptional, @NotNull NonNullConsumer listener) {
        lazyOptional.addListener(listener);
    }
}