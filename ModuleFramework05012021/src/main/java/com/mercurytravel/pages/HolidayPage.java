package com.mercurytravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolidayPage {

	@FindBy (id="holidays")
	private WebElement holiday;
	
	@FindBy(id="holiday_category_id")
	private WebElement destination;
	
	@FindBy(id="dphh1")
	private WebElement startDateOfHoliday;
	
	@FindBy(id="duration_d")
	private WebElement durationOfHoliday;
	
	@FindBy(id="themes")
	private WebElement typeOfHoliday;
	
	@FindBy(xpath="//form[@id=\"int_auto_comp_param\"]//div[@class=\"searchpanel\"]//button[@class=\"btn btn-primary btn-search2\"]")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class=\"hotelResultsCntr2 col-md-12 margintop15 details\"]//span[@id=\"totalcount\"]")
	private WebElement searchResultCount;
	
	private WebElement validateText;
	
	public HolidayPage (WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver, this);
	}
	/*
	public void SearchHolidayPackages(String destination, String holidaydate, String duration, String typeholiday) {
		if 
	}
	*/
}
