package mekanism.item.interfaces;

import mekanism.api.IIncrementalEnum;
import mekanism.api.text.EnumColor;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface IRadialSelectorEnum<TYPE extends Enum<TYPE> & IRadialSelectorEnum<TYPE>> extends IIncrementalEnum<TYPE> {

    Text getShortText();

    Identifier getIcon();

    default EnumColor getColor() {
        return null;
    }
}