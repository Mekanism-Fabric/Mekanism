package mekanism.item;

import mekanism.api.IAlloyInteraction;
import mekanism.api.tier.AlloyTier;
import mekanism.capabilities.Capabilities;
import mekanism.config.MekanismConfig;
import mekanism.util.WorldUtils;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ItemAlloy extends Item {

    private final AlloyTier tier;

    public ItemAlloy(AlloyTier tier, Settings properties) {
        super(properties);
        this.tier = tier;
    }

    @NotNull
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player != null && MekanismConfig.general.transmitterAlloyUpgrade.get()) {
            World world = context.getWorld();
            BlockPos pos = context.getBlockPos();
            BlockEntity tile = WorldUtils.getTileEntity(world, pos);
            IAlloyInteraction capability = Capabilities.ALLOY_INTERACTION_CAPABILITY.find(world, pos, context.getPlayerFacing());
            if (capability != null) {
                if (!world.isClient) {
                    capability.onAlloyInteraction(player, context.getStack(), tier);
                }
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public AlloyTier getTier() {
        return tier;
    }
}