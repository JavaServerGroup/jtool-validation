package com.jtool.validator;

import com.jtool.annotation.AvailableValuesByEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AvailableValuesByEnumValidator implements ConstraintValidator<AvailableValuesByEnum, String> {

    private List<String> valueList;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return valueList.contains(value.toUpperCase());
    }

    @Override
    public void initialize(AvailableValuesByEnum availableValuesByEnum) {
        valueList = new ArrayList<>();
        Class<? extends Enum<?>> enumClass = availableValuesByEnum.value();

        Enum[] enumValArr = enumClass.getEnumConstants();

        for(Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }

    }
}
