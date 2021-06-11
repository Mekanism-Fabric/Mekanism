package mekanism.tools.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.tools.Tools;

@Config(name = "tools")
@Path("Mekanism")
public class ToolsConfig implements ConfigData {

    @Path("tools")
    @ConfigEntry.Category("tools")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Mekanism Tools Config. This config is synced from server to client.")
    public Tools config = new Tools();

}
