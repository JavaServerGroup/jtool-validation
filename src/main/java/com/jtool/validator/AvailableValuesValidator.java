package com.jtool.validator;

import com.jtool.annotation.AvailableValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenfengbin on 15-8-20.
 */
public class AvailableValuesValidator implements ConstraintValidator<AvailableValues,String> {

    List<String> values;
    @Override
    public void initialize(AvailableValues constraintAnnotation) {
        values = new ArrayList<>();
        values = Arrays.asList(constraintAnnotation.values());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return values.contains(value);
    }
}
