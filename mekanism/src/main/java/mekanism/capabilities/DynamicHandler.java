package mekanism.capabilities;

import mekanism.api.IContentsListener;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class DynamicHandler<TANK> implements IContentsListener {

    protected final Function<Direction, List<TANK>> containerSupplier;
    protected final InteractPredicate canExtract;
    protected final InteractPredicate canInsert;
    @Nullable
    private final IContentsListener listener;

    protected DynamicHandler(Function<Direction, List<TANK>> containerSupplier, InteractPredicate canExtract, InteractPredicate canInsert,
          @Nullable IContentsListener listener) {
        this.containerSupplier = containerSupplier;
        this.canExtract = canExtract;
        this.canInsert = canInsert;
        this.listener = listener;
    }

    @Override
    public void onContentsChanged() {
        if (listener != null) {
            listener.onContentsChanged();
        }
    }

    @FunctionalInterface
    public interface InteractPredicate {

        InteractPredicate ALWAYS_TRUE = (tank, side) -> true;

        boolean test(int tank, @Nullable Direction side);
    }
}