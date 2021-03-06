package com.akanshaJain.orangeHRM.testScripts;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.pages.UserMenu_EmployeeListPage;

public class UserMenu_EmployeeListPaginationCountTest extends TestBase {
	Logger log = Logger.getLogger(UserMenu_EmployeeListPaginationCountTest.class);
	
	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@Test
	public void verifyPaginationcount() {
		SlideMenuPage slideMenuPage = SlideMenuPage.getObject();
		slideMenuPage.navigateTo("PIM->Employee List");
		UserMenu_EmployeeListPage userMenuEmployeeListPage = UserMenu_EmployeeListPage.getObject();
		log.info("STEP- Verify default pagination count");
		UserMenu_EmployeeListPage actualDefaultPaginationCount = userMenuEmployeeListPage.getDefaultRowCountAtEndOfPage();
		softAssert.assertEquals(actualDefaultPaginationCount, 50);
		
		log.info("STEP- Verify no. of rows on page");
		int actualNoOfRows = userMenuEmployeeListPage.getNoOfRowsAsPerDefaultCount();
		log.info("No. of rows on page are- " + actualNoOfRows);
		softAssert.assertEquals(actualNoOfRows, 50);
	}
	
	@AfterMethod
	public void takeScreenshotAndTearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			PreDefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
		super.teardown();
	}
}