package com.akanshaJain.orangeHRM.testScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.DashboardLoginPage;

public class DashboardLoginTest extends TestBase {
	
	@BeforeClass
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void verifyWidgetsTest() {
		System.out.println("STEP- Dashboard page header title should be Dashboard");
		DashboardLoginPage dashboardLoginPage = new DashboardLoginPage();
		String expectedPageHeaderTitle = "Dashboard";
		String actualPageHeaderTitle = dashboardLoginPage.getPageHeaderTitle();
		softAssert.assertEquals(actualPageHeaderTitle, expectedPageHeaderTitle);
		
		System.out.println("STEP- Dashboard page title should be Dashboard");
		String expectedPageTitle = "Dashboard";
		String actualPageTitle = dashboardLoginPage.getPageTitle();
		softAssert.assertEquals(actualPageTitle, expectedPageTitle);
		
		System.out.println("STEP- Get all widgets count");
		int actualWidgetsCount = dashboardLoginPage.getTotalWidgets();
		softAssert.assertEquals(actualWidgetsCount, 12);
		
		System.out.println("STEP- Get all widgets title");
		ArrayList<String> expectedWidgetsTitleList = new ArrayList<String>();
		expectedWidgetsTitleList.add("Quick Access");
		expectedWidgetsTitleList.add("Buzz Latest Posts");
		expectedWidgetsTitleList.add("Employee Job Details");
		expectedWidgetsTitleList.add("My Actions");
		expectedWidgetsTitleList.add("Headcount by Location");
		expectedWidgetsTitleList.add("Employees on Leave Today");
		expectedWidgetsTitleList.add("Time At Work");
		expectedWidgetsTitleList.add("Performance Quick Feedback");
		expectedWidgetsTitleList.add("Annual basic payment by Locatio n");
		expectedWidgetsTitleList.add("Latest Documents");
		expectedWidgetsTitleList.add("Latest News");
		expectedWidgetsTitleList.add("Yearly New Hires");
		ArrayList<String> actualWidgetsTitleList = (ArrayList<String>) dashboardLoginPage.getAllWidgetText();
		System.out.println("All widgets text list- " + actualWidgetsTitleList);
		Assert.assertTrue(actualWidgetsTitleList.equals(expectedWidgetsTitleList));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			PreDefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}