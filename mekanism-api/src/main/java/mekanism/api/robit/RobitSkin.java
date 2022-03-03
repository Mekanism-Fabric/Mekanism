package mekanism.api.robit;

import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import dev.architectury.core.RegistryEntry;
import mekanism.api.providers.IRobitSkinProvider;
import mekanism.api.text.IHasTextComponent;
import mekanism.api.text.IHasTranslationKey;
import mekanism.api.text.TextComponentUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@MethodsReturnNonnullByDefault
public class RobitSkin extends RegistryEntry<RobitSkin> implements IRobitSkinProvider, IHasTranslationKey, IHasTextComponent {

    private final List<Identifier> textures;
    private String translationKey;

    /**
     * Creates a new Robit skin that makes use of the given textures when the Robit moves in the given order.
     *
     * @param textures Textures to use for the skin. If this is an empty array then {@link #getTextures()} must be overridden.
     */
    public RobitSkin(Identifier... textures) {
        Objects.requireNonNull(textures, "Textures cannot be null.");
        if (textures.length == 0) {
            this.textures = Collections.emptyList();
        } else {
            //TODO - 1.18: List#of
            this.textures = ImmutableList.copyOf(textures);
        }
    }

    /**
     * Gets the location of the custom json model for this skin. In general, it is probably a good idea to base it off the existing robit model's json except with any
     * small changes this skin requires. For an example of the syntax the default model's location would be {@code mekanism:item/robit}.
     *
     * @return Custom model or {@code null} if the default model should be used.
     *
     * @apiNote This is mostly untested currently so if you run into issues please report them.
     */
    @Nullable
    public Identifier getCustomModel() {
        return null;
    }

    /**
     * Gets the list of textures that will be used for this skin. The textures should be located in the asset location: {@code
     * <namespace>/textures/entity/robit/<path>.png}
     * <br><br>
     * It is <strong>important</strong> that this list has at <strong>least ONE</strong> element in it.
     * <br><br>
     * Every three ticks of the robit being alive if it has moved, the selected texture of this skin is incremented to the next one in the list, and then it repeats from
     * the start. This allows skins to define "movement" changes such as how the Robit's treads appear to be moving in the base skin.
     *
     * @return Unmodifiable list of textures for this skin.
     */
    public List<Identifier> getTextures() {
        return textures;
    }

    /**
     * Checks if the given player has access to select this skin.
     *
     * @param player Player to check.
     *
     * @return {@code true} if the player has access.
     */
    public boolean isUnlocked(@NotNull PlayerEntity player) {
        //TODO: Have some skins that are potentially locked as patreon rewards?
        return true;
    }

    @NotNull
    @Override
    public final RobitSkin getSkin() {
        return this;
    }

    @Override
    public String getTranslationKey() {
        if (translationKey == null) {
            translationKey = Util.createTranslationKey("robit_skin", getRegistryName());
        }
        return translationKey;
    }

    @Override
    public Text getTextComponent() {
        return TextComponentUtil.translate(getTranslationKey());
    }
}