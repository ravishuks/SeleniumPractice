package commonLibs.implementation;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import commonLibs.contracts.Window;

public class WindowControl implements Window{

	private WebDriver driver;
	
	public WindowControl(WebDriver driver) {
		this.driver=driver;
	}
	
	@Override
	public void switchToAnyWindow(String windowHandle) throws Exception {
		driver.switchTo().window(windowHandle);
		
	}

	//switch to a specific child window(1st, 2nd etc) by calling an array of all the window handles (getWindowHandles()
	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		
		String childWindow = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		driver.switchTo().window(childWindow);
	}

	@Override
	public String getWindowHandle() throws Exception {
		
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		
		return driver.getWindowHandles();
	}
	

}
