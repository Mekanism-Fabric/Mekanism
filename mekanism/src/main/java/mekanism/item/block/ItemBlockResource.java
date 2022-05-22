package mekanism.item.block;

import mekanism.block.basic.BlockResource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class ItemBlockResource extends ItemBlockMekanism<BlockResource> {

    public ItemBlockResource(BlockResource block, Properties properties) {
        super(block, properties);
    }

//    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return getBlock().getResourceInfo().getBurnTime();
    }
}