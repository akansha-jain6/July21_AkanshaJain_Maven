package com.akanshaJain.orangeHRM.testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.pages.UserMenu_EmployeeListPage;

public class UserMenu_EmployeeListPaginationCountTest extends TestBase {
	
	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@Test
	public void verifyPaginationcount() {
		SlideMenuPage slideMenuPage = new SlideMenuPage();
		slideMenuPage.navigateTo("PIM->Employee List");
		UserMenu_EmployeeListPage userMenuEmployeeListPage = new UserMenu_EmployeeListPage();
		System.out.println("STEP- Verify default pagination count");
		UserMenu_EmployeeListPage actualDefaultPaginationCount = userMenuEmployeeListPage.getDefaultRowCountAtEndOfPage();
		softAssert.assertEquals(actualDefaultPaginationCount, 50);
		
		System.out.println("STEP- Verify no. of rows on page");
		int actualNoOfRows = userMenuEmployeeListPage.getNoOfRowsAsPerDefaultCount();
		System.out.println("No. of rows on page are- " + actualNoOfRows);
		softAssert.assertEquals(actualNoOfRows, 50);
	}
	
	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}