package org.eniauction.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	private static Properties properties;

	// bloc d’initialisation
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String valeur = properties.getProperty(key);
		return valeur;
	}

}