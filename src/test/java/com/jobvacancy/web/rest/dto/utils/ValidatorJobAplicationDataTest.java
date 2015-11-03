package com.jobvacancy.web.rest.dto.utils;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorJobAplicationDataTest {

	private String[] emails;
	private ValidatorJobApplicationData validator = new ValidatorJobApplicationData();

	@Test
	public void validEmailTest() {

		this.loadValidsEmailsForTest();

		for (String mail : this.emails) {
			boolean valid = this.validator.validate(mail, "mail");
			Assert.assertTrue(valid);
		}
	}

	@Test
	public void invalidEmailTest() {

		this.loadInvalidsEmailsForTest();

		for (String mail : this.emails) {
			boolean valid = this.validator.validate(mail, "mail");
			Assert.assertFalse(valid);
		}
	}

	private void loadValidsEmailsForTest() {
		this.emails = new String[] { "test@example.com", "test-101@example.com", "test.101@yahoo.com",
				"test101@example.com", "test_101@example.com", "test-101@test.net", "test.100@example.com.au",
				"test@e.com", "test@1.com", "test@example.com.com", "test+101@example.com", "101@example.com",
				"test-101@example-test.com", "matias@live.com.ar" };
	}

	private void loadInvalidsEmailsForTest() {
		this.emails = new String[] { "example", "example@.com.com", "exampel101@.com", "example**()@test.com",
				"example@%*.com", "test@example_101.com", "example@test@test.com", "hola@hola", "exampel101@test.a",
				"example@test.com.a5", ".example@test.com", "example..101@test.com", "example.@test.com" };
	}

	@Test
	public void validLinklTest() {
		Assert.assertTrue(this.validator.validate("https://www.linkedin.com/profile/view?id=AAMAABhp-"
				+ "akBJJDtLnfvsXb-3Ur2820svaUvhaU&trk=hp-identity-photo", "link"));
	}

	@Test
	public void invalidLinklTest() {
		Assert.assertFalse(this.validator.validate("hs://www.linkedin.com/profile/view?id=AAMAABhp-"
				+ "akBJJDtLnfvsXb-3Ur2820svaUvhaU&trk=hp-identity-photo", "link"));
	}
}