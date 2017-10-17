package com.pluralsight.model;

/*
create table users (
		username varchar (50) not null primary key,
		password varchar (50) not null,
		enabled boolean not null);

insert into users values ("berchris", "secret", true);
 
create table authorities (
		username varchar (50) not null,
		authority varchar (50) not null,
		constraint fk_authorities_users
		foreign key(username) references users(username));

create unique index ix_auth_username on
		authorities (username, authority);

insert into authorities values ("berchris", "ROLE_USER");
*/

public class User {
	
	private String username;
	
	private String password;
	
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
