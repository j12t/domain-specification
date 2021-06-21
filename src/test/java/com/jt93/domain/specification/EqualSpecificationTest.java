package com.jt93.domain.specification;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.jt93.domain.specification.impl.EqualSpecification;
import com.jt93.domain.specification.impl.LitteralEqualSpecification;
import com.jt93.domain.specification.sample.User;

public class EqualSpecificationTest {

	@Test
	public void testSatifactionOnStringField() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");

		DomainSpecification<User> spec = new EqualSpecification<User, String>("name", User::getName, "DUPONT");

		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

	@Test
	public void testLitteralSatifactionIgnoreCase() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");

		DomainSpecification<User> spec = new LitteralEqualSpecification<User>("name", User::getName, "DUponT", true);
		DomainSpecification<User> spec2 = new LitteralEqualSpecification<User>("name2", User::getName, "DUponT");

		Assert.assertTrue(spec.isSatisfiedBy(user));
		Assert.assertTrue(spec2.isSatisfiedBy(user));
	}

	@Test
	public void testLitteralSatifactionCaseSensitive() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");

		DomainSpecification<User> spec = new LitteralEqualSpecification<User>("name", User::getName, "DUponT", false);

		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionOnBooleanField() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		user.setEnabled(true);

		DomainSpecification<User> spec = new EqualSpecification<User, Boolean>("enabled", User::isEnabled, true);
		DomainSpecification<User> spec2 = new EqualSpecification<User, Boolean>("enabled2", User::isEnabled, Boolean.TRUE);

		Assert.assertTrue(spec.isSatisfiedBy(user));
		Assert.assertTrue(spec2.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionOnBooleanFieldWithStringValue() {

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		user.setEnabled(true);

		DomainSpecification<User> spec = new EqualSpecification<User, Boolean>("enabled", User::isEnabled, Boolean.parseBoolean("true"));

		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

	@Test
	public void testSatifactionOnDateField() {

		Date now = new Date();

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		user.setEnabled(true);
		user.setBirthDate(now);

		DomainSpecification<User> spec = new EqualSpecification<User, Date>("birthdate", User::getBirthDate, now);

		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

}
