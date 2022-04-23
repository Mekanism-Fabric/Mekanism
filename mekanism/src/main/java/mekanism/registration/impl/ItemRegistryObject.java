package mekanism.registration.impl;

import mekanism.api.providers.IItemProvider;
import mekanism.registration.WrappedRegistryObject;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class ItemRegistryObject<ITEM extends Item> extends WrappedRegistryObject<ITEM> implements IItemProvider {

    public ItemRegistryObject(Identifier identifier, ITEM registryObject) {
        super(identifier, registryObject);
    }

    @NotNull
    @Override
    public ITEM getItem() {
        return get();
    }
}
