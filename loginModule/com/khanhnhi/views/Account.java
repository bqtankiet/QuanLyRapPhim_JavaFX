package com.khanhnhi.views;

public class Account {
	private Role role;
	private String username;
	private String password;

	public Account(Role role, String username, String password) {
		super();
		this.role = role;
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return this.role == Role.ADMIN;
	}
}

enum Role {
	ADMIN, USER
}
