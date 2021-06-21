package com.jt93.domain.specification;

/**
 * Specification Interface following the Design Pattern Specification to check if conditions are satisfied by an instance of <T> object
 * This specification is a Domain-oriented specification to use for search filters or other conditions for business rules
 * 
 * @author J12T
 *
 * @param <T>
 */
public interface DomainSpecification<T> {
	
	public boolean isSatisfiedBy(T candidate);

	public DomainSpecification<T> or(DomainSpecification<T> specification);

	public DomainSpecification<T> and(DomainSpecification<T> specification);

	public DomainSpecification<T> negate();
}
