package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.entity.ai.brain.task.RemoveOffHandItemTask;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RemoveOffHandItemTask.class)
public abstract class RemoveOffHandItemTaskMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        ),
        method = "shouldRun"
    )
    protected boolean shouldRun(ItemStack itemStack, Item item) {
        if (itemStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            return true;
        }

        return itemStack.isOf(item);
    }

}
