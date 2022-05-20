package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShieldDecorationRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShieldDecorationRecipe.class)
public abstract class ShieldDecorationRecipeMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
        ),
        method = { "matches", "assemble" }
    )
    private boolean stackIsOf(ItemStack stack, Item item) {
        if (stack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            return true;
        }

        return stack.is(item);
    }

}
