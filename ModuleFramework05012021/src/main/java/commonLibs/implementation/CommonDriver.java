package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.Driver;

public class CommonDriver implements Driver{

	private WebDriver driver;
	private int pageLoadTimeOut;
	private int elementDetectionTimeOut;
	
	public CommonDriver(String browserType) {
		// TODO Auto-generated constructor stub
		browserType=browserType.trim();
		
		pageLoadTimeOut=20;
		elementDetectionTimeOut=10;
		
		if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Users/ravshukla/Documents/Selenium/libs/Mar18/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/ravshukla/Documents/Selenium/libs/Mar18/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:/Users/ravshukla/Documents/Selenium/libs/Edge/11Oct21/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser :" + browserType);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}	

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeOut(int pageLoadTimeOut) {
		this.pageLoadTimeOut = pageLoadTimeOut;
	}

	public void setElementDetectionTimeOut(int elementDetectionTimeOut) {
		this.elementDetectionTimeOut = elementDetectionTimeOut;
	}
	
/*
	@Override
	public String getToFirstURL(String url) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public String getTitle() throws Exception {
		
		return driver.getTitle();
	}

	@Override
	public String getCurrentURL() throws Exception {
	
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {
		
		return driver.getPageSource();
	}

	@Override
	public void navigateToFirstURL(String url) throws Exception {
	
		url=url.trim();
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeOut, TimeUnit.SECONDS);
		
		driver.get(url);
	}

	@Override
	public void navigateToURL(String url) throws Exception {
	//This method is used to pass control to another url. Hence does not require the pageLoadTimeOut or the elementDetectionTimeout to be set	
		url = url.trim();
		
		driver.navigate().to(url);
		
	}

	@Override
	public void navigateForward() throws Exception {
		
		driver.navigate().forward();
	}

	@Override
	public void navigateBackward() throws Exception {
		
		driver.navigate().back();
		
	}

	@Override
	public void refresh() throws Exception {
		
		driver.navigate().refresh();
	
	}

	@Override
	public void closeBrowser() throws Exception {
		
		if (driver !=null) {
			driver.close();
		}
		
	}

	@Override
	public void closeAllBrowser() throws Exception {
		
		if (driver !=null) {
			driver.quit();
		}
		
	}




}
