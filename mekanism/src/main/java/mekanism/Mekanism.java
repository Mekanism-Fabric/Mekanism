package mekanism;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mekanism implements ModInitializer {

    public static final CreativeTabMekanism tabMekanism = new CreativeTabMekanism();
    public static final String MODID = "mekanism";

    @Override
    public void onInitialize() {
        System.out.println("Base Loaded");
    }

    public static Identifier id(String path) {
        return new Identifier(Mekanism.MODID, path);
    }
}
