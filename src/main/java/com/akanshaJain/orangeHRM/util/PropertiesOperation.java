package com.akanshaJain.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.akanshaJain.orangeHRM.constants.ConstantPath;

public class PropertiesOperation {
	private Properties properties;
	
	public PropertiesOperation(String fileName) throws IOException {
		File file = new File(ConstantPath.PROPERTIES_FILE_LOCATION + fileName + ".properties");
		FileInputStream inputStream = new FileInputStream(file);
		properties = new Properties();
		properties.load(inputStream);
	}

	public String getValue(String key) {
		String value = properties.getProperty(key);
		return value;
	}
}