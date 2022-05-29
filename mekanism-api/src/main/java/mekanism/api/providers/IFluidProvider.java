package mekanism.api.providers;

import io.github.fabricators_of_create.porting_lib.util.FluidUtil;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public interface IFluidProvider  {

    /**
     * Gets the fluid this provider represents.
     */
    @NotNull
    Fluid getFluid();

    /**
     * Creates a fluid stack of the given size using the fluid this provider represents.
     *
     * @param size Size of the stack.
     */
    @NotNull
    default SingleVariantStorage<FluidVariant> getFluidStack(int size) {
        return new SingleVariantStorage<>() {
            @Override
            protected FluidVariant getBlankVariant() {
                return FluidVariant.of(getFluid());
            }

            @Override
            protected long getCapacity(FluidVariant variant) {
                return size;
            }
        };
    }

    default String getTranslationKey(Fluid fluid) {
        return FluidUtil.getTranslationKey(fluid);
    }

}