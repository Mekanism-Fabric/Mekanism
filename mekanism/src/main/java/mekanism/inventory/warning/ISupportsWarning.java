package mekanism.inventory.warning;

import java.util.function.BooleanSupplier;
import mekanism.inventory.warning.WarningTracker.WarningType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ISupportsWarning<TYPE extends ISupportsWarning<TYPE>> {

    TYPE warning(@NotNull WarningType type, @NotNull BooleanSupplier warningSupplier);

    static BooleanSupplier compound(@Nullable BooleanSupplier existing, BooleanSupplier newSupplier) {
        return existing == null ? newSupplier : (() -> existing.getAsBoolean() || newSupplier.getAsBoolean());
    }
}