package com.khanhnhi.models;

public class Account {
	private Role role;
	private String username;
	private String password;

	public Account(Role role, String username, String password) {
		super();
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		return role == other.role && (username == null ? other.username == null : username.equals(other.username))
				&& (password == null ? other.password == null : password.equals(other.password));
	}

	// Method to provide a string representation of the Account object
	@Override
	public String toString() {
		return "Account{" + "role=" + role + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}

