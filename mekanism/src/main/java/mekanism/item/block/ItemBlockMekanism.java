package mekanism.item.block;

import mekanism.api.NBTConstants;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.api.tier.ITier;
import mekanism.util.ItemDataUtils;
import mekanism.util.MekanismUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemBlockMekanism<BLOCK extends Block> extends BlockItem {

    @NotNull
    private final BLOCK block;

    public ItemBlockMekanism(@NotNull BLOCK block, Properties properties) {
        super(block, properties);
        this.block = block;
    }

    @NotNull
    @Override
    public BLOCK getBlock() {
        return block;
    }

    public ITier getTier() {
        return null;
    }

    public EnumColor getTextColor(ItemStack stack) {
        ITier tier = getTier();
        return tier == null ? null : tier.getBaseTier().getTextColor();
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        EnumColor color = getTextColor(stack);
        if (color == null) {
            return super.getName(stack);
        }
        return TextComponentUtil.build(color, super.getName(stack));
    }

//    @Override
//    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
//        if (Attribute.has(getBlock(), AttributeEnergy.class)) {
//            //Ignore NBT for energized items causing re-equip animations
//            return oldStack.getItem() != newStack.getItem();
//        }
//        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
//    }
//
//    @Override
//    public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) {
//        if (Attribute.has(getBlock(), AttributeEnergy.class)) {
//            //Ignore NBT for energized items causing block break reset
//            return oldStack.getItem() != newStack.getItem();
//        }
//        return super.shouldCauseBlockBreakReset(oldStack, newStack);
//    }

//    protected void gatherCapabilities(List<ItemCapability> capabilities, ItemStack stack, CompoundTag nbt) {
//        if (Attribute.has(block, AttributeSecurity.class)) {
//            capabilities.add(new ItemStackSecurityObject());
//        }
//        if (Attribute.has(block, AttributeEnergy.class)) {
//            AttributeEnergy attributeEnergy = Attribute.get(block, AttributeEnergy.class);
//            FloatingLongSupplier maxEnergy;
//            AttributeUpgradeSupport upgradeSupport = Attribute.get(block, AttributeUpgradeSupport.class);
//            if (upgradeSupport != null && upgradeSupport.supportedUpgrades().contains(Upgrade.ENERGY)) {
//                //If our block supports energy upgrades, make a more dynamically updating cache for our item's max energy
//                maxEnergy = new UpgradeBasedFloatingLongCache(stack, attributeEnergy::getStorage);
//            } else {
//                //Otherwise, just return that the max is what the base max is
//                maxEnergy = attributeEnergy::getStorage;
//            }
//            capabilities.add(RateLimitEnergyHandler.create(maxEnergy, BasicEnergyContainer.manualOnly, BasicEnergyContainer.alwaysTrue));
//        }
//    }
//
//    @Override
//    public final ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
//        List<ItemCapability> capabilities = new ArrayList<>();
//        gatherCapabilities(capabilities, stack, nbt);
//        if (capabilities.isEmpty()) {
//            return super.initCapabilities(stack, nbt);
//        }
//        return new ItemCapabilityWrapper(stack, capabilities.toArray(ItemCapability[]::new));
//    }

    private static class UpgradeBasedFloatingLongCache implements FloatingLongSupplier {

        private final ItemStack stack;
        //TODO: Eventually fix this, ideally we want this to update the overall cached value if this changes because of the config
        // for how much energy a machine can store changes
        private final FloatingLongSupplier baseStorage;
        @Nullable
        private CompoundTag lastNBT;
        private FloatingLong value;

        private UpgradeBasedFloatingLongCache(ItemStack stack, FloatingLongSupplier baseStorage) {
            this.stack = stack;
            if (ItemDataUtils.hasData(stack, NBTConstants.COMPONENT_UPGRADE, Tag.TAG_COMPOUND)) {
                this.lastNBT = ItemDataUtils.getCompound(stack, NBTConstants.COMPONENT_UPGRADE).copy();
            } else {
                this.lastNBT = null;
            }
            this.baseStorage = baseStorage;
            this.value = MekanismUtils.getMaxEnergy(this.stack, this.baseStorage.get());
        }

        @NotNull
        @Override
        public FloatingLong get() {
            if (ItemDataUtils.hasData(stack, NBTConstants.COMPONENT_UPGRADE, Tag.TAG_COMPOUND)) {
                CompoundTag upgrades = ItemDataUtils.getCompound(stack, NBTConstants.COMPONENT_UPGRADE);
                if (lastNBT == null || !lastNBT.equals(upgrades)) {
                    lastNBT = upgrades.copy();
                    value = MekanismUtils.getMaxEnergy(stack, baseStorage.get());
                }
            } else if (lastNBT != null) {
                lastNBT = null;
                value = MekanismUtils.getMaxEnergy(stack, baseStorage.get());
            }
            return value;
        }
    }
}