package com.jtool.validate;

import static com.jtool.validate.ConditionsValidator.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class ConditionsValidatorTest {

	@Test
	public void testWhenOberInAndTargetEqExcept() {
		String ober = "a";
		String target = "z";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEqual("z");
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotEqExcept() {
		String ober = "a";
		String target = "Y";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isNotEqual("z");
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberNotInAndTargetEqExcept() {
		String ober = "d";
		String target = "z";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEqual("z");
		Assert.assertFalse(result.isPresent());
	}
	
	@Test
	public void testWhenOberNotInAndTargetNotEqExcept() {
		String ober = "d";
		String target = "Y";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEqual("z");
		Assert.assertFalse(result.isPresent());
	}
	
	//-------------------------------------------------------------
	
	@Test
	public void testWhenOberInAndTargetEqExceptIntVersion() {
		int ober = 1;
		int target = 99;
		Optional<Boolean> result = when(ober).in(1, 2, 33).then(target).isEqual(99);
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotEqExceptIntVersion() {
		int ober = 1;
		int target = 89;
		Optional<Boolean> result = when(ober).in(1, 2, 3).then(target).isNotEqual(99);
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberNotInAndTargetEqExceptIntVersion() {
		int ober = 0;
		int target = 99;
		Optional<Boolean> result = when(ober).in(1, 2, 3).then(target).isEqual(99);
		Assert.assertFalse(result.isPresent());
	}
	
	@Test
	public void testWhenOberNotInAndTargetNotEqExceptIntVersion() {
		int ober = 0;
		int target = 99;
		Optional<Boolean> result = when(ober).in(1, 2, 3).then(target).isEqual(98);
		Assert.assertFalse(result.isPresent());
	}
	
	//-------------------------------------------------------------
	
	@Test
	public void testWhenOberInAndTargetStartWith() {
		String ober = "a";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isStartWith("0");
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotStartWith() {
		String ober = "a";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isNotStartWith("9");
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberNotInAndTargetStartWith() {
		String ober = "d";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isStartWith("0");
		Assert.assertFalse(result.isPresent());
	}
	
	@Test
	public void testWhenOberNotInAndTargetNotStartWith() {
		String ober = "d";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isStartWith("9");
		Assert.assertFalse(result.isPresent());
	}
	
	//-------------------------------------------------------------
	
	@Test
	public void testWhenOberInAndTargetEmpty() {
		String ober = "a";
		String target = null;
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEmpty();
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotEmpty() {
		String ober = "a";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isNotEmpty();
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberNotInAndTargetEmpty() {
		String ober = "d";
		String target = null;
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEmpty();
		Assert.assertFalse(result.isPresent());
	}
	
	@Test
	public void testWhenOberNotInAndTargetNotEmpty() {
		String ober = "d";
		String target = "086";
		Optional<Boolean> result = when(ober).in("a", "b", "c").then(target).isEmpty();
		Assert.assertFalse(result.isPresent());
	}
	
	//-------------------------------------------------------------
	
	@Test
	public void testWhenOberInAndTargetNullExceptNull() {
		String ober = "a";
		String target = null;
		Optional<Boolean> result = when(ober).in("a", "b").then(target).isEqual(null);
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetExceptNull() {
		String ober = "a";
		String target = "b";
		Optional<Boolean> result = when(ober).in("a", "b").then(target).isNotEqual(null);
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNullStartWith() {
		String ober = "a";
		String target = null;
		Optional<Boolean> result = when(ober).in("a", "b").then(target).isNotStartWith("0");
		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotStringStartWith() {
		String ober = "a";
		int target = 1;
		Optional<Boolean> result = when(ober).in("a", "b").then(target).isStartWith("1");
		Assert.assertTrue(result.isPresent());
		Assert.assertFalse(result.get());
	}
	
	@Test
	public void testWhenOberInAndTargetNotStringIsEmpty() {
		String ober = "a";
		int target = 1;
		Optional<Boolean> result = when(ober).in("a", "b").then(target).isEmpty();
		Assert.assertTrue(result.isPresent());
		Assert.assertFalse(result.get());
	}
}