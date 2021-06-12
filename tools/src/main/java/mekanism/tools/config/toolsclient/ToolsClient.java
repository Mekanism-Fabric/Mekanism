package mekanism.tools.config.toolsclient;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.helpers.TOMLConfigSerializer;

@Config(name = "tools-client")
public class ToolsClient {

    @Path("displayDurabilityTooltips")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Enable durability tooltips for Mekanism Tools gear.")
    public boolean displayDurabilityTooltips = true;

}
