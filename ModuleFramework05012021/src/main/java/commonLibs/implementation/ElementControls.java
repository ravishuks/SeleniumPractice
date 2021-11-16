package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.CommonElement;

public class ElementControls implements CommonElement{

	@Override
	public void click(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.click();
		
	}

	@Override
	public String getText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getText();
	}

	@Override
	public String getAttribute(WebElement element, String attribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(attribute);
	}

	@Override
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(csspropertyName);
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	@Override
	public void setText(WebElement element, String texttoWrite) throws Exception {
		// TODO Auto-generated method stub
		element.sendKeys(texttoWrite);
		
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.clear();
	}

	@Override
	public void changeCheckboxStatus(WebElement element, boolean status) throws Exception {
		// TODO Auto-generated method stub
		//If check box is already checked and you want to uncheck it, and if the check box is checked and you want to uncheck it, then click on it 
		if ((element.isSelected() && !status) || (element.isSelected() && status)) {
			element.click();
		}
	}

}
