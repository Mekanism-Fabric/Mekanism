package mekanism.tools.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.TOMLConfigSerializer;
import mekanism.tools.config.toolsclient.ToolsClient;

@Config(name = "tools-client")
@Path("Mekanism")
public class ToolsClientConfig implements ConfigData {

    @Path("tools-client")
    @ConfigEntry.Category("tools-client")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Mekanism Tools Client Config. This config only exists on the client")
    public ToolsClient config = new ToolsClient();

}
