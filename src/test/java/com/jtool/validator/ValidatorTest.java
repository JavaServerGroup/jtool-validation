package com.jtool.validator;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.jtool.validator.ParamBeanValidator;

public class ValidatorTest {

	@Test
	public void testIsValid() {
		Account account = makeAccount();
		assertTrue(ParamBeanValidator.isValid(account));
	}

	@Test
	public void testBrithdayAfterNow() {
		Account account = makeAccount();
		account.setBirthday(DateUtils.addDays(new Date(), 1));
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testBrithdayBeforeNow() {
		Account account = makeAccount();
		account.setBirthday(DateUtils.addDays(new Date(), -1));
		assertTrue(ParamBeanValidator.isValid(account));
	}

	@Test
	public void testUsernameRequire() {
		Account account = makeAccount();
		account.setUsername("");
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testUsernameNull() {
		Account account = makeAccount();
		account.setUsername(null);
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testUsernameMinLenth() {
		Account account = makeAccount();
		account.setUsername("a");
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testUsernameMaxLenth() {
		Account account = makeAccount();
		account.setUsername("abcdefghijklmnopqrstu");
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testAgeMinValue() {
		Account account = makeAccount();
		account.setAge(-1);
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testAgeMaxValue() {
		Account account = makeAccount();
		account.setAge(121);
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testEmail() {
		Account account = makeAccount();
		account.setEmail("jiale.chan@gmail.com");
		assertTrue(ParamBeanValidator.isValid(account));
	}

	@Test
	public void testErrorEmail() {
		Account account = makeAccount();
		account.setEmail("a@a");
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	@Test
	public void testInfoTooLong() {
		Account account = makeAccount();
		account.setInfo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertTrue(ParamBeanValidator.isNotValid(account));
	}

	private Account makeAccount() {
		Account account = new Account();
		account.setUsername("jiale.chan");
		account.setAddress("SZ GD China");
		account.setBirthday(new Date(System.currentTimeMillis() - 10000));
		account.setAge(10);
		account.setEmail("jiale.chan@gmail.com");
		return account;
	}
}
