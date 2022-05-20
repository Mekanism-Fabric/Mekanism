package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.PAXEL_MINEABLE;

public class MekanismPaxelItem extends DiggerItem {

    private static final float DEFAULT_ATTACK_DAMAGE = 4.0F;

    private static final Item[] VALID_TOOLS = {
        Items.NETHERITE_AXE,
        Items.NETHERITE_SHOVEL,
        Items.NETHERITE_PICKAXE
    };

    public MekanismPaxelItem(Tiers material, Properties settings) {
        super(DEFAULT_ATTACK_DAMAGE, -2.4F, material, PAXEL_MINEABLE, settings);
    }

    public MekanismPaxelItem(BaseMekanismMaterial material, Properties settings) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material, PAXEL_MINEABLE, settings.durability(material.getPaxelMaxUses()));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        Tier material = this.getTier();

        float damage = DEFAULT_ATTACK_DAMAGE;

        if (material instanceof BaseMekanismMaterial) {
            damage = ((BaseMekanismMaterial) material).getPaxelDamage();
        }

        return damage + getTier().getAttackDamageBonus();
    }

    @Override
    public boolean canBeDepleted() {
        Tier material = this.getTier();

        if (material instanceof BaseMekanismMaterial) {
            return ((BaseMekanismMaterial) material).getPaxelMaxUses() > 0;
        } else {
            return super.canBeDepleted();
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = InteractionResult.PASS;

        for (Item validTool : VALID_TOOLS) {
            result = validTool.useOn(context);
            if (result != InteractionResult.PASS) break;
        }

        if (result != InteractionResult.PASS) return result;

        return super.useOn(context);
    }
}
