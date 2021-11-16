package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.TestDataReader;

public class HomePageTestsLoginWithExcel extends BaseOperation{
  
	/*
	@Test (priority =0, groups = "MultipleTests")
	public void verifyTitleOfTheHomePage() throws Exception{
		
		String expectedHomePageTitle= configProperties.getProperty("homepageTitle");
		//Assert.assertEquals(cmnDriver.getTitle(),"Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance");
		Assert.assertEquals(cmnDriver.getTitle(),expectedHomePageTitle);
		
	}
	*/
	
	@Test(priority = 1, groups="MultipleTests")
	public void verifyUserLogin() throws Exception{
		
		homepage.userLogin(configProperties.getProperty("userName"), configProperties.getProperty("userPassword"));
		
		System.out.println("Current Project Directory path :" + currentProjectDirectory);
		camera.captureAndSaveScreenshot(currentProjectDirectory + "/screenshots/verifyUserLogin.png");
		System.out.println("Welcome text from App :" + homepage.getWelcomeText());
		System.out.println("-----------------------------------------------------");
		System.out.println("Message from config.properties :" + configProperties.getProperty("homepageWelcomeText"));
		System.out.println("-----------------------------------------------------");
		Assert.assertEquals(homepage.getWelcomeText(), configProperties.getProperty("homepageWelcomeText"));
	}
	
/*
	@Test(priority = 1, groups = "MultipleTests",dataProvider = "getData", dataProviderClass = TestDataReader.class)
	public void verifyUserLogin(String userName, String userPassword) throws Exception{
		
		homepage.userLogin(userName, userPassword);
		
		System.out.println("Current Project Directory path :" + currentProjectDirectory);
		camera.captureAndSaveScreenshot(currentProjectDirectory + "/screenshots/verifyUserLogin.png");
		System.out.println("Welcome text from App :" + homepage.getWelcomeText());
		System.out.println("-----------------------------------------------------");
		System.out.println("Message from config.properties :" + configProperties.getProperty("homepageWelcomeText"));
		System.out.println("-----------------------------------------------------");
		Assert.assertEquals(homepage.getWelcomeText(), configProperties.getProperty("homepageWelcomeText"));
	}
	*/
	@AfterMethod (groups="MultipleTests")
	public void verifyLogOff() throws Exception{
		homepage.logOff();
	}
}
