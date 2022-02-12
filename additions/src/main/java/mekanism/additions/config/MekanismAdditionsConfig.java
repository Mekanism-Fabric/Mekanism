package mekanism.additions.config;

import mekanism.config.MekanismConfigHelper;

public class MekanismAdditionsConfig {

    private MekanismAdditionsConfig() {
    }

    public static final AdditionsConfig additions = new AdditionsConfig();
    public static final AdditionsCommonConfig common = new AdditionsCommonConfig();
    public static final AdditionsClientConfig client = new AdditionsClientConfig();

    public static void registerConfigs() {
        MekanismConfigHelper.registerConfig(client.getConfigType(), client.getConfigSpec(), client.getFileName());
        MekanismConfigHelper.registerConfig(common.getConfigType(), common.getConfigSpec(), common.getFileName());
        MekanismConfigHelper.registerConfig(additions.getConfigType(), additions.getConfigSpec(), additions.getFileName());
    }
}