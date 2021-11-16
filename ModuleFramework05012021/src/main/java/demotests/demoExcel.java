package demotests;

import org.apache.poi.ss.usermodel.DataFormatter;

import utils.ExcelDriverUtils;

public class demoExcel {

	private static String currentProjectDirectory;
	private static String excelFilename;
	private static ExcelDriverUtils excelDriver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		currentProjectDirectory= System.getProperty("user.dir");
		System.out.println(currentProjectDirectory);
		excelFilename = currentProjectDirectory+"/testdata/testdata.xlsx";
		System.out.println(excelFilename);
		
		excelDriver = new ExcelDriverUtils();
		
		excelDriver.openExcelWorkbook(excelFilename);
		
		int numberOfRows, numberOfCells;
		
		numberOfRows= excelDriver.getRowCountOfSheet("Holiday Test Data");
		
		numberOfCells = excelDriver.getCellCount("Holiday Test Data",1);
		
		//System.out.println(excelDriver.getCellData("Holiday Test Data", 1, 2));
		
		//excelDriver.close();
		
		Object[][] data;
		DataFormatter formatter = new DataFormatter();
		
		data = new Object[numberOfRows+1][numberOfCells];
		//The loop will start from row 1 and cell 1 of the sheet, and would be inserted into the 2 dimensional array starting from [0][0] 
		for (int iRow=1; iRow <=numberOfRows+1;iRow++) {
			
			for (int iCell=1;iCell<=numberOfCells;iCell++) {
			
				data[iRow-1][iCell-1] = excelDriver.getCellData("Holiday Test Data", iRow, iCell);
				
				System.out.println(data[iRow-1][iCell-1]);
			}
		}
		
		
		
	}

}
