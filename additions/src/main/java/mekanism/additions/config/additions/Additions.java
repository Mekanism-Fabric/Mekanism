package mekanism.additions.config.additions;

import com.electronwill.nightconfig.core.conversion.Path;
import com.electronwill.nightconfig.core.conversion.SpecIntInRange;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import mekanism.config.helpers.TOMLConfigSerializer;

@Config(name = "additions")
public class Additions implements ConfigData {

    @Path("VoicePort")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 1, max = 65_535)
    @TOMLConfigSerializer.Comment({
        "TCP port for the Voice server to listen on."
    })
    public int voicePort = 36123;

    @Path("obsidianTNTBlastRadius")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Radius of the explosion of Obsidian TNT."
    })
    public int obsidianTNTBlastRadius = 12;

    @Path("voiceServerEnabled")
    @ConfigEntry.Gui.Tooltip
    @TOMLConfigSerializer.Comment({
        "Enables the voice server for Walkie Talkies."
    })
    public boolean voiceServerEnabled = false;

    @Path("obsidianTNTDelay")
    @ConfigEntry.Gui.Tooltip
    @SpecIntInRange(min = 0, max = Integer.MAX_VALUE)
    @TOMLConfigSerializer.Comment({
        "Fuse time for Obsidian TNT."
    })
    public int obsidianTNTDelay = 100;

}
