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
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemModule extends Item implements IModuleItem {

    private final IModuleDataProvider<?> moduleData;

    public ItemModule(IModuleDataProvider<?> moduleData, Properties properties) {
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
    public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
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
    public String getDescriptionId() {
        return getModuleData().getTranslationKey();
    }
}
