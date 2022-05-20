package mekanism.api.providers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public interface IItemProvider extends IBaseProvider, ItemLike {

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
    default ResourceLocation getRegistryName() {
        return new ResourceLocation(getItem().getDescription().getContents());
    }

    @Override
    default String getTranslationKey() {
        return getItem().getDescriptionId();
    }
}