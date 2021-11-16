package commonLibs.contracts;

public interface Driver {

	//public String getToFirstURL(String url) throws Exception;
	public String getTitle() throws Exception;
	public String getCurrentURL() throws Exception;
	public String getPageSource() throws Exception;
	public void navigateToFirstURL(String url) throws Exception; //this is the first method invoked using get method 
	public void navigateToURL(String url) throws Exception;
	public void navigateForward() throws Exception;
	public void navigateBackward() throws Exception;
	public void refresh() throws Exception;
	public void closeBrowser() throws Exception;
	public void closeAllBrowser() throws Exception;
	
}
