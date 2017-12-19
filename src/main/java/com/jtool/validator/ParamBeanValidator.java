package com.jtool.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParamBeanValidator {

	private static Logger logger = LoggerFactory.getLogger(ParamBeanValidator.class);
	private static ValidatorFactory vf = Validation.buildDefaultValidatorFactory();

	public static Validator getValidator() {
		return vf.getValidator();
	}

	public static boolean isValid(Object bean, Class... classes) {

		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Object>> constraintViolationResult = validator.validate(bean, classes);
		if (constraintViolationResult.isEmpty()) {
			return true;
		} else {
			for(ConstraintViolation<Object> item : constraintViolationResult) {
				logger.info("[参数错误] " + item.getPropertyPath() + ": " + item.getMessage());
			}
			return false;
		}
	}

	public static boolean isNotValid(Object bean, Class... classes) {
		return !isValid(bean, classes);
	}

	public static ValidationResult valid(Object bean, Class... classes) {

		ValidationResult result = new ValidationResult();

		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Object>> constraintViolationResult = validator.validate(bean, classes);
		if (constraintViolationResult.isEmpty()) {
			result.setValid(true);
		} else {
			result.setValid(false);
			List<ValidationResultsExceptionItem> validationResultsExceptionItems = new ArrayList<>();
			for(ConstraintViolation<Object> item : constraintViolationResult) {
				logger.info("[参数错误] " + item.getPropertyPath() + ": " + item.getMessage());
				ValidationResultsExceptionItem validationResultsExceptionItem = new ValidationResultsExceptionItem(item.getPropertyPath().toString(), item.getMessage());
				validationResultsExceptionItems.add(validationResultsExceptionItem);
			}
			result.setValidationResultsExceptions(validationResultsExceptionItems);
		}

		return result;
	}

}
