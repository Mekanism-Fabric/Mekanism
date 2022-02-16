package mekanism.tools.utils;

import mekanism.tools.ToolsLang;
import mekanism.tools.config.MekanismToolsConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ToolsUtils {

    /**
     * Adds durability to the tooltip if enabled in the config
     *
     * @apiNote Only call on client
     */
    public static void addDurability(@NotNull List<Text> tooltip, @NotNull ItemStack stack) {
        if (MekanismToolsConfig.toolsClient.displayDurabilityTooltips.getAsBoolean()) {
            tooltip.add(ToolsLang.HP.translate(stack.getMaxDamage() - stack.getDamage()));
        }
    }

}
