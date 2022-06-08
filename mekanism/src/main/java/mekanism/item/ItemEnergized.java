package mekanism.item;

import mekanism.api.AutomationType;
import mekanism.api.annotations.NonNull;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.capabilities.energy.BasicEnergyContainer;
import mekanism.config.MekanismConfig;
import mekanism.util.StorageUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import team.reborn.energy.api.base.SimpleBatteryItem;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Predicate;

public class ItemEnergized extends Item implements SimpleBatteryItem {

    private final FloatingLongSupplier chargeRateSupplier;
    private final FloatingLongSupplier maxEnergySupplier;
    private final Predicate<@NonNull AutomationType> canExtract;
    private final Predicate<@NonNull AutomationType> canInsert;

    public ItemEnergized(FloatingLongSupplier chargeRateSupplier, FloatingLongSupplier maxEnergySupplier, Properties properties) {
        this(chargeRateSupplier, maxEnergySupplier, BasicEnergyContainer.manualOnly, BasicEnergyContainer.alwaysTrue, properties);
    }

    public ItemEnergized(FloatingLongSupplier chargeRateSupplier, FloatingLongSupplier maxEnergySupplier, Predicate<@NonNull AutomationType> canExtract,
          Predicate<@NonNull AutomationType> canInsert, Properties properties) {
        super(properties.stacksTo(1));
        this.chargeRateSupplier = chargeRateSupplier;
        this.maxEnergySupplier = maxEnergySupplier;
        this.canExtract = canExtract;
        this.canInsert = canInsert;
    }

    @Override
    public boolean isBarVisible(@Nonnull ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(@Nonnull ItemStack stack) {
        return StorageUtils.getEnergyBarWidth(stack);
    }

    @Override
    public int getBarColor(@Nonnull ItemStack stack) {
        return MekanismConfig.client.energyColor.get();
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, Level world, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        StorageUtils.addStoredEnergy(stack, tooltip, true);
    }

    @Override
    public void fillItemCategory(@Nonnull CreativeModeTab group, @Nonnull NonNullList<ItemStack> items) {
        super.fillItemCategory(group, items);
        if (allowdedIn(group)) {
            items.add(StorageUtils.getFilledEnergyVariant(new ItemStack(this), maxEnergySupplier.get()));
        }
    }

    protected FloatingLong getMaxEnergy(ItemStack stack) {
        return maxEnergySupplier.get();
    }

    protected FloatingLong getChargeRate(ItemStack stack) {
        return chargeRateSupplier.get();
    }

    @Override
    public long getEnergyCapacity() {
        return maxEnergySupplier.get().getValue();
    }

    @Override
    public long getEnergyMaxInput() {
        return chargeRateSupplier.get().getValue();
    }

    @Override
    public long getEnergyMaxOutput() {
        return chargeRateSupplier.get().getValue();
    }

//    @Override
//    protected void gatherCapabilities(List<ItemCapability> capabilities, ItemStack stack, CompoundTag nbt) {
//        super.gatherCapabilities(capabilities, stack, nbt);
//        //Note: We interact with this capability using "manual" as the automation type, to ensure we can properly bypass the energy limit for extracting
//        // Internal is used by the "null" side, which is what will get used for most items
//        capabilities.add(RateLimitEnergyHandler.create(() -> getChargeRate(stack), () -> getMaxEnergy(stack), canExtract, canInsert));
//    }

//    @Override
//    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
//        //Ignore NBT for energized items causing re-equip animations
//        return oldStack.getItem() != newStack.getItem();
//    }
//
//    @Override
//    public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) {
//        //Ignore NBT for energized items causing block break reset
//        return oldStack.getItem() != newStack.getItem();
//    }
}