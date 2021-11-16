package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriverUtils {

	//to read from a file
	private InputStream fileReader;
	
	//to write into a file
	private OutputStream fileWriter;
	
	//creating a workbook
	private Workbook excelWorkbook;
	
	//default name for a file
	private String excelFilename;
	
	//filename - complete file path including file name
	public void createExcelWorkbook( String filename) throws Exception{
		
		filename = filename.trim();
		
		//putting an empty file check
		if (filename.isEmpty()) {
			throw new Exception("File name is empty");
		}
		
		File file = new File(filename);
		
		if (file.exists()) {
			throw new Exception("File already exists");
		}
		
		if (filename.endsWith("xlsx")) {
			excelWorkbook = new XSSFWorkbook();
		} else if (filename.endsWith("xls")) {
			excelWorkbook = new HSSFWorkbook();
		} else {
			throw new Exception ("Invalid file extension...");
		}
		
		//Creating an output stream with mentioned filename to be written in the workbook
		fileWriter = new FileOutputStream(filename);
		
		//Writing to a workbook
		excelWorkbook.write(fileWriter);
		
		//Closing the newly created file
		excelWorkbook.close();
	}
	
	//Method to open an existing excel workbook by passing the full path and file name
	public void openExcelWorkbook(String filename) throws Exception{
		
		filename = filename.trim();
		
		if (filename.isEmpty()) {
			throw new Exception("File name not specified...");
		}
		
		File file = new File(filename);
		
		if (!file.exists()) {
			throw new Exception("File does not exist.");
		}
		
		//Reading data from an excel sheet
		fileReader = new FileInputStream(filename);
		
		//Assigning sheet name to a global private variable
		excelFilename = filename;
		
		//Converting raw data read from excel into excel workbook format
		excelWorkbook = WorkbookFactory.create(fileReader);
	}
	
	//After writing data into file using above method, we need to save the data in the excel workbook
	public void save() throws Exception{
		//what ever data is there in the fileoutput stream, we'll write it into the filewriter
		fileWriter = new FileOutputStream(excelFilename);
		
		//Afterwards, we'll write it into workbook and close it
		excelWorkbook.write(fileWriter);
		
		fileWriter.close();
	}
	
	//Method used to save as a new file name
	public void saveAs(String newFilename) throws Exception{
		
		newFilename = newFilename.trim();
		
		if (newFilename.isEmpty()) {
			throw new Exception("File name is empty.");
		}
		
		File file = new File(newFilename);
		
		if (file.exists()) {
			throw new Exception("File already exists...");
		}
		
		fileWriter = new FileOutputStream(newFilename);
		
		excelWorkbook.write(fileWriter);
		
		fileWriter.close();
	}
	
	//Closing the excel workbook and file writer
	public void close() throws Exception{
		
		excelWorkbook.close();
		fileWriter.close();
	}
	
	//Method to create a new sheet in an existing workbook
	//Check if the sheet exists is the excel workbook with the same name (oSheet !=null). If null, then go ahead and create a new sheet in the excel workbook 
	public void createSheet(String sSheetName) throws Exception{
		
		sSheetName = sSheetName.trim();
		
		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name is empty");
		}
		
		Sheet oSheet;
		
		oSheet = excelWorkbook.getSheet(sSheetName);
		
		if (oSheet != null) {
			throw new Exception("Sheet already exists...");
		}
		
		excelWorkbook.createSheet(sSheetName);
		
	}
	
	//In a sheet, get the no. of rows in the sheet
	public int getRowCountOfSheet(String sSheetName) throws Exception{
		
		sSheetName = sSheetName.trim();
		
		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified...");
		}
		
		Sheet oSheet;
		
		oSheet = excelWorkbook.getSheet(sSheetName);
		
		if (oSheet == null) {
			throw new Exception("Sheet does not exist.");
		}
		
		return oSheet.getLastRowNum();
	}
	
	//Method to get the no. of cells in a row of a sheet in an excel work book	
	//Retrieves the last cell count number in row
	public int getCellCount(String sSheetName, int iRow) throws Exception{
		
		sSheetName = sSheetName.trim();
		
		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified...");
		}
		
		Sheet oSheet;
		
		oSheet = excelWorkbook.getSheet(sSheetName);
		
		if (oSheet == null) {
			throw new Exception("Sheet does not exist.");			
		}
		
		if (iRow < 1) {
			throw new Exception("Row count always start from 1");
		}
		
		Row oRow;
		
		oRow = oSheet.getRow(iRow-1);
		
		if (oRow==null) {
			return 0;
		} else {
			return oRow.getLastCellNum();
		}
	}
	
	public String getCellData(String sSheetName, int iRow, int iCell) throws Exception{
		
		sSheetName = sSheetName.trim();
		
		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified...");
		}
		
		Sheet oSheet;
		
		oSheet = excelWorkbook.getSheet(sSheetName);
	
		if (oSheet == null) {
			throw new Exception("Sheet does not exist.");
		}
		
		if (iRow < 1 || iCell < 1) {
			throw new Exception("Row or Cell count should always start from 1");
		}
		
		Row oRow;
		
		oRow = oSheet.getRow(iRow-1);
		
		if (oRow == null) {
			return "";
		} 
		
		Cell oCell;
		
		oCell = oRow.getCell(iCell-1);
				
		/*
		if (oCell == null) {
			return "";
		} else {
			return oCell.getStringCellValue();
		} 
		*/
		String strCellValue="";
		
		if (oCell == null) {
			strCellValue= "";
		} else if (oCell.getCellType()== CellType.STRING){
			strCellValue= oCell.getStringCellValue();
			
		} else if (oCell.getCellType()==CellType.NUMERIC) {
			 strCellValue = NumberToTextConverter.toText(oCell.getNumericCellValue());
		} 
		
		return strCellValue;
		
	}
	
	//Method to write data into a specific cell
	public void setCellData(String sSheetName, int iRow, int iCell, String sSetValue) throws Exception{
		
		sSheetName = sSheetName.trim();
		
		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified.");
		}
		
		Sheet oSheet;
		
		oSheet = excelWorkbook.getSheet(sSheetName);
		
		if (oSheet == null) {
			throw new Exception("Sheet does not exist...");
		}
		
		if (iRow <1 || iCell <1) {
			throw new Exception("The row and cell should start from 1");
		}
		
		Row oRow;
		
		oRow = oSheet.getRow(iRow-1);
		
		if (oRow ==null) {
			oSheet.createRow(iRow-1);
			oRow = oSheet.getRow(iRow-1);
		}
		
		Cell oCell;
		
		oCell = oRow.getCell(iCell-1);
		
		if (oCell ==null) {
			oRow.createCell(iCell-1);
			oCell = oRow.getCell(iCell-1);
		}
		
		oCell.setCellValue(sSetValue);
	}
}
