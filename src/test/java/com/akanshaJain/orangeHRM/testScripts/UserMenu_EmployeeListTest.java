package com.akanshaJain.orangeHRM.testScripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.pages.UserMenu_EmployeeListPage;

public class UserMenu_EmployeeListTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void verifyAddedEmployeeInList() {
		SlideMenuPage slideMenuPage = SlideMenuPage.getObject();
		slideMenuPage.navigateTo("PIM->Employee List");
		UserMenu_EmployeeListPage userMenu_EmployeeList = UserMenu_EmployeeListPage.getObject();
		System.out.println("STEP- Enter employee name and search it");
		userMenu_EmployeeList.findByUserName("Akansha K Jain");
		System.out.println("STEP- Get employee name same as searched name in searched list");
		String expectedEmployeeName = "Akansha K Jain";
		String actualEmployeeName = userMenu_EmployeeList.getSearchedEmployeeName();
		System.out.println("Employee name in searched list- " + actualEmployeeName);
		softAssert.assertEquals(actualEmployeeName, expectedEmployeeName);
	}
	
	@AfterMethod
	public void takeScreenshotAndTearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			PreDefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
		super.teardown();
	}
}