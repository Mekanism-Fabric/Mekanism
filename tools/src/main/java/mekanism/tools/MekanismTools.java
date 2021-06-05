package mekanism.tools;

import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MekanismTools implements ModInitializer {
    public static final String MODID = "mekanismtools";

    @Override
    public void onInitialize() {
        ToolItems.init();

        System.out.println("Tools Loaded");
    }

    public static Identifier id(String path) {
        return new Identifier(MekanismTools.MODID, path);
    }
}
