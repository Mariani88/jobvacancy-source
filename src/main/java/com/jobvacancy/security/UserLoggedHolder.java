package com.jobvacancy.security;

import org.springframework.stereotype.Component;

import com.jobvacancy.domain.User;

@Component
public class UserLoggedHolder {

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
