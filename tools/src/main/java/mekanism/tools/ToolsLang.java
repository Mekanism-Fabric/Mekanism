package mekanism.tools;

import mekanism.tools.MekanismTools;
import net.minecraft.text.TranslatableText;

public enum ToolsLang {
    HP("tooltip", "hp");

    private final String translationKey;

    ToolsLang(String type, String path) {
        translationKey = String.format("%s.%s.%s", type, MekanismTools.MODID, path);
    }

    public TranslatableText translate(Object... args) {
        return new TranslatableText(translationKey, args);
    }
}
