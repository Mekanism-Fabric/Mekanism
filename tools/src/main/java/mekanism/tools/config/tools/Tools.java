package mekanism.tools.config.tools;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.tools.mobarmorspawnrate.MobArmorSpawnRate;
import mekanism.tools.materials.*;

@Config(name = "tools")
public class Tools implements ConfigData {

    @Path("mobArmorSpawnRate")
    @ConfigEntry.Gui.TransitiveObject
    public MobArmorSpawnRate mobArmorSpawnRate = new MobArmorSpawnRate();

    @Path(BronzeMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + BronzeMaterialDefaults.name)
    public Bronze bronzeMaterialStats = new Bronze();

    @Path(LapisLazuliMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + LapisLazuliMaterialDefaults.name)
    public LapisLazuli lapisLazuliMaterialStats = new LapisLazuli();

    @Path(OsmiumMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + OsmiumMaterialDefaults.name)
    public Osmium osmiumMaterialStats = new Osmium();

    @Path(RefinedGlowstoneMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + RefinedGlowstoneMaterialDefaults.name)
    public RefinedGlowstone refinedGlowstoneMaterialStats = new RefinedGlowstone();

    @Path(RefinedObsidianMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + RefinedObsidianMaterialDefaults.name)
    public RefinedObsidian refinedObsidianMaterialStats = new RefinedObsidian();

    @Path(SteelMaterialDefaults.name)
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Material Settings for " + SteelMaterialDefaults.name)
    public Steel steelMaterialStats = new Steel();

}
