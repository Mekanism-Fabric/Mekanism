package mekanism.api;

import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Interface for enum's to make them easily incremental, while allowing for disabling various elements
 */
public interface IDisableableEnum<TYPE extends Enum<TYPE> & IDisableableEnum<TYPE>> extends IIncrementalEnum<TYPE> {

    /**
     * Used to check if a given element is enabled.
     *
     * @return {@code true} if the element is enabled, {@code false} otherwise.
     */
    boolean isEnabled();

    @NotNull
    @Override
    default TYPE getNext(@NotNull Predicate<TYPE> isValid) {
        return IIncrementalEnum.super.getNext(element -> element.isEnabled() && isValid.test(element));
    }

    @NotNull
    @Override
    default TYPE getPrevious(@NotNull Predicate<TYPE> isValid) {
        return IIncrementalEnum.super.getPrevious(element -> element.isEnabled() && isValid.test(element));
    }

    @NotNull
    @Override
    default TYPE adjust(int shift) {
        //Note: We can just pass an always true predicate as we intercept getNext and getPrevious calls to
        // ensure that they test the element is enabled
        return adjust(shift);
    }
}