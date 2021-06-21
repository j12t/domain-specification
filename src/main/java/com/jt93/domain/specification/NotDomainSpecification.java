package com.jt93.domain.specification;

import java.util.Arrays;

public class NotDomainSpecification<T> extends AbstractDomainSpecification<T> {

    @Override
    public boolean isSatisfiedBy(final T candidate) {
    	
    	return !getSpecifications().get(0).isSatisfiedBy(candidate);
    }
    
    public NotDomainSpecification(DomainSpecification<T> specification) {
        super(Arrays.asList(specification));
    }

}