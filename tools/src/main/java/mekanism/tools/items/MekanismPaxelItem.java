package mekanism.tools.items;

import mekanism.registration.ItemRegistry;
import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.PAXEL_MINEABLE;

public class MekanismPaxelItem extends MiningToolItem implements IHazCustomMaxDamage {

    private static final Item[] VALID_TOOLS = {
        Items.NETHERITE_AXE,
        Items.NETHERITE_SHOVEL,
        Items.NETHERITE_PICKAXE
    };

    private static Item.Settings getItemProperties(ToolMaterial material) {
        FabricItemSettings properties = ItemRegistry.getMekBaseProperties();

        if (material == ToolMaterials.NETHERITE) {
            properties = properties.fireproof();
        } else if (material instanceof BaseMekanismMaterial && !((BaseMekanismMaterial)material).burnsInFire()) {
            properties = properties.fireproof();
        }

        return properties;
    }

    public MekanismPaxelItem(ToolMaterials material) {
        super(4, -2.4F, material, PAXEL_MINEABLE, getItemProperties(material));
    }

    public MekanismPaxelItem(BaseMekanismMaterial material) {
        super(material.getPaxelDamage(), material.getPaxelAtkSpeed(), material, PAXEL_MINEABLE, getItemProperties(material));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public int getCustomMaxDamage(int defaultDamage) {
        ToolMaterial material = this.getMaterial();

        if (material instanceof BaseMekanismMaterial) {
            return ((BaseMekanismMaterial) material).getPaxelMaxUses();
        } else {
            return defaultDamage;
        }
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
