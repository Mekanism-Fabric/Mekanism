package mekanism.tools.utils;

import mekanism.tools.MekanismToolsClient;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ToolsUtils {

    /**
     * Adds durability to the tooltip if enabled in the config
     *
     * @apiNote Only call on client
     */
    public static void addDurability(@NotNull List<Text> tooltip, @NotNull ItemStack stack) {
        if (MekanismToolsClient.clientConfig().config.displayDurabilityTooltips) {
            tooltip.add(new TranslatableText("tooltip.mekanismtools.hp", stack.getMaxDamage() - stack.getDamage()));
        }
    }

}
