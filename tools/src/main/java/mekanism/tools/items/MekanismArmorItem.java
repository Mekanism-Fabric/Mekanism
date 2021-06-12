package mekanism.tools.items;

import mekanism.tools.materials.BaseMekanismMaterial;
import mekanism.tools.registries.ToolItems;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class MekanismArmorItem extends ArmorItem implements IHazPiglinInfluence, IHazGlowEffect {

    private final BaseMekanismMaterial material;
    private final boolean makesPiglinsNeutral;

    public MekanismArmorItem(BaseMekanismMaterial material, EquipmentSlot slot, Settings settings, boolean makesPiglinsNeutral) {
        super(material, slot, settings.maxDamage(material.getDurability(slot)));

        this.material = material;
        this.makesPiglinsNeutral = makesPiglinsNeutral;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public boolean isPiglinCalming() {
        return this.makesPiglinsNeutral;
    }

    @Override
    public boolean isDamageable() {
        return material.getDurability(slot) > 0;
    }

    @Override
    public int getCustomLightLevel(ItemStack itemStack, int defaultLightLevel) {
        if (itemStack.getItem() == ToolItems.REFINED_GLOWSTONE_HELMET || itemStack.getItem() == ToolItems.REFINED_GLOWSTONE_CHESTPLATE
            || itemStack.getItem() == ToolItems.REFINED_GLOWSTONE_LEGGINGS || itemStack.getItem() == ToolItems.REFINED_GLOWSTONE_BOOTS) {
            return REFINED_GLOWSTONE_LIGHT_LEVEL;
        }

        return defaultLightLevel;
    }
}
