package com.jobvacancy.web.rest.dto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorEmail {

	 private final String patternMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	           + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//private final String patternMail = "[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+";
	// private final String patternMail = "/^[_a-z0-9]+(\\.[_a-z0-9]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$/";
	 
	 
	    public boolean validateEmail(String email) {
	 
	        Pattern pattern = Pattern.compile(this.patternMail);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
}