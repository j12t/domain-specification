package com.jt93.domain.specification;

import java.util.Arrays;

public class OrDomainSpecification<T> extends AbstractDomainSpecification<T> {

    @Override
    public boolean isSatisfiedBy(final T candidate) {
    	
        boolean result = true;

        for (DomainSpecification<T> specification : this.getSpecifications()) {
            result |= specification.isSatisfiedBy(candidate);
        }
        return result;
        //TODO J12T : optimization ??? 
//        for (DomainSpecification<T> specification : this.getSpecifications()) {
//        	if(specification.isSatisfiedBy(candidate)) {
//        		return true;
//        	}
//        }
//        return false;
    }
    
    @SafeVarargs
    public OrDomainSpecification(DomainSpecification<T>... specifications) {
        super(Arrays.asList(specifications));
    }

}