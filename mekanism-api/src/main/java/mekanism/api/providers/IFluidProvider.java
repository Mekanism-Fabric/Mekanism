package mekanism.api.providers;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.fluid.Fluid;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public interface IFluidProvider extends IBaseProvider {

    /**
     * Gets the fluid this this provider represents.
     */
    @NotNull
    Fluid getFluid();

    /**
     * Creates a fluid stack of the given size using the fluid this provider represents.
     */
    @NotNull
    default FluidVariant getFluidStack() {
        return FluidVariant.of(getFluid());
    }

    @Override
    default Text getRegistryName() {
        return getFluid().getBucketItem().getName();
    }

    @Override
    default Text getTextComponent() {
        return getFluid().getBucketItem().getName();
    }

    @Override
    default String getTranslationKey() {
        return getFluid().getBucketItem().getTranslationKey();
    }
}