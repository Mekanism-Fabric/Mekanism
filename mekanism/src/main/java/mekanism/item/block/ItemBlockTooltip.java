package mekanism.item.block;

import mekanism.block.interfaces.IHasDescription;
import mekanism.registration.impl.ItemDeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBlockTooltip<BLOCK extends Block & IHasDescription> extends ItemBlockMekanism<BLOCK> {

    private final boolean hasDetails;

    public ItemBlockTooltip(BLOCK block, Item.Properties properties) {
        this(block, false, properties);
    }

    public ItemBlockTooltip(BLOCK block) {
        this(block, true, ItemDeferredRegister.getMekBaseProperties().stacksTo(1));
    }

    protected ItemBlockTooltip(BLOCK block, boolean hasDetails, Item.Properties properties) {
        super(block, properties);
        this.hasDetails = hasDetails;
    }

//    @Override
//    public void onDestroyed(@NotNull ItemEntity item, @NotNull DamageSource damageSource) {
//        //Try to drop the inventory contents if we are a block item that persists our inventory
//        InventoryUtils.dropItemContents(item, damageSource);
//    }
//
//    @Override
//    public boolean placeBlock(@NotNull BlockPlaceContext context, @NotNull BlockState state) {
//        AttributeHasBounding hasBounding = Attribute.get(state, AttributeHasBounding.class);
//        return (hasBounding == null || WorldUtils.areBlocksValidAndReplaceable(context.getLevel(), hasBounding.getPositions(context.getClickedPos(), state))) &&
//               super.placeBlock(context, state);
//    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
//        if (MekKeyHandler.isKeyPressed(MekanismKeyHandler.descriptionKey)) {
//            tooltip.add(getBlock().getDescription().translate());
//        } else if (hasDetails && MekKeyHandler.isKeyPressed(MekanismKeyHandler.detailsKey)) {
//            addDetails(stack, world, tooltip, flag);
//        } else {
//            addStats(stack, world, tooltip, flag);
//            if (hasDetails) {
//                tooltip.add(MekanismLang.HOLD_FOR_DETAILS.translateColored(EnumColor.GRAY, EnumColor.INDIGO, MekanismKeyHandler.detailsKey.getTranslatedKeyMessage()));
//            }
//            tooltip.add(MekanismLang.HOLD_FOR_DESCRIPTION.translateColored(EnumColor.GRAY, EnumColor.AQUA, MekanismKeyHandler.descriptionKey.getTranslatedKeyMessage()));
//        }
    }

    protected void addStats(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
    }

    protected void addDetails(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        //Note: Security and owner info gets skipped if the stack doesn't expose them
//        MekanismAPI.getSecurityUtils().addSecurityTooltip(stack, tooltip);
//        addTypeDetails(stack, world, tooltip, flag);
//        //TODO: Make this support "multiple" tanks, and probably expose the tank via capabilities
//        FluidStack fluidStack = StorageUtils.getStoredFluidFromNBT(stack);
//        if (!fluidStack.isEmpty()) {
//            tooltip.add(MekanismLang.GENERIC_STORED_MB.translateColored(EnumColor.PINK, fluidStack, EnumColor.GRAY, TextUtils.format(fluidStack.getAmount())));
//        }
//        if (Attribute.has(getBlock(), AttributeInventory.class) && stack.getItem() instanceof IItemSustainedInventory inventory) {
//            tooltip.add(MekanismLang.HAS_INVENTORY.translateColored(EnumColor.AQUA, EnumColor.GRAY, YesNo.of(inventory.hasInventory(stack))));
//        }
//        if (Attribute.has(getBlock(), AttributeUpgradeSupport.class)) {
//            MekanismUtils.addUpgradesToTooltip(stack, tooltip);
//        }
    }

    protected void addTypeDetails(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        //Put this here so that energy cubes can skip rendering energy here
//        if (Attribute.has(getBlock(), AttributeEnergy.class)) {
//            StorageUtils.addStoredEnergy(stack, tooltip, false);
//        }
    }
}