package mekanism.tools.config;

import mekanism.config.MekanismConfigHelper;

public class MekanismToolsConfig {

    private MekanismToolsConfig() {
    }

    public static final ToolsConfig tools = new ToolsConfig();
    public static final ToolsClientConfig toolsClient = new ToolsClientConfig();

    public static void registerConfigs() {
        MekanismConfigHelper.registerConfig(tools.getConfigType(), tools.getConfigSpec(), tools.getFileName());
        MekanismConfigHelper.registerConfig(toolsClient.getConfigType(), toolsClient.getConfigSpec(), toolsClient.getFileName());
    }
}