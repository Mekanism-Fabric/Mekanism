//package mekanism.api.providers;
//
//import mekanism.api.chemical.Chemical;
//import mekanism.api.chemical.ChemicalStack;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//import org.jetbrains.annotations.NotNull;
//
//public interface IChemicalProvider<CHEMICAL extends Chemical<CHEMICAL>> extends IBaseProvider {
//
//    /**
//     * Gets the chemical this provider represents.
//     */
//    @NotNull
//    CHEMICAL getChemical();
//
//    /**
//     * Creates a chemical stack of the given size using the chemical this provider represents.
//     *
//     * @param size Size of the stack.
//     */
//    @NotNull
//    ChemicalStack<CHEMICAL> getStack(long size);
//
//    @Override
//    default Identifier getRegistryName() {
//        return getChemical().getRegistryName();
//    }
//
//    @Override
//    default Text getTextComponent() {
//        return getChemical().getTextComponent();
//    }
//
//    @Override
//    default String getTranslationKey() {
//        return getChemical().getTranslationKey();
//    }
//}