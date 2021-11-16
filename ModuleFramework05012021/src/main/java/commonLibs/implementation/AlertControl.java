package commonLibs.implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import commonLibs.contracts.Alerts;

public class AlertControl implements Alerts{

	private WebDriver driver;
	
	//create a constructor to pass the driver instance into the AlertControl class using the class level argument (aka this)
	//Basically, we will get the driver value from the getDriver() method of CommonDriver class and pass it into the AlertControl class
	public AlertControl (WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	//private method created to replace the redundant call of switching to alert in other methods
	//Alert alert = driver.switchTo().alert();
	private Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		
		return alert;
	}
	
	@Override
	public void acceptAlert() throws Exception {
		// TODO Auto-generated method stub
		
		//need a browser instance to move from browser to the alert. For this, we need to pass an instance of webdriver instance using the constructor
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		
		getAlert().accept();
		
	}

	@Override
	public void rejectAlert() throws Exception {
		// TODO Auto-generated method stub
	
		getAlert().dismiss();
	}

	@Override
	public String getMessageOfAlert() throws Exception {
		// TODO Auto-generated method stub
		
		return getAlert().getText();
	}

	@Override
	public boolean isAlertPresent(int timeoutInSeconds) throws Exception {
		// TODO Auto-generated method stub
		
		return false;
	}
	

}
