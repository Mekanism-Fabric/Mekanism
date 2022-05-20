package mekanism.tools;

import mekanism.tools.MekanismTools;
import net.minecraft.network.chat.TranslatableComponent;

public enum ToolsLang {
    HP("tooltip", "hp");

    private final String translationKey;

    ToolsLang(String type, String path) {
        translationKey = String.format("%s.%s.%s", type, MekanismTools.MODID, path);
    }

    public TranslatableComponent translate(Object... args) {
        return new TranslatableComponent(translationKey, args);
    }
}
