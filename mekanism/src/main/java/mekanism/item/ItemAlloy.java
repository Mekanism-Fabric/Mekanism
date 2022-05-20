package mekanism.item;

import mekanism.api.tier.AlloyTier;
import net.minecraft.world.item.Item;

public class ItemAlloy extends Item {

    private final AlloyTier tier;

    public ItemAlloy(AlloyTier tier, Properties properties) {
        super(properties);
        this.tier = tier;
    }

//    @Nonnull
//    @Override
//    public ActionResultType useOn(ItemUseContext context) {
//        PlayerEntity player = context.getPlayer();
//        if (player != null && MekanismConfig.general.transmitterAlloyUpgrade.get()) {
//            World world = context.getLevel();
//            BlockPos pos = context.getClickedPos();
//            TileEntity tile = WorldUtils.getTileEntity(world, pos);
//            LazyOptional<IAlloyInteraction> capability = CapabilityUtils.getCapability(tile, Capabilities.ALLOY_INTERACTION_CAPABILITY, context.getClickedFace());
//            if (capability.isPresent()) {
//                if (!world.isClientSide) {
//                    capability.resolve().get().onAlloyInteraction(player, context.getHand(), context.getItemInHand(), tier);
//                }
//                return ActionResultType.SUCCESS;
//            }
//        }
//        return ActionResultType.PASS;
//    }

    public AlloyTier getTier() {
        return tier;
    }
}