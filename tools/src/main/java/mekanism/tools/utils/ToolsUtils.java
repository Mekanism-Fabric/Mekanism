package mekanism.tools.utils;

import mekanism.tools.ToolsLang;
import mekanism.tools.config.MekanismToolsConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ToolsUtils {

    /**
     * Adds durability to the tooltip if enabled in the config
     *
     * @apiNote Only call on client
     */
    public static void addDurability(@NotNull List<Component> tooltip, @NotNull ItemStack stack) {
        if (MekanismToolsConfig.toolsClient.displayDurabilityTooltips.getAsBoolean()) {
            tooltip.add(ToolsLang.HP.translate(stack.getMaxDamage() - stack.getDamageValue()));
        }
    }

}
