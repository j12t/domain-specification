package com.jt93.domain.specification.impl;

import java.util.function.Function;

import com.jt93.domain.specification.AbstractDomainSpecification;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Specification to check if a parameter (or a complex function called on a <T> object) is exactly equals to a value
 * 
 * @author J12T
 *
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EqualSpecification<T, C extends Comparable<?>> extends AbstractDomainSpecification<T> {

	private Function<T, C>	function;
	private C				value;

	/**
	 * Constructor Equal Specification
	 * 
	 * @param function function to call on <T> object in order to check if it contains the value
	 * @param value    the value to check
	 */
	public EqualSpecification(String name, Function<T, C> function, C value) {
		setName(name);
		this.function = function;
		this.value = value;
	}

	@Override
	public boolean isSatisfiedBy(T candidate) {

		// if value is null no evaluation needed
		if (value == null)
			return true;

		C fieldValue = getFunction().apply(candidate);

		// evaluate the satisfaction
		return fieldValue.equals(value);
	}

}
