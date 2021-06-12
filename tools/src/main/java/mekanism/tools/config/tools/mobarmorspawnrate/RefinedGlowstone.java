package mekanism.tools.config.tools.mobarmorspawnrate;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecDoubleInRange;
import lombok.Getter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;

public class RefinedGlowstone implements ConfigData, ISpawnChance {

    @Getter
    @Path("swordChance")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that mobs can spawn with Refined Glowstone Swords."
    })
    public double swordChance = 0.5D;

    @Getter
    @Path("helmetChance")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that mobs can spawn with Refined Glowstone Helmets."
    })
    public double helmetChance = 0.5D;

    @Getter
    @Path("chestplateChance")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that mobs can spawn with Refined Glowstone Chestplates."
    })
    public double chestplateChance = 0.5D;

    @Getter
    @Path("leggingsChance")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that mobs can spawn with Refined Glowstone Leggings."
    })
    public double leggingsChance = 0.5D;

    @Getter
    @Path("bootsChance")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that mobs can spawn with Refined Glowstone Boots."
    })
    public double bootsChance = 0.5D;

}
