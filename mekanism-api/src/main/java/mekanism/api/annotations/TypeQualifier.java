package mekanism.api.annotations;

/*
    Taken from javax
    https://github.com/amaembo/jsr-305/blob/master/ri/src/main/java/javax/annotation/meta/TypeQualifier.java
*/

import java.lang.annotation.*;

@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeQualifier {

    /**
     * Describes the kinds of values the qualifier can be applied to. If a
     * numeric class is provided (e.g., Number.class or Integer.class) then the
     * annotation can also be applied to the corresponding primitive numeric
     * types.
     *
     * @return a class object which denotes the type of the values
     * the original annotation can be applied to.
     */
    Class<?> applicableTo() default Object.class;

}
