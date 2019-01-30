package com.jtool.validator;

/**
 * @author jialechan
 */
public class ValidateUtil {

    private ValidateUtil() {
    }

    public static void baseValidate(Object bean) {
        ValidationResult validationResult = ParamBeanValidator.valid(bean);
        if (!validationResult.isValid()) {

            StringBuilder result = new StringBuilder();

            for(ValidationResultsExceptionItem item : validationResult.getValidationResultsExceptions()) {
                result.append(item.getKey());
                result.append(": ");
                result.append(item.getInfo());
                result.append(";");
            }

            throw new IllegalArgumentException(result.toString());
        }
    }
}
