package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.JavaScript;

public class JavaScriptControl implements JavaScript{

	private WebDriver driver;
	
	public JavaScriptControl(WebDriver driver) {
		this.driver = driver;
	}
	
	private JavascriptExecutor getJSExecutor() {
		
		JavascriptExecutor jsEngine;
		jsEngine = (JavascriptExecutor) driver;
		
		return jsEngine;
	}
	
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
				
		getJSExecutor().executeScript(scriptToExecute);		
	
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		
		getJSExecutor().executeScript("window.scrollBy(%d,%d)", x, y);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return getJSExecutor().executeScript(scriptToExecute).toString();
	}

}
