package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFileUtils {
	
	//filename --> full path of the file including the filename. We will use this method to read the config.properties file & retreive the key/value pairs
	public static Properties readProperties(String filename) throws Exception{
		
		filename = filename.trim();
		
		//To read from a file, we need an input stream. InputStream is the class that is used to read data from a file
		InputStream fileReader = new FileInputStream(filename);
	
		//Properties class is used to capture the data in key-value pairs
		Properties property = new Properties();
		
		//load the Inputstream file into the property format
		property.load(fileReader);
		
		return property;
	}

}
