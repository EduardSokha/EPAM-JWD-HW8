package by.sokhaeduard.eighthhw.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {
	private final static DBResourceManager instance = new DBResourceManager();
	private final static String DB_PROPERTIES_FILE = "connection";

	private ResourceBundle bundle = ResourceBundle.getBundle(DB_PROPERTIES_FILE);

	public static DBResourceManager getInstance() {
		return instance;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
}
