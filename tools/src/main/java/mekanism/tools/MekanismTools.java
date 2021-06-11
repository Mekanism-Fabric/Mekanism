package mekanism.tools;

import me.shedaniel.autoconfig.AutoConfig;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.ToolsConfig;
import mekanism.tools.registries.ToolItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MekanismTools implements ModInitializer {
    public static final String MODID = "mekanismtools";
    public static final Logger LOGGER = LogManager.getLogger();

    private static TOMLConfigSerializer<ToolsConfig> serializer;

    @Override
    public void onInitialize() {
        reloadConfig();

        ToolItems.init();

        log(Level.INFO, "Tools Loaded");
    }

    public static ToolsConfig config() {
        if (serializer == null) {
            reloadConfig();
        }

        return serializer.getConfig();
    }

    public static void reloadConfig() {
        if (serializer == null) {
            AutoConfig.register(ToolsConfig.class, (definition, configClass) -> {
                serializer = new TOMLConfigSerializer<>(definition, configClass);
                return serializer;
            });
        } else {
            serializer.reloadFromDisk();
        }
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static Identifier id(String path) {
        return new Identifier(MekanismTools.MODID, path);
    }
}
