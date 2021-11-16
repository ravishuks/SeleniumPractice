package com.mercurytravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.JavaScriptControl;
import commonLibs.implementation.MouseControl;
import commonLibs.implementation.WindowControl;

public class SetupPage {

	public ElementControls elementClass;
	
	public DropdownControl drpListClass;
	
	public MouseControl mouseCtrlClass;
	
	public AlertControl alertCtrlClass;
	
	public FrameControl frameCtrlClass;
	
	public JavaScriptControl javascriptCtrlClass;
	
	public WindowControl windowCtrlClass;
	
	public SetupPage(WebDriver driver) {
		
		elementClass = new ElementControls();
		drpListClass = new DropdownControl();
		mouseCtrlClass = new MouseControl(driver);
		alertCtrlClass = new AlertControl(driver);
		frameCtrlClass = new FrameControl(driver);
	}
}
