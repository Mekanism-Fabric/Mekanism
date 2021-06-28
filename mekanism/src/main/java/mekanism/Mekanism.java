package mekanism;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import mekanism.config.MekanismConfig;
import mekanism.config.helpers.TOMLConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mekanism implements ModInitializer {

    public static final CreativeTabMekanism tabMekanism = new CreativeTabMekanism();
    public static final String MODID = "mekanism";
    public static final Logger LOGGER = LogManager.getLogger();

    private static TOMLConfigSerializer<MekanismConfig> serializer;

    @Override
    public void onInitialize() {
        AutoConfig.register(MekanismConfig.class, PartitioningSerializer.wrap(TOMLConfigSerializer::new));

        log(Level.INFO, "Base Loaded");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static Identifier id(String path) {
        return new Identifier(Mekanism.MODID, path);
    }
}
