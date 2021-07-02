package com.jt93.domain.specification;

import org.junit.Assert;
import org.junit.Test;

import com.jt93.domain.specification.impl.ContainsSpecification;
import com.jt93.domain.specification.sample.User;

public class OrSpecificationTest {

	@Test
	public void testTrueOrFalseSatifactionOK() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "XxX", true);
		DomainSpecification<User> spec = new OrDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user1 = new User();
		user1.setName("DUPONT");
		user1.setFirstname("Jean");
		Assert.assertTrue(spec.isSatisfiedBy(user1));
	}

	@Test
	public void testFalseOrTrueSatifactionOK() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "XxX", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new OrDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user1 = new User();
		user1.setName("DUPONT");
		user1.setFirstname("Jean");
		Assert.assertTrue(spec.isSatisfiedBy(user1));
	}
	
	@Test
	public void testTrueOrTrueSatifactionOK() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new OrDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user1 = new User();
		user1.setName("DUPONT");
		user1.setFirstname("Jean");
		Assert.assertTrue(spec.isSatisfiedBy(user1));
	}
	
	@Test
	public void testFalseOrFalseSatifactionKO() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "XxX", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "XxX", true);
		DomainSpecification<User> spec = new OrDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user1 = new User();
		user1.setName("DUPONT");
		user1.setFirstname("Jean");
		Assert.assertFalse(spec.isSatisfiedBy(user1));
	}
	
}
