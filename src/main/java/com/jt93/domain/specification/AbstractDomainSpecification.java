package com.jt93.domain.specification;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public abstract class AbstractDomainSpecification<T> implements DomainSpecification<T> {

	private List<DomainSpecification<T>> specifications;
	private String name;

	public AbstractDomainSpecification() {
		this.specifications = Arrays.asList(this);
	}

	public AbstractDomainSpecification(List<DomainSpecification<T>> specifications) {
		this.specifications = specifications;
	}

	@Override
	public DomainSpecification<T> or(DomainSpecification<T> specification) {
		return new OrDomainSpecification<T>(this, specification);
	}

	@Override
	public DomainSpecification<T> and(DomainSpecification<T> specification) {
		return new AndDomainSpecification<T>(this, specification);
	}

	@Override
	public DomainSpecification<T> negate() {
		return new NotDomainSpecification<T>(this);
	}

	public List<DomainSpecification<T>> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<DomainSpecification<T>> specifications) {
		this.specifications = specifications;
	}

}
