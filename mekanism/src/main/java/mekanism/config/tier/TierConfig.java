package mekanism.config.tier;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.helpers.TOMLConfigSerializer;

@Config(name = "tiers")
public class TierConfig implements ConfigData {

    @Path("bins")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment({
            "Bins"
    })
    public BinTierConfig binTierConfig = new BinTierConfig();

}
