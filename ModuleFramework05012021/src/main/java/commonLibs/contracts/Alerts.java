package commonLibs.contracts;

public interface Alerts {

	public void acceptAlert() throws Exception;
	public void rejectAlert() throws Exception;
	public String getMessageOfAlert() throws Exception;
	public boolean isAlertPresent(int timeoutInSeconds) throws Exception;
	
}
