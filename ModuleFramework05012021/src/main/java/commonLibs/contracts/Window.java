package commonLibs.contracts;

import java.util.Set;

public interface Window {

	public void switchToAnyWindow(String windowHandle) throws Exception;
	
	public void switchToAnyWindow(int childWindowIndex) throws Exception;
	
	public String getWindowHandle() throws Exception;
	
	public Set<String> getWindowHandles() throws Exception;
}
