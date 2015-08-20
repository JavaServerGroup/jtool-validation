package com.jtool.annotation;

import com.jtool.validator.AvailableValuesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenfengbin on 15-8-20.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AvailableValuesValidator.class)
public @interface AvailableValues {

    String message() default "{.not message}";

    String[] values() default {};

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
