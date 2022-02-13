package mekanism.api.providers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public interface IItemProvider extends IBaseProvider, ItemConvertible {

    /**
     * Gets the item this provider represents.
     */
    @NotNull
    Item getItem();//TODO - 1.18: Replace this with just using vanilla's asItem?

    @NotNull
    @Override
    default Item asItem() {
        return getItem();
    }

    /**
     * Creates an item stack of size one using the item this provider represents.
     */
    @NotNull
    default ItemStack getItemStack() {
        return getItemStack(1);
    }

    /**
     * Creates an item stack of the given size using the item this provider represents.
     *
     * @param size Size of the stack.
     */
    @NotNull
    default ItemStack getItemStack(int size) {
        return new ItemStack(getItem(), size);
    }

    @Override
    default Identifier getRegistryName() {
        return new Identifier(getItem().getName().asString());
    }

    @Override
    default String getTranslationKey() {
        return getItem().getTranslationKey();
    }
}