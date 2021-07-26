package mekanism.config.tier;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.helpers.TOMLConfigSerializer;

public class BinTierConfig implements ConfigData {

    @Getter
    @Path("CREATIVE")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
            "The number of items Creative bins can store."
    })
    public int Creative = Integer.MAX_VALUE;

    @Getter
    @Path("ULTIMATE")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
            "The number of items ULTIMATE bins can store."
    })
    public int Ultimate = 262_144;

    @Getter
    @Path("ELITE")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
            "The number of items ELITE bins can store."
    })
    public int ELITE = 32_768;

    @Getter
    @Path("ADVANCED")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
            "The number of items ADVANCED bins can store."
    })
    public int ADVANCED = 8_192;

    @Getter
    @Path("BASIC")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
            "The number of items BASIC bins can store."
    })
    public int BASIC = 4_096;

}
