package co.simplon.starting1.infra.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	Properties prop = null;

	public ConfigFileReader() throws IOException {

		prop = new Properties();
		String propFileName = "config.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	}

	public String getConfigProperty(String propertyName) {
		String result = null;

		if (prop.containsKey(propertyName)) {
			result = prop.getProperty(propertyName);
		}
		return result;
	}
}
