package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismAxeItem extends AxeItem {

    private final BaseMekanismMaterial material;

    public MekanismAxeItem(BaseMekanismMaterial material, Properties settings) {
        super(material, material.getAxeDamage(), material.getAxeAtkSpeed(), settings);

        this.material = material;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        return material.getAxeDamage() + getTier().getAttackDamageBonus();
    }

}
