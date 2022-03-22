package mekanism.tools;

import net.minecraft.recipe.Ingredient;
import org.jetbrains.annotations.NotNull;

public interface IHasRepairType {

    /**
     * Gets the stack that can be used to repair this item. This is used to simplify getting repair type dynamically for adding to JEI's Anvil recipe category.
     */
    @NotNull
    Ingredient getRepairMaterial();
}