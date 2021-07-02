package com.jt93.domain.specification.impl;

import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.jt93.domain.specification.AbstractDomainSpecification;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
/**
 * Specification to check if a parameter (or a complex function called on a <T> object) contains a value with option to ignore case or not
 * 
 * @author J12T
 *
 * @param <T>
 */
public class ContainsSpecification<T> extends AbstractDomainSpecification<T> {

	/**
	 * Name of the specification (optional) in order to retrieve specific treatment (behaves like an id)
	 */
	private Function<T, String>	function;
	private String				value;
	private boolean				ignoreCase;

	/**
	 * Constructor Contains Specification not case-sensitive
	 * 
	 * @param function function to call on <T> object in order to check if it contains the value
	 * @param value    the value to check
	 */
	public ContainsSpecification(String name, Function<T, String> function, String value, boolean ignoreCase) {
		setName(name);
		this.function = function;
		this.value = value;
		this.ignoreCase = ignoreCase;
	}

	/**
	 * Constructor Contains Specification not case-sensitive
	 * 
	 * @param getValue function to call on <T> object in order to check if it contains the value
	 * @param value    the value to check
	 */
	public ContainsSpecification(String name, Function<T, String> function, String value) {
		this(name, function, value, true);
	}

	@Override
	public boolean isSatisfiedBy(T candidate) {

		// if value is blank no evaluation needed
		if (StringUtils.isBlank(value))
			return true;

		String fieldValue = function.apply(candidate);

		// evaluate the satisfaction
		if (ignoreCase)
			return fieldValue.toLowerCase().contains(value.toLowerCase());
		return fieldValue.contains(value);
	}

}
