package mekanism.tools.items;

import mekanism.registration.ItemRegistry;
import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.PAXEL_MINEABLE;

public class MekanismPaxelItem extends MiningToolItem {

    private static Item.Settings getItemProperties(ToolMaterial material) {
        FabricItemSettings properties = ItemRegistry.getMekBaseProperties();

        if (material == ToolMaterials.NETHERITE) {
            properties = properties.fireproof();
        } else if (material instanceof BaseMekanismMaterial && !((BaseMekanismMaterial)material).burnsInFire()) {
            properties = properties.fireproof();
        }

        return properties;
    }

    public MekanismPaxelItem(ToolMaterial material) {
        super(4, -2.4F, material, PAXEL_MINEABLE, getItemProperties(material));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }
}
