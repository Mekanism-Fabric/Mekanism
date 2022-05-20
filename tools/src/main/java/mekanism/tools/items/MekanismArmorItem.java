package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.registries.ToolItems;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mekanism.tools.registries.ToolItems.REFINED_GLOWSTONE_LIGHT_LEVEL;

public class MekanismArmorItem extends ArmorItem implements IHazPiglinInfluence, IHazGlowEffect {

    private final BaseMekanismMaterial material;
    private final boolean makesPiglinsNeutral;

    public MekanismArmorItem(BaseMekanismMaterial material, EquipmentSlot slot, Properties settings, boolean makesPiglinsNeutral) {
        super(material, slot, settings.durability(material.getDurabilityForSlot(slot)));

        this.material = material;
        this.makesPiglinsNeutral = makesPiglinsNeutral;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public boolean isPiglinCalming() {
        return this.makesPiglinsNeutral;
    }

    @Override
    public boolean canBeDepleted() {
        return material.getDurabilityForSlot(slot) > 0;
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
