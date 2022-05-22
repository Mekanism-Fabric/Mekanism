package mekanism.util.text;

import mekanism.api.energy.IEnergyContainer;
import mekanism.api.math.FloatingLong;
import mekanism.api.text.IHasTextComponent;
import mekanism.MekanismLang;
import mekanism.util.MekanismUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

@MethodsReturnNonnullByDefault
public class EnergyDisplay implements IHasTextComponent {

    public static final EnergyDisplay ZERO = of(FloatingLong.ZERO);

    private final FloatingLong energy;
    private final FloatingLong max;

    private EnergyDisplay(FloatingLong energy, FloatingLong max) {
        this.energy = energy;
        this.max = max;
    }

    public static EnergyDisplay of(IEnergyContainer container) {
        return of(container.getEnergy(), container.getMaxEnergy());
    }

    public static EnergyDisplay of(FloatingLong energy, FloatingLong max) {
        return new EnergyDisplay(energy, max);
    }

    public static EnergyDisplay of(FloatingLong energy) {
        return of(energy, FloatingLong.ZERO);
    }

    @Override
    public Component getTextComponent() {
        if (energy.equals(FloatingLong.MAX_VALUE)) {
            return MekanismLang.INFINITE.translate();
        } else if (max.isZero()) {
            return MekanismUtils.getEnergyDisplayShort(energy);
        }
        //Pass max back as a new Energy Display so that if we have 0/infinite it shows that properly without us having to add extra handling
        return MekanismLang.GENERIC_FRACTION.translate(MekanismUtils.getEnergyDisplayShort(energy), of(max));
    }
}