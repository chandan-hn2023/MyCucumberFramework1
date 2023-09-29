package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties initializePropertiesFile() {
		
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources1\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;	
	}

}
