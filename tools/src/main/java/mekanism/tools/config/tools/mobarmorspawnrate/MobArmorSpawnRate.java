package mekanism.tools.config.tools.mobarmorspawnrate;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecDoubleInRange;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;

public class MobArmorSpawnRate implements ConfigData {

    @Path("general")
    @ConfigEntry.Gui.Tooltip
    @SpecDoubleInRange(min = 0.0D, max = 1.0D)
    @TOMLConfigSerializer.Comment({
        "The chance that Mekanism Armor can spawn on mobs."
    })
    public double general = 0.03D;

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Bronze gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @ConfigEntry.Category("bronze")
    @ConfigEntry.Gui.TransitiveObject
    public Bronze bronze = new Bronze();

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Lapis Lazuli gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @Path("lapis_lazuli")
    @ConfigEntry.Category("lapis_lazuli")
    @ConfigEntry.Gui.TransitiveObject
    public LapisLazuli lapisLazuli = new LapisLazuli();

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Osmium gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @ConfigEntry.Category("osmium")
    @ConfigEntry.Gui.TransitiveObject
    public Osmium osmium = new Osmium();

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Refined Glowstone gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @Path("refined_glowstone")
    @ConfigEntry.Category("refined_glowstone")
    @ConfigEntry.Gui.TransitiveObject
    public RefinedGlowstone refinedGlowstone = new RefinedGlowstone();

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Refined Obsidian gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @Path("refined_obsidian")
    @ConfigEntry.Category("refined_obsidian")
    @ConfigEntry.Gui.TransitiveObject
    public RefinedObsidian refinedObsidian = new RefinedObsidian();

    @TOMLConfigSerializer.Comment(
        "Spawn chances for pieces of Steel gear. Note: These values are after the general mobArmorSpawnRate has been checked, and after an even split between armor types has been done."
    )
    @ConfigEntry.Category("steel")
    @ConfigEntry.Gui.TransitiveObject
    public Steel steel = new Steel();
}
