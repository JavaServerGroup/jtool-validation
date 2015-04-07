package com.jtool.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class ConditionsValidator<T, R> {
	
	private T observation;
	
	private List<T> conditions = new ArrayList<>();
	
	private R target;
	
	private ConditionsValidator(){
	}
	
	public static <T, R> ConditionsValidator<T, R> when(T observation) {
		ConditionsValidator<T, R> conditionsValidator = new ConditionsValidator<T, R>();
		conditionsValidator.observation = observation;
		return conditionsValidator;
	}
	
	public ConditionsValidator<T, R> in(@SuppressWarnings("unchecked") T... conditionsArgs) {
		for(T condition : conditionsArgs) {
			this.conditions.add(condition);
		}
		return this;
	}
	
	public ConditionsValidator<T, R> then(R target) {
		this.target = target;
		return this;
	}
	
	public Optional<Boolean> isEqual(R expect) {
		if(!conditions.contains(observation)) {
			return Optional.empty();
		}
		
		if(target == null && expect == null) {
			return Optional.of(Boolean.TRUE);
		} else if (expect != null){
			return Optional.of(expect.equals(target));
		} else if (target != null) {
			return Optional.of(target.equals(expect));
		} else {
			return Optional.of(Boolean.FALSE);
		}
	}
	
	public Optional<Boolean> isNotEqual(R expect) {
		Optional<Boolean> result = this.isEqual(expect);
		return reverseOptional(result);
	}
	
	public Optional<Boolean> isStartWith(String startWith) {
		if(!conditions.contains(observation)){
			return Optional.empty();
		}
		if(target == null || !(target instanceof String)) {
			return Optional.of(Boolean.FALSE);
		}
		return Optional.of(((String)target).startsWith(startWith));
	}
	
	public Optional<Boolean> isNotStartWith(String startWith) {
		Optional<Boolean> result = isStartWith(startWith);
		return reverseOptional(result);
	}
	
	public Optional<Boolean> isEmpty() {
		if(!conditions.contains(observation)){
			return Optional.empty();
		}
		
		try {
			return Optional.of(StringUtils.isEmpty((String)target));
		} catch (Exception e) {
			return Optional.of(false);
		} 
	}
	
	public Optional<Boolean> isNotEmpty() {
		Optional<Boolean> result = isEmpty();
		return reverseOptional(result);
	}

	private Optional<Boolean> reverseOptional(Optional<Boolean> result) {
		if(result.isPresent()) {
			return Optional.of(!result.get());
		} else {
			return result;
		}
	}
	
}