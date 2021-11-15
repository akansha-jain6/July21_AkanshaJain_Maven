package com.akanshaJain.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperation {

	@Test
	public static Object[][] readExcelFile(String filePath, String sheetName) {
		File file = new File(filePath); // File path
		FileInputStream input;
		Workbook workBook = null;
		try {
			input = new FileInputStream(file);
			workBook = new XSSFWorkbook(input); // IO Exception
		} catch (IOException e) {
			e.printStackTrace();
		} // File Not Found Exception
		/* 2003 -> XLS (HSSF) 
		   2007 -> XLSX (XSSF) */
		// Interface 	  = Class
		//workBook = new HSSFWorkbook();
		Sheet sheet = workBook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow+1][lastCell];
		System.out.println("Total rows- " + (lastRow+1));
		System.out.println("Total columns- " + lastCell);
		for( int rows=0; rows<=lastRow; rows++) {
			for(int columns=0; columns<lastCell; columns++) {
				Cell cell = sheet.getRow(rows).getCell(columns);
				if(cell.getCellType()==CellType.NUMERIC)
					data[rows][columns] = String.valueOf(cell.getNumericCellValue());
				else if(cell.getCellType()==CellType.STRING)
					data[rows][columns] = String.valueOf(cell.getStringCellValue());
				else if(cell.getCellType()==CellType.BOOLEAN)
					data[rows][columns] = String.valueOf(cell.getBooleanCellValue());
				//System.out.print(sheet.getRow(rows).getCell(columns).getStringCellValue() + "\t");
			}
			System.out.println();
		}
		return data;
	}
}