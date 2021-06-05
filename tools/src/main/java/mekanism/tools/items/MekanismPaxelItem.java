package mekanism.tools.items;

import mekanism.registration.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

import static mekanism.tools.registries.ToolItems.PAXEL_MINEABLE;

public class MekanismPaxelItem extends MiningToolItem {

    private static Item.Settings getItemProperties(ToolMaterials material) {
        FabricItemSettings properties = ItemRegistry.getMekBaseProperties();
        if (material == ToolMaterials.NETHERITE) {
            properties = properties.fireproof();
        }
        return properties;
    }

    public MekanismPaxelItem(ToolMaterials material) {
        super(4, -2.4F, material, PAXEL_MINEABLE, getItemProperties(material));
    }
}
