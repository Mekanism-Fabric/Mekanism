package mekanism.item;

import mekanism.api.MekanismAPI;
import mekanism.api.gear.ModuleData;
import mekanism.api.providers.IModuleDataProvider;
import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.MekanismLang;
import mekanism.content.gear.IModuleItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemModule extends Item implements IModuleItem {

    private final IModuleDataProvider<?> moduleData;

    public ItemModule(IModuleDataProvider<?> moduleData, Settings properties) {
        super(properties);
        this.moduleData = moduleData;
    }

    public int getItemStackLimit(ItemStack stack) {
        return getModuleData().getMaxStackSize();
    }

    @Override
    public ModuleData<?> getModuleData() {
        return moduleData.getModuleData();
    }

    @NotNull
    @Override
    public Rarity getRarity(@NotNull ItemStack stack) {
        return getModuleData().getRarity();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(@NotNull ItemStack stack, World world, @NotNull List<Text> tooltip, @NotNull TooltipContext flag) {
//        if (MekKeyHandler.isKeyPressed(MekanismKeyHandler.detailsKey)) {
//            for (Item item : MekanismAPI.getModuleHelper().getSupported(getModuleData())) {
//                tooltip.add(item.getName(new ItemStack(item)));
//            }
//        } else {
//            ModuleData<?> moduleData = getModuleData();
//            tooltip.add(TextComponentUtil.translate(moduleData.getDescriptionTranslationKey()));
//            tooltip.add(MekanismLang.MODULE_STACKABLE.translateColored(EnumColor.GRAY, EnumColor.AQUA, moduleData.getMaxStackSize()));
//            tooltip.add(MekanismLang.HOLD_FOR_SUPPORTED_ITEMS.translateColored(EnumColor.GRAY, EnumColor.INDIGO, MekanismKeyHandler.detailsKey.getTranslatedKeyMessage()));
//        }
    }

    @NotNull
    @Override
    public String getTranslationKey() {
        return getModuleData().getTranslationKey();
    }
}
