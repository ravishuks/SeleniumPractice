package com.mercurytravel.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercurytravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import utils.DateUtils;
import utils.ReadConfigFileUtils;

public class BaseOperation {

	public CommonDriver cmnDriver;
	public HomePage homepage;
	public ScreenshotControl camera;
	
	public WebDriver driver;
	public Properties configProperties;
	public String currentProjectDirectory;
	private String configFilename;
	//declare the html reporter
	public ExtentHtmlReporter htmlReporter;
	//declare the extent report
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void initialSetup() throws Exception{
		currentProjectDirectory= System.getProperty("user.dir");
		
		configFilename = currentProjectDirectory+"/config/config.properties";
		
		configProperties=ReadConfigFileUtils.readProperties(configFilename);
		
		String reportName = String.format("%s/reports/%s%s.html", currentProjectDirectory,DateUtils.getDate(),configProperties.getProperty("reportName"));
		
		// initialize htmlReporter
		htmlReporter = new ExtentHtmlReporter(reportName);
		
		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		
		test = extent.createTest("Test case Id:  Test-001: Invoke Browser");
		
		//configProperties=ReadConfigFileUtils.readProperties("C://Users//ravshukla//eclipse-workspace//ModuleFramework05012021/config//config.properties");
		cmnDriver = new CommonDriver(configProperties.getProperty("browserType"));
		
		test.info("Browser Type is :::" + configProperties.getProperty("browserType"));
		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);
		camera = new ScreenshotControl(driver);
		
		//cmnDriver.setPageLoadTimeOut(20);
		//cmnDriver.setElementDetectionTimeOut(10);
		int pageLoadTimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeOut(pageLoadTimeout);
		test.info("Page Load timeout is ::: " + pageLoadTimeout);
		
		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeOut(elementDetectionTimeout);
		test.info("Element detection Timeout ::: " + elementDetectionTimeout);
		
		cmnDriver.navigateToFirstURL(configProperties.getProperty("baseUrl"));
	}
	
	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception{
		
		if (result.getStatus()==ITestResult.FAILURE) {
			test.fail("Test Case failed ::: " + result.getName());
			
			String filename = String.format("%s/screenshots/%s%s.png", currentProjectDirectory,result.getName(),DateUtils.getDate());
			
			String resultPath = camera.captureAndSaveScreenshot(filename);
			
			test.addScreenCaptureFromPath(resultPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test case skipped :: " + result.getName());
		} else {
			test.pass("Test case passed ::" + result.getName());
		} 
	}
	
	@AfterClass
	public void closeBrowser() throws Exception{
		cmnDriver.closeBrowser();
		
	}
	
	@AfterSuite
	public void cleanup() {
		extent.flush();
	}

}
