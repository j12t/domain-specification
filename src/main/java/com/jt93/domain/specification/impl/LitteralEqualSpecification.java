package com.jt93.domain.specification.impl;

import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Specification to check if a Stirng parameter (or a complex function called on a <T> object and returning a String value) is exactly equals to a
 * value with option to ignore case or not
 * 
 * @author J12T
 *
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LitteralEqualSpecification<T> extends EqualSpecification<T, String> {

	private boolean ignoreCase;

	/**
	 * Constructor Contains Specification not case-sensitive
	 * 
	 * @param getValue function to call on <T> object in order to check if it equals the value
	 * @param value    the value to check
	 */
	public LitteralEqualSpecification(String name, Function<T, String> function, String value, boolean ignoreCase) {
		super(name, function, value);
		this.ignoreCase = ignoreCase;
	}

	/**
	 * Constructor Contains Specification not case-sensitive
	 * 
	 * @param getValue function to call on <T> object in order to check if it equals the value
	 * @param value    the value to check
	 */
	public LitteralEqualSpecification(String name, Function<T, String> function, String value) {
		this(name, function, value, true);
	}

	@Override
	public boolean isSatisfiedBy(T candidate) {

		// if value is blank no evaluation needed
		if (StringUtils.isBlank(getValue()))
			return true;

		String fieldValue = getFunction().apply(candidate);

		// evaluate the satisfaction
		if (ignoreCase)
			return fieldValue.toLowerCase().contains(getValue().toLowerCase());
		return fieldValue.contains(getValue());
	}

}
