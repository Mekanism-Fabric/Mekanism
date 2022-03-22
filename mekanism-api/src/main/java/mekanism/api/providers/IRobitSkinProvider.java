package mekanism.api.providers;

import mekanism.api.robit.RobitSkin;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public interface IRobitSkinProvider extends IBaseProvider {

    /**
     * Gets the robit skin this provider represents.
     */
    @NotNull
    RobitSkin getSkin();

    @Override
    default Identifier getRegistryName() {
        return getSkin().getRegistryName();
    }

    @Override
    default String getTranslationKey() {
        return getSkin().getTranslationKey();
    }
}