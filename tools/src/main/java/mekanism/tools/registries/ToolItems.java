package mekanism.tools.registries;

import mekanism.registration.ItemRegistry;
import mekanism.tools.MekanismTools;
import mekanism.tools.accessors.BlockTagsAccessor;
import mekanism.tools.items.MekanismPaxelItem;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterials;
import net.minecraft.tag.Tag;

import java.util.Locale;

public final class ToolItems {
    public static final ItemRegistry ITEMS = new ItemRegistry(MekanismTools.MODID);

    public static final Tag.Identified<Block> PAXEL_MINEABLE = BlockTagsAccessor.register(MekanismTools.id("mineable/paxel").toString());

    public static final MekanismPaxelItem WOOD_PAXEL      = registerPaxel(ToolMaterials.WOOD);
    public static final MekanismPaxelItem STONE_PAXEL     = registerPaxel(ToolMaterials.STONE);
    public static final MekanismPaxelItem IRON_PAXEL      = registerPaxel(ToolMaterials.IRON);
    public static final MekanismPaxelItem DIAMOND_PAXEL   = registerPaxel(ToolMaterials.DIAMOND);
    public static final MekanismPaxelItem GOLD_PAXEL      = registerPaxel(ToolMaterials.GOLD);
    public static final MekanismPaxelItem NETHERITE_PAXEL = registerPaxel(ToolMaterials.NETHERITE);

    public static void init() {

    }

    private static MekanismPaxelItem registerPaxel(ToolMaterials material) {
        return ITEMS.register(material.name().toLowerCase(Locale.ROOT) + "_paxel", () -> new MekanismPaxelItem(material));
    }
}
