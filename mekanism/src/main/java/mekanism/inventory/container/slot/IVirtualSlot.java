package mekanism.inventory.container.slot;

import java.util.function.IntSupplier;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IVirtualSlot {

    int getActualX();

    int getActualY();

    void updatePosition(IntSupplier xPositionSupplier, IntSupplier yPositionSupplier);

    void updateRenderInfo(@NotNull ItemStack stackToRender, boolean shouldDrawOverlay, @Nullable String tooltipOverride);

    @NotNull
    ItemStack getStackToRender();

    boolean shouldDrawOverlay();

    @Nullable
    String getTooltipOverride();

    Slot getSlot();
}