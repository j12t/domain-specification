package com.jt93.domain.specification;

import org.junit.Assert;
import org.junit.Test;

import com.jt93.domain.specification.impl.ContainsSpecification;
import com.jt93.domain.specification.sample.User;

public class AndSpecificationTest {

	@Test
	public void testTrueAndTrueOK() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new AndDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user1 = new User();
		user1.setName("DUPONT");
		user1.setFirstname("Jean");
		Assert.assertTrue(spec.isSatisfiedBy(user1));
	}

	@Test
	public void testFalseAndTrueKO() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new AndDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Louis");
		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSTrueAndFalseKO() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new AndDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user = new User();
		user.setName("DUPUIS");
		user.setFirstname("Jean");
		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

	@Test
	public void testFalseAndFalseKO() {
		
		DomainSpecification<User> nameSpec = new ContainsSpecification<User>("name", User::getName, "Upo", true);
		DomainSpecification<User> firstnameSpec = new ContainsSpecification<User>("firstname", User::getFirstname, "EaN", true);
		DomainSpecification<User> spec = new AndDomainSpecification<User>(nameSpec, firstnameSpec);
		
		User user = new User();
		user.setName("DUPUIS");
		user.setFirstname("Louis");
		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

}
