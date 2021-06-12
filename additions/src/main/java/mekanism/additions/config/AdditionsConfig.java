package mekanism.additions.config;

import com.electronwill.nightconfig.core.conversion.Path;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.additions.config.additions.Additions;
import mekanism.config.helpers.TOMLConfigSerializer;

@Config(name = "additions")
@Path("Mekanism")
public class AdditionsConfig implements ConfigData {

    @Path("additions")
    @ConfigEntry.Category("additions")
    @ConfigEntry.Gui.TransitiveObject
    @TOMLConfigSerializer.Comment("Mekanism Additions Config. This config is synced between server and client.")
    public Additions config = new Additions();

}
