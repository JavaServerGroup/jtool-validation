package com.jtool.validator;

import java.util.List;

public class ValidationResult {

    private boolean valid;

    private List<ValidationResultsExceptionItem> validationResultsExceptions;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<ValidationResultsExceptionItem> getValidationResultsExceptions() {
        return validationResultsExceptions;
    }

    public void setValidationResultsExceptions(List<ValidationResultsExceptionItem> validationResultsExceptions) {
        this.validationResultsExceptions = validationResultsExceptions;
    }
}
