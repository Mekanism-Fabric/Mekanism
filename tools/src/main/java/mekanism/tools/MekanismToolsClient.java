package mekanism.tools;

import me.shedaniel.autoconfig.AutoConfig;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.ToolsClientConfig;
import net.fabricmc.api.ClientModInitializer;

public class MekanismToolsClient implements ClientModInitializer {
    private static TOMLConfigSerializer<ToolsClientConfig> serializer;

    @Override
    public void onInitializeClient() {
        reloadClientConfig();
    }

    public static ToolsClientConfig clientConfig() {
        if (serializer == null) {
            reloadClientConfig();
        }

        return serializer.getConfig();
    }

    public static void reloadClientConfig() {
        if (serializer == null) {
            AutoConfig.register(ToolsClientConfig.class, (definition, configClass) -> {
                serializer = new TOMLConfigSerializer<>(definition, configClass);
                return serializer;
            });
        } else {
            serializer.reloadFromDisk();
        }
    }
}
