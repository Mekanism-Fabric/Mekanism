package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismHoeItem extends HoeItem {

    private final BaseMekanismMaterial material;

    public MekanismHoeItem(BaseMekanismMaterial material, Settings settings) {
        super(material, (int) material.getHoeDamage(), material.getHoeAtkSpeed(), settings);

        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        return material.getHoeDamage() + getMaterial().getAttackDamage();
    }
}
