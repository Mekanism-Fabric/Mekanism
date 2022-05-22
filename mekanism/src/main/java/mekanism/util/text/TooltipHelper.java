package mekanism.util.text;

import mekanism.api.math.FloatingLong;
import mekanism.api.text.ITooltipHelper;
import mekanism.MekanismLang;
import mekanism.util.MekanismUtils;
import mekanism.util.UnitDisplayUtils;
import mekanism.util.UnitDisplayUtils.RadiationUnit;
import net.minecraft.network.chat.Component;

public class TooltipHelper implements ITooltipHelper {

    public static final TooltipHelper INSTANCE = new TooltipHelper();

    private TooltipHelper() {
    }

    @Override
    public Component getEnergyPerMBDisplayShort(FloatingLong energy) {
        return MekanismLang.GENERIC_PER_MB.translate(MekanismUtils.getEnergyDisplayShort(energy));
    }

    @Override
    public Component getRadioactivityDisplayShort(double radioactivity) {
        return UnitDisplayUtils.getDisplayShort(radioactivity, RadiationUnit.SVH, 2);
    }

    @Override
    public String getFormattedNumber(long number) {
        return TextUtils.format(number);
    }

    @Override
    public Component getPercent(double ratio) {
        return TextUtils.getPercent(ratio);
    }
}