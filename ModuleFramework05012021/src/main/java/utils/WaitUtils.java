package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriver driver;

	public WaitUtils (WebDriver driver) {
		this.driver= driver;
	}
	
	private WebDriverWait getWait(int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait;
	}
	
	public void waitTillElementIsPresent(WebElement element, int timeoutInSeconds) {
		
		getWait(timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillAlertIsPresent(int timeoutInSeconds) {
	
		getWait(timeoutInSeconds).until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitTillElementIsClickable(WebElement element, int timeoutInSeconds) {
	 	
		getWait(timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForSeconds(int timeoutInSeconds) throws Exception{
		Thread.sleep(timeoutInSeconds*1000);
	}
}
