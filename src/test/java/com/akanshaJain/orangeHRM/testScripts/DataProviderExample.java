package com.akanshaJain.orangeHRM.testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.ExcelOperation;

public class DataProviderExample {

	@Test(dataProvider = "read_from_excel")
	public void m1(String fname, String lname, String env) {
		System.out.println(fname.trim());
		System.out.println(lname.trim());
		System.out.println(env.trim());
	}
	
	@DataProvider(name= "read_from_excel")
	public Object[][] getDataFromExcel() {
		return ExcelOperation.readExcelFile(ConstantPath.TESTDATA + ConstantPath.EXCEL_FILENAME, ConstantPath.SHEET_NAME);
	}
}