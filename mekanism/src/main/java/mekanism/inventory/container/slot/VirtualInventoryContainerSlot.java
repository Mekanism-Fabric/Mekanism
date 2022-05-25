package mekanism.inventory.container.slot;

import java.util.function.Consumer;
import java.util.function.IntSupplier;
import mekanism.inventory.container.SelectedWindowData;
import mekanism.inventory.slot.BasicInventorySlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VirtualInventoryContainerSlot extends InventoryContainerSlot implements IVirtualSlot {

    private final SelectedWindowData windowData;
    private IntSupplier xPositionSupplier = () -> x;
    private IntSupplier yPositionSupplier = () -> y;
    private ItemStack stackToRender = ItemStack.EMPTY;
    @Nullable
    private String tooltipOverride;
    private boolean shouldDrawOverlay;

    public VirtualInventoryContainerSlot(BasicInventorySlot slot, SelectedWindowData windowData, @Nullable SlotOverlay slotOverlay, Consumer<ItemStack> uncheckedSetter) {
        super(slot, 0, 0, ContainerSlotType.IGNORED, slotOverlay, null, uncheckedSetter);
        this.windowData = windowData;
    }

    @Override
    public int getActualX() {
        return xPositionSupplier.getAsInt();
    }

    @Override
    public int getActualY() {
        return yPositionSupplier.getAsInt();
    }

    @Override
    public void updatePosition(IntSupplier xPositionSupplier, IntSupplier yPositionSupplier) {
        this.xPositionSupplier = xPositionSupplier;
        this.yPositionSupplier = yPositionSupplier;
    }

    @Override
    public void updateRenderInfo(@NotNull ItemStack stackToRender, boolean shouldDrawOverlay, @Nullable String tooltipOverride) {
        this.stackToRender = stackToRender;
        this.shouldDrawOverlay = shouldDrawOverlay;
        this.tooltipOverride = tooltipOverride;
    }

    @NotNull
    @Override
    public ItemStack getStackToRender() {
        return stackToRender;
    }

    @Override
    public boolean shouldDrawOverlay() {
        return shouldDrawOverlay;
    }

    @Nullable
    @Override
    public String getTooltipOverride() {
        return tooltipOverride;
    }

    @Override
    public Slot getSlot() {
        return this;
    }

    @Override
    public boolean exists(@Nullable SelectedWindowData windowData) {
        return this.windowData.equals(windowData);
    }
}