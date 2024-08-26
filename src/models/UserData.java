package models;

import java.util.HashMap;

public class UserData {
	private static UserData instance;

	private HashMap<String, Object> dataMap;

	private UserData() {
		dataMap = new HashMap<>();
	}

	public static UserData getInstance() {
		if (instance == null) {
			instance = new UserData();
		}
		return instance;
	}

	public void putData(String key, Object data) {
		dataMap.put(key, data);
	}
	
	public Object getData(String key) {
		return dataMap.get(key);
	}

}
