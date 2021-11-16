package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.MouseOperation;

public class MouseControl implements MouseOperation{

	private WebDriver driver;
	
	public MouseControl(WebDriver driver) {
		this.driver = driver;
	}
	
	private Actions getAction(WebDriver driver) {
		Actions action = new Actions (driver);
		return action;
	}
	
	@Override
	public void dragAndDrop(WebElement element1, WebElement element2) throws Exception {
		getAction(driver).dragAndDrop(element1, element2).build().perform();
		
	}

	@Override
	public void rightClick(WebElement element) throws Exception {
		getAction(driver).contextClick(element).build().perform();
		
	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		getAction(driver).doubleClick(element).build().perform();
		
	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		getAction(driver).moveToElement(element).click().build().perform();
		
	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		getAction(driver).moveToElement(element).build().perform();
		
	}

}
