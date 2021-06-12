package mekanism.additions;

import me.shedaniel.autoconfig.AutoConfig;
import mekanism.additions.config.AdditionsConfig;
import mekanism.additions.config.additions.Additions;
import mekanism.config.helpers.TOMLConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MekanismAdditions implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mekanismadditions";

    private static TOMLConfigSerializer<AdditionsConfig> serializer;

    @Override
    public void onInitialize() {
        log(Level.INFO, "Additions Loaded");
    }

    public static Additions config() {
        if (serializer == null) {
            reloadConfig();
        }

        return serializer.getConfig().config;
    }

    public static void reloadConfig() {
        if (serializer == null) {
            AutoConfig.register(AdditionsConfig.class, (definition, configClass) -> {
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
        return new Identifier(MekanismAdditions.MODID, path);
    }
}
