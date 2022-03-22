package mekanism.additions;

import mekanism.additions.config.MekanismAdditionsConfig;
import mekanism.additions.registries.AdditionsEntityTypes;
import mekanism.additions.registries.AdditionsItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MekanismAdditions implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mekanismadditions";


    @Override
    public void onInitialize() {
        MekanismAdditionsConfig.registerConfigs();
        AdditionsEntityTypes.init();
        AdditionsItems.init();

        log(Level.INFO, "Additions Loaded");
    }


    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static Identifier id(String path) {
        return new Identifier(MekanismAdditions.MODID, path);
    }
}
