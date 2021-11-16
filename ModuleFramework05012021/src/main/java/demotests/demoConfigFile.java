package demotests;

import java.util.Properties;

import com.mercurytravel.pages.SetupPage;

import utils.ReadConfigFileUtils;

public class demoConfigFile {

	private static Properties configProperties;
	private static String currentProjectDirectory;
	private static String configFilename;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		currentProjectDirectory= System.getProperty("user.dir");
		System.out.println(currentProjectDirectory);
		configFilename = currentProjectDirectory+"/config/config.properties";
		System.out.println(configFilename);
		
		configProperties=ReadConfigFileUtils.readProperties(configFilename);
		System.out.println(configProperties.getProperty("userName"));
		System.out.println(configProperties.getProperty("userPassword"));
	}
	
	

}
