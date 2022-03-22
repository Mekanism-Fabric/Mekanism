package mekanism.tools;

import mekanism.tools.config.MekanismToolsConfig;
import mekanism.tools.registries.ToolEvents;
import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MekanismTools implements ModInitializer {
    public static final String MODID = "mekanismtools";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        MekanismToolsConfig.registerConfigs();
        ToolItems.init();
        ToolEvents.init();

        log(Level.INFO, "Tools Loaded");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static Identifier id(String path) {
        return new Identifier(MekanismTools.MODID, path);
    }
}
