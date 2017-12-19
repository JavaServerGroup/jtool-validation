package com.jtool.annotation;

import com.jtool.validator.AvailableValuesByEnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AvailableValuesByEnumValidator.class)
public @interface AvailableValuesByEnum {

    String message() default "{.not available values}";

    Class<? extends Enum<?>> value();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
