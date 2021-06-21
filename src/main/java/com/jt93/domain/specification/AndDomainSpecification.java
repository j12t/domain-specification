package com.jt93.domain.specification;

import java.util.Arrays;

public class AndDomainSpecification<T> extends AbstractDomainSpecification<T> {

    @Override
    public boolean isSatisfiedBy(final T candidate) {
        boolean result = true;

        for (DomainSpecification<T> specification : this.getSpecifications()) {
            result &= specification.isSatisfiedBy(candidate);
        }
        return result;
    }
    
    @SafeVarargs
    public AndDomainSpecification(DomainSpecification<T>... specifications) {
        super(Arrays.asList(specifications));
    }

}