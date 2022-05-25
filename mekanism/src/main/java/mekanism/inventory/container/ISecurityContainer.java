package mekanism.inventory.container;

import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import org.jetbrains.annotations.Nullable;

public interface ISecurityContainer {

    /**
     * @apiNote Only for use on the server, which means that it doesn't need to properly update on the client side if the stack changes
     */
    @Nullable
    BlockApiLookup getSecurityObject();
}