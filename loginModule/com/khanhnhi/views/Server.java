package com.khanhnhi.views;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Server instance = null;
    private Map<String, String> userCredentials = new HashMap<>();

    private Server() {
        userCredentials.put("admin", "admin");
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
}