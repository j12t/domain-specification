package com.jt93.domain.specification.impl;

import java.util.Date;
import java.util.function.Function;

import com.jt93.domain.specification.AbstractDomainSpecification;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
/**
 * Specification to check if a parameter (or a complex function called on a <T> object) referencing a date is before a value
 * 
 * @author J12T
 *
 * @param <T>
 */
public class DateBeforeSpecification<T> extends AbstractDomainSpecification<T> {

	/**
	 * Name of the specification (optional) in order to retrieve specific treatment (behaves like an id)
	 */
	private Function<T, Date>	function;
	private Date				value;

	/**
	 * Constructor DateAfter Specification
	 * 
	 * @param function function to call on <T> object in order to check if it contains the value
	 * @param value    the value to check
	 */
	public DateBeforeSpecification(String name, Function<T, Date> function, Date value) {
		setName(name);
		this.function = function;
		this.value = value;
	}

	@Override
	public boolean isSatisfiedBy(T candidate) {

		// if value is blank no evaluation needed
		if (value == null)
			return true;

		Date fieldValue = function.apply(candidate);

		// evaluate the satisfaction
		return fieldValue.before(value);
	}

}
