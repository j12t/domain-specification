package com.jt93.domain.specification;

import org.junit.Assert;
import org.junit.Test;

import com.jt93.domain.specification.impl.ContainsSpecification;
import com.jt93.domain.specification.sample.User;

public class ContainsSpecificationTest {

	@Test
	public void testSatifactionIgnoreCase() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");

		DomainSpecification<User> spec = new ContainsSpecification<User>("name", User::getName, "Upo", true);

		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionCaseSensitive() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");

		DomainSpecification<User> spec = new ContainsSpecification<User>("name", User::getName, "Upo", false);

		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionLikeOK() {

		DomainSpecification<User> spec = new ContainsSpecification<User>("name", User::getName, "Upo", true);

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionLikeKO() {

		DomainSpecification<User> spec = new ContainsSpecification<User>("name", User::getName, "Upo", true);

		User user2 = new User();
		user2.setName("DUPUIS");
		user2.setFirstname("Jean");

		Assert.assertFalse(spec.isSatisfiedBy(user2));
	}
}
