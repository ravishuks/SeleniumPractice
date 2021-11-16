package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportGenerator {

	//declare the html reporter
	public ExtentHtmlReporter htmlReporter;
	
	//declare the extent report
	public ExtentReports extent;
	
	public void initializeExtentReports(String sReportName) throws Exception{
		// initialize htmlReporter
		htmlReporter = new ExtentHtmlReporter(sReportName);
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
	}

	public void setupExtentReport(String sReportName) throws Exception{
		// initialize htmlReporter
		htmlReporter = new ExtentHtmlReporter(sReportName);
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
	}
}
