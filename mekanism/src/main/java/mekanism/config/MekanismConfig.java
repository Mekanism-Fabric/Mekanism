package mekanism.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import mekanism.config.helpers.TOMLConfigSerializer;
import mekanism.config.tier.TierConfig;

@Config(name = "Mekanism")
public class MekanismConfig extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("tiers")
    @ConfigEntry.Gui.TransitiveObject
    Tiers tiers = new Tiers();

}

@Config(name = "tiers")
class Tiers implements ConfigData {

    @Path("tiers")
    @ConfigEntry.Category("tiers")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Mekanism Tiers Config. This config is synced from server to client.")
    public TierConfig tierConfig = new TierConfig();

}
