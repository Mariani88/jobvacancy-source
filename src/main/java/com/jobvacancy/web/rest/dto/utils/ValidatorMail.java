package com.jobvacancy.web.rest.dto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorMail {

	 private final String patternMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	    public boolean validateEmail(String email) {
	 
	        Pattern pattern = Pattern.compile(this.patternMail);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
}