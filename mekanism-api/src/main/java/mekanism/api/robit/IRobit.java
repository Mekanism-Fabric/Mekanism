package mekanism.api.robit;

import mekanism.api.providers.IRobitSkinProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.Nullable;

/**
 * Basic interface that Robit's implement to provide basic access to some methods by allowing mods to instance check the entity against this interface.
 */
@MethodsReturnNonnullByDefault
public interface IRobit {//TODO: When we expose the security system to the API make this extend/implement it

    /**
     * Gets the skin this Robit currently is using.
     *
     * @return Current skin.
     */
    RobitSkin getSkin();

    /**
     * Tries to set this Robit's skin to the given skin.
     *
     * @param skinProvider The skin to set.
     * @param player       The player who is trying to set the skin of the robit, or null if the player is unknown.
     *
     * @return {@code true} if the Robit's skin was set, or false if the player does not have security clearance or doesn't have the skin unlocked ({@link
     * RobitSkin#isUnlocked(PlayerEntity)}).
     *
     * @implNote This method only syncs changes from the server side, so in general should only be called from the server side except for uses internal to the Robit.
     */
    boolean setSkin(IRobitSkinProvider skinProvider, @Nullable PlayerEntity player);
}