package com.jobvacancy.web.rest.dto.utils;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorEmailTest {
	
	private String[] emails;
	private ValidatorEmail validatorMail = new ValidatorEmail (); 
	
    @Test
    public void validEmailTest() {
 
    	this.loadValidsEmailsForTest();
       	
        for (String mail: this.emails) {    	
        	boolean valid = this.validatorMail.validateEmail(mail); 
            Assert.assertTrue (valid);
        }
    }
    
    @Test
    public void invalidEmailTest() {
 
    	this.loadInvalidsEmailsForTest();
    	
        for (String mail : this.emails) {
        	boolean valid = this.validatorMail.validateEmail(mail); 
            Assert.assertFalse (valid);
        }
    }
    
    private void loadValidsEmailsForTest() {
    	 this.emails= new String[] { "test@example.com",
                "test-101@example.com", "test.101@yahoo.com",
                "test101@example.com", "test_101@example.com",
                "test-101@test.net", "test.100@example.com.au", "test@e.com",
                "test@1.com", "test@example.com.com", "test+101@example.com",
                "101@example.com", "test-101@example-test.com", "matias@live.com.ar" };
	}

    private void loadInvalidsEmailsForTest() {
    	  this.emails = new String[] { "example", "example@.com.com",
    	            "exampel101@test.a", "exampel101@.com", ".example@test.com",
    	            "example**()@test.com", "example@%*.com",
    	            "example..101@test.com", "example.@test.com",
    	            "test@example_101.com", "example@test@test.com",
    	            "example@test.com.a5" };
    }
}