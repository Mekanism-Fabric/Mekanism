package mekanism.item.interfaces;

import mekanism.client.render.armor.ICustomArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.NotNull;

public interface ISpecialGear {

    @NotNull
    @Environment(EnvType.CLIENT)
    ICustomArmor getGearModel();
}