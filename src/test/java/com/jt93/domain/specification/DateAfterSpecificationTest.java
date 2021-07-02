package com.jt93.domain.specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import com.jt93.domain.specification.impl.DateAfterSpecification;
import com.jt93.domain.specification.sample.User;

public class DateAfterSpecificationTest {

	@Test
	public void testAfterOK() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		user.setBirthDate(sdf.parse("20000101"));

		DomainSpecification<User> spec = new DateAfterSpecification<User>("name", User::getBirthDate, sdf.parse("19991231"));

		Assert.assertTrue(spec.isSatisfiedBy(user));
	}

	@Test
	public void testBeforeKO() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		User user = new User();
		user.setName("DUPONT");
		user.setFirstname("Jean");
		user.setBirthDate(sdf.parse("20000101"));

		DomainSpecification<User> spec = new DateAfterSpecification<User>("name", User::getBirthDate, sdf.parse("20000102"));

		Assert.assertFalse(spec.isSatisfiedBy(user));
	}

}
