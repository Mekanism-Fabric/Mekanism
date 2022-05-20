package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.registries.ToolItems;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class MekanismShieldItem extends ShieldItem implements IHazGlowEffect {

    private final BaseMekanismMaterial material;

    public MekanismShieldItem(BaseMekanismMaterial material, Item.Properties settings) {
        super(settings.durability(material.getShieldDurability()));

        this.material = material;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel) {
        if (itemStack.getItem() == ToolItems.REFINED_GLOWSTONE_SHIELD) {
            return REFINED_GLOWSTONE_LIGHT_LEVEL;
        }

        return defaultLightLevel;
    }
}
