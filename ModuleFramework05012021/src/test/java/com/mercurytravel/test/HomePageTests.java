package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DateUtils;

public class HomePageTests extends BaseOperation{
  
	@Test (priority =0, groups = "Sanity")
	public void verifyTitleOfTheHomePage() throws Exception{
		
		test = extent.createTest("Test case Id:  Test-002: Verify Title of Home Page");
		
		String expectedHomePageTitle= configProperties.getProperty("homepageTitle");
		//Assert.assertEquals(cmnDriver.getTitle(),"Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance");
		Assert.assertEquals(cmnDriver.getTitle(),expectedHomePageTitle);
		
		test.info("Validating the title of Home Page : " + expectedHomePageTitle);
	}
	
	@Test(priority = 1, groups = "Sanity")
	public void verifyUserLogin() throws Exception{
		
		test = extent.createTest("Test case Id:  Test-003: Verify user Login");
		
		homepage.userLogin(configProperties.getProperty("userName"), configProperties.getProperty("userPassword"));
		
		System.out.println("Current Project Directory path :" + currentProjectDirectory);
		camera.captureAndSaveScreenshot(currentProjectDirectory + "/screenshots/verifyUserLogin" + DateUtils.getDate()+".png");
		System.out.println("Welcome text from App :" + homepage.getWelcomeText());
		System.out.println("-----------------------------------------------------");
		System.out.println("Message from config.properties :" + configProperties.getProperty("homepageWelcomeText"));
		System.out.println("-----------------------------------------------------");
		Assert.assertEquals(homepage.getWelcomeText(), configProperties.getProperty("homepageWelcomeText"));
		
		test.info("Verify the Welcome message after login : " + homepage.getWelcomeText());
	}
	
	@Test(priority =2, groups="Sanity")
	public void verifyLogOff() throws Exception{
		
		test=extent.createTest("Test case Id:  Test-004: Verify user Log Out");
		
		homepage.logOff();
		
		Assert.assertEquals(homepage.getLoginLinkText(), "Customer Login");
		
		test.info("Verify user has successfully logged Off");
	}
}
