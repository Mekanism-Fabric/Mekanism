package mekanism;

import mekanism.config.MekanismConfig;
import mekanism.registries.MekanismItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mekanism implements ModInitializer {

    public static final CreativeTabMekanism tabMekanism = new CreativeTabMekanism();
    public static final String MODID = "mekanism";
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void onInitialize() {
        MekanismConfig.registerConfigs();
        MekanismItems.init();

        log(Level.INFO, "Base Loaded");
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(Mekanism.MODID, path);
    }
}
