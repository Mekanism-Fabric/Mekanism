package mekanism.tools.rendering;

import mekanism.tools.MekanismTools;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;

public enum ShieldTextures {
    BRONZE("bronze"),
    LAPIS_LAZULI("lapis_lazuli"),
    OSMIUM("osmium"),
    REFINED_GLOWSTONE("refined_glowstone"),
    REFINED_OBSIDIAN("refined_obsidian"),
    STEEL("steel");

    private final SpriteIdentifier base;

    ShieldTextures(String name) {
        base = material("item/" + name + "/shield");
    }

    public SpriteIdentifier getBase() {
        return base;
    }

    private static SpriteIdentifier material(String path) {
        return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, MekanismTools.id(path));
    }
}
