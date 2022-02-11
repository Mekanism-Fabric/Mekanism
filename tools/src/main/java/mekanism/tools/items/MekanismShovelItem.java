package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismShovelItem extends ShovelItem {

    private final BaseMekanismMaterial material;

    public MekanismShovelItem(BaseMekanismMaterial material, Settings settings) {
        super(material, material.getShovelDamage(), material.getShovelAtkSpeed(), settings);

        this.material = material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        return material.getShovelDamage() + getMaterial().getAttackDamage();
    }
}
