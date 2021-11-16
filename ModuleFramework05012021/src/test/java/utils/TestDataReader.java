package utils;

import java.util.Properties;

import org.testng.annotations.DataProvider;

public class TestDataReader {

	private ExcelDriverUtils excelDriver;
	private String inputFileName;
	private String sheetName;
	private Properties configProperties;
	private String configFileName;
	
	public TestDataReader() throws Exception {
		String currentProjectDirectory = System.getProperty("user.dir");
		configFileName = currentProjectDirectory + "/config/config.properties";
		configProperties = ReadConfigFileUtils.readProperties(configFileName);
		
		//Retrieve the excel workbook name from config.properties file
		inputFileName= currentProjectDirectory + "/testdata/"+ configProperties.getProperty("inputFileName");
		
		//Retrieve the sheet name from the config.properties 
		sheetName= configProperties.getProperty("inputSheetName");
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		
		Object[][] data;
		
		excelDriver = new ExcelDriverUtils();
		
		excelDriver.openExcelWorkbook(inputFileName);
		
		int numberOfRows = excelDriver.getRowCountOfSheet(sheetName);
		
		int numberOfCells = excelDriver.getCellCount(sheetName,1);
		
		
		data = new Object[numberOfRows+1][numberOfCells];
		//The loop will start from row 1 and cell 1 of the sheet, and would be inserted into the 2 dimensional array starting from [0][0] 
		for (int iRow=1; iRow <=numberOfRows+1;iRow++) {
			
			for (int iCell=1;iCell<=numberOfCells;iCell++) {
			
				data[iRow-1][iCell-1] = excelDriver.getCellData(sheetName, iRow, iCell);
			}
		}
		
		return data;
		
	}
	
}
