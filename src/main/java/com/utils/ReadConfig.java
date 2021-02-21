package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
Properties prop;

public String getValue(String key) throws IOException {
	try {
		FileInputStream fis = new FileInputStream(new File("./utility/config.properties"));
		prop = new Properties();
		prop.load(fis);
	} catch (FileNotFoundException e) {
		System.out.print(e.getMessage());
	}
	
	return prop.getProperty(key);
}
}
