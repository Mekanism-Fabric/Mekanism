package mekanism.config;

public class MekanismConfig {

    private MekanismConfig() {
    }

//    public static final ClientConfig client = new ClientConfig();
//    public static final GeneralConfig general = new GeneralConfig();
//    public static final GearConfig gear = new GearConfig();
    public static final StorageConfig storage = new StorageConfig();
//    public static final TierConfig tiers = new TierConfig();
    public static final UsageConfig usage = new UsageConfig();
    public static final WorldConfig world = new WorldConfig();

    public static void registerConfigs() {
//        MekanismConfigHelper.registerConfig(client.getConfigType(), client.getConfigSpec());
//        MekanismConfigHelper.registerConfig(general.getConfigType(), general.getConfigSpec());
//        MekanismConfigHelper.registerConfig(gear.getConfigType(), gear.getConfigSpec());
        MekanismConfigHelper.registerConfig(storage.getConfigType(), storage.getConfigSpec());
//        MekanismConfigHelper.registerConfig(tiers.getConfigType(), tiers.getConfigSpec());
        MekanismConfigHelper.registerConfig(usage.getConfigType(), usage.getConfigSpec());
        MekanismConfigHelper.registerConfig(world.getConfigType(), world.getConfigSpec());

    }
}