package mekanism.block.interfaces;

import mekanism.api.text.ILangEntry;
import org.jetbrains.annotations.NotNull;

public interface IHasDescription {

    @NotNull
    ILangEntry getDescription();
}