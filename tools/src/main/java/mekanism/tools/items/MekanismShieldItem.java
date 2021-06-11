package mekanism.tools.items;

import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.rendering.RenderMekanismShieldItem;
import mekanism.tools.utils.ToolsUtils;
import net.fabricmc.fabric.impl.client.rendering.BuiltinItemRendererRegistryImpl;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismShieldItem extends ShieldItem implements IHazCustomMaxDamage {

    private final BaseMekanismMaterial material;

    public MekanismShieldItem(BaseMekanismMaterial material, Item.Settings settings) {
        super(settings);

        BuiltinItemRendererRegistryImpl.INSTANCE.register(this, RenderMekanismShieldItem::render);

        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public int getCustomMaxDamage(int defaultDamage) {
        return material.getShieldDurability();
    }
}
