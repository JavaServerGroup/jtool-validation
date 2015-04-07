package com.jtool.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParamBeanValidator {

	protected static Logger logger = LoggerFactory.getLogger(ParamBeanValidator.class);

	public static boolean isValid(Object bean) {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Object>> result = validator.validate(bean);
		if (result.size() == 0) {
			return true;
		} else {
			for(ConstraintViolation<Object> item : result) {
				logger.info("[参数错误] " + item.getPropertyPath() + ": " + item.getMessage());
			}
			return false;
		}
	}

	public static boolean isNotValid(Object bean) {
		return !isValid(bean);
	}

}
