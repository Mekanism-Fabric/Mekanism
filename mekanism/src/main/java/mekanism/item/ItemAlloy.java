package mekanism.item;

import mekanism.api.IAlloyInteraction;
import mekanism.api.tier.AlloyTier;
import mekanism.capabilities.Capabilities;
import mekanism.config.MekanismConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemAlloy extends Item {

    private final AlloyTier tier;

    public ItemAlloy(AlloyTier tier, Properties properties) {
        super(properties);
        this.tier = tier;
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && MekanismConfig.general.transmitterAlloyUpgrade.get()) {
            Level world = context.getLevel();
            BlockPos pos = context.getClickedPos();
            IAlloyInteraction capability = Capabilities.ALLOY_INTERACTION_CAPABILITY.find(world, pos, context.getClickedFace());
            if (capability != null) {
                if (!world.isClientSide) {
                    capability.onAlloyInteraction(player, context.getItemInHand(), tier);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public AlloyTier getTier() {
        return tier;
    }
}