package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShieldDecorationRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShieldDecorationRecipe.class)
public abstract class ShieldDecorationRecipeMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        ),
        method = { "matches", "craft" }
    )
    private boolean stackIsOf(ItemStack stack, Item item) {
        if (stack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            return true;
        }

        return stack.isOf(item);
    }

}
