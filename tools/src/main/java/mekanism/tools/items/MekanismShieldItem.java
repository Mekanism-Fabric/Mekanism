package mekanism.tools.items;

import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.registries.ToolItems;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class MekanismShieldItem extends ShieldItem implements IHazGlowEffect {

    private final BaseMekanismMaterial material;

    public MekanismShieldItem(BaseMekanismMaterial material, Item.Settings settings) {
        super(settings.maxDamage(material.getShieldDurability()));

        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

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
