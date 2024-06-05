package com.khanhnhi.models;

import java.util.HashMap;
import java.util.Map;

public class Server {
	private static Server instance = null;
	private Map<String, String> userCredentials = new HashMap<>();
	private HashMap<String, Account> accounts = new HashMap<>();

	private Server() {
		userCredentials.put("admin", "admin");
		accounts.put("admin", new Account(Role.ADMIN, "admin", "admin"));
	}

	public static Server getInstance() {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}

	public Map<String, String> getUserCredentials() {
		return userCredentials;
	}

	public Role getUserRole(String username) {
	    if (accounts.containsKey(username)) {
	        return accounts.get(username).getRole();
	    }
	    return null;
	}
	
	public Account getAccount(String username) {
		return accounts.get(username);
	}
	
	public boolean login(String username, String password) {
		if (accounts.containsKey(username)) {
			Account account = accounts.get(username);
			if (account.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean signup(String username, String password, Role role) {
        if (!accounts.containsKey(username)) {
            Account newAccount = new Account(role, username, password);
            accounts.put(username, newAccount);
            userCredentials.put(username, password);
            return true; // Đăng ký thành công
        }
        return false; // Đăng ký không thành công, tên người dùng đã tồn tại
    }
}