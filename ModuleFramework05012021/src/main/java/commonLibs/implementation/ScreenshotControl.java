package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.Screenshot;

public class ScreenshotControl implements Screenshot{

	private WebDriver driver;
	
	public ScreenshotControl(WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public String captureAndSaveScreenshot(String Filename) throws Exception {
		
		Filename = Filename.trim();
		
		File imgFile, tmpFile;
		imgFile = new File(Filename);
		
		if (imgFile.exists()) {
			throw new Exception("Duplicate File");
		}
		
		//if the file does not exist, we will take the screenshot by calling the TakesScreenshot interface
		TakesScreenshot camera;
		
		camera = (TakesScreenshot) driver;
		
		tmpFile= camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
		//the absolute path of the screenshot is required as we would need the path to reference the screenshot from the html reports
		return imgFile.getAbsolutePath();
	}

}
