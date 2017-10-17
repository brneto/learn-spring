package com.pluralsight.model;

public class Authority {
	
	private User user;
	
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public User getUser() {
		return user;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
