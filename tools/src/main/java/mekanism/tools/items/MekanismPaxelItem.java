package mekanism.tools.items;

import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.PAXEL_MINEABLE;

public class MekanismPaxelItem extends MiningToolItem {

    private static final float DEFAULT_ATTACK_DAMAGE = 4.0F;

    private static final Item[] VALID_TOOLS = {
        Items.NETHERITE_AXE,
        Items.NETHERITE_SHOVEL,
        Items.NETHERITE_PICKAXE
    };

    public MekanismPaxelItem(ToolMaterials material, Settings settings) {
        super(DEFAULT_ATTACK_DAMAGE, -2.4F, material, PAXEL_MINEABLE, settings);
    }

    public MekanismPaxelItem(BaseMekanismMaterial material, Settings settings) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material, PAXEL_MINEABLE, settings.maxDamage(material.getPaxelMaxUses()));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        ToolMaterial material = this.getMaterial();

        float damage = DEFAULT_ATTACK_DAMAGE;

        if (material instanceof BaseMekanismMaterial) {
            damage = ((BaseMekanismMaterial) material).getPaxelDamage();
        }

        return damage + getMaterial().getAttackDamage();
    }

    @Override
    public boolean isDamageable() {
        ToolMaterial material = this.getMaterial();

        if (material instanceof BaseMekanismMaterial) {
            return ((BaseMekanismMaterial) material).getPaxelMaxUses() > 0;
        } else {
            return super.isDamageable();
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult result = ActionResult.PASS;

        for (Item validTool : VALID_TOOLS) {
            result = validTool.useOnBlock(context);
            if (result != ActionResult.PASS) break;
        }

        if (result != ActionResult.PASS) return result;

        return super.useOnBlock(context);
    }
}
