package com.jobvacancy.web.rest.dto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorJobApplicationData {

	 private final String patternMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	           + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 private final String patternLink =  "^(ftp|http|https)://?(([\\w!~*'().&=+$%-]+: )?[\\w!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([\\w!~*'()-]+\\.)*([\\w^-][\\w-]{0,61})?[\\w]\\.[a-z]{2,6})(:[0-9]{1,4})?((/*)|(/+[\\w!~*'().;?:@&=+$,%#-]+)+/*)$";
	 
	    public boolean validate(String string, String campo) {
	    	Pattern pattern=null;
	        if(campo.compareTo("mail")==0){
	        	pattern = Pattern.compile(this.patternMail);
	        }else{
	        	pattern = Pattern.compile(this.patternLink);
	        }
	        Matcher matcher = pattern.matcher(string);
	        return matcher.matches();
	    }
}