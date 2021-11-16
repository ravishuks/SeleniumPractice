package com.mercurytravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;
import commonLibs.implementation.MouseControl;

public class HomePage extends SetupPage{

	@FindBy(linkText="International Holidays")
	private WebElement internationalHolidaysLink;
	
	@FindBy(linkText="Indian Holidays")
	private WebElement indianHolidaysLink;
	
	@FindBy(linkText="Luxury Rails")
	private WebElement luxuryRailsLink;
	
	@FindBy(linkText="Luxury Holidays")
	private WebElement luxuryHolidaysLink;
	
	@FindBy(linkText="Mice")
	private WebElement miceLink;
	
	@FindBy(linkText="Flights")
	private WebElement flightsLink;
	
	@FindBy(linkText="Hotels")
	private WebElement hotelsLink;
	
	@FindBy(linkText="Foreign Exchange")
	private WebElement foreignExchangeLink;
	
	@FindBy(linkText="Insurance")
	private WebElement insuranceLink;
	
	@FindBy(linkText="Customer Login")
	private WebElement customerLoginLink;
	
	@FindBy(linkText="User Login")
	private WebElement usrLogin;
	
	@FindBy(id="sign_user_email")
	private WebElement usrEmailId;
	
	@FindBy(id="sign_user_password")
	private WebElement usrPassword;
	
	@FindBy(xpath="//div[@id=\"modalLogin\"]//form[@class=\"form-signin\"]//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"]")
	private WebElement usrLoginButton;
	
	@FindBy(linkText="Register")
	private WebElement userRegisterLink;
	
	@FindBy(partialLinkText="Welcome,")
	private WebElement welcomeText;
	
	@FindBy(linkText="Log Out")
	private WebElement userLogOutLink;
	
	public HomePage(WebDriver driver) {
	
		super(driver);
		PageFactory.initElements(driver, this);
			
	}	
	
	public void userLogin(String username, String userpassword) throws Exception{
	
		mouseCtrlClass.moveToElement(customerLoginLink);
		
		mouseCtrlClass.moveToElement(usrLogin);
		
		elementClass.click(usrLogin);
		
		elementClass.setText(usrEmailId, username);
		
		elementClass.setText(usrPassword, userpassword);
		
		elementClass.click(usrLoginButton);
	}
	
	public String getWelcomeText() throws Exception{
		return elementClass.getText(welcomeText);
	}
	
	public String getLoginLinkText() throws Exception{
		return elementClass.getText(customerLoginLink);
	}
	
	public void logOff() throws Exception{
		
		mouseCtrlClass.moveToElement(welcomeText);
		elementClass.click(userLogOutLink);
	}
	
}
