package com.jtool.validator;

import java.math.BigInteger;

public class IntegerValidator {

	public static boolean validate(String id) {
		try {
			new BigInteger(id);
			return true;
		} catch (Exception e) { // 不是一个数字
			return false;
		}
	}
}
