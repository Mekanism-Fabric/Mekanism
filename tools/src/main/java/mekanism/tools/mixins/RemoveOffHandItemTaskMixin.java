package mekanism.tools.mixins;

import mekanism.tools.items.MekanismShieldItem;
import net.minecraft.world.entity.monster.piglin.StopHoldingItemIfNoLongerAdmiring;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StopHoldingItemIfNoLongerAdmiring.class)
public abstract class RemoveOffHandItemTaskMixin {

    @Redirect(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
        ),
        method = "checkExtraStartConditions"
    )
    protected boolean shouldRun(ItemStack itemStack, Item item) {
        if (itemStack.getItem() instanceof MekanismShieldItem && item == Items.SHIELD) {
            return true;
        }

        return itemStack.is(item);
    }

}
