package com.jtool.validator;

import org.junit.Assert;
import org.junit.Test;

public class IntegerValidatorTest {

	@Test
	public void testValidate() {
		Assert.assertTrue(IntegerValidator.validate("1"));
		Assert.assertTrue(IntegerValidator.validate("01"));
		Assert.assertTrue(IntegerValidator.validate("1000000000000000000"));
		Assert.assertFalse(IntegerValidator.validate("one"));
		Assert.assertFalse(IntegerValidator.validate("1a"));
		Assert.assertFalse(IntegerValidator.validate("a1"));
	}

}
