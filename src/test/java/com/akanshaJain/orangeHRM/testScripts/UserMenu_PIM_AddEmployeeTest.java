package com.akanshaJain.orangeHRM.testScripts;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.pages.UserMenu_PIM_AddEmployeePage;

public class UserMenu_PIM_AddEmployeeTest extends TestBase {
	Logger log = Logger.getLogger(UserMenu_PIM_AddEmployeeTest.class);
	
	@BeforeMethod
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void addEmployeeTest() {
		SlideMenuPage slideMenuPage = SlideMenuPage.getObject();
		slideMenuPage.navigateTo("PIM->Add Employee");
		UserMenu_PIM_AddEmployeePage userMenu_PIM_AddEmployeePage = UserMenu_PIM_AddEmployeePage.getObject();
		log.info("STEP- Add first name");
		userMenu_PIM_AddEmployeePage.setEmployeeFirstName("Akansha");
		log.info("STEP- Add middle name");
		userMenu_PIM_AddEmployeePage.setEmployeeMiddleName("K");
		log.info("STEP- Add last name");
		userMenu_PIM_AddEmployeePage.setEmployeeLastName("Jain");
		log.info("STEP- Add employee location");
		userMenu_PIM_AddEmployeePage.setEmployeeLocation("Indian Development Center");
		log.info("STEP- Click on Next button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Next");
		log.info("STEP- Add hobbies");
		userMenu_PIM_AddEmployeePage.setEmployeeHobbies("Painting");
		log.info("STEP- Click on Next button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Next");
		log.info("STEP- Add work shift");
		userMenu_PIM_AddEmployeePage.setEmployeeWorkShift("General");
		log.info("STEP- Add effecive from date");
		userMenu_PIM_AddEmployeePage.setEmployeeEffectiveFromDate("6");
		log.info("STEP- Add region");
		userMenu_PIM_AddEmployeePage.setEmployeeRegion("Region-1");
		log.info("STEP- Add FTE");
		userMenu_PIM_AddEmployeePage.setEmployeeFTE("0.5");
		log.info("STEP- Add temporary department");
		userMenu_PIM_AddEmployeePage.setEmployeeTempDept("Sub unit-1");
		log.info("STEP- Click on Save button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Save");
		log.info("STEP- Get success message");
		String expectedSuccessMessage = "Successfully Saved";
		String actualSuccessMessage = userMenu_PIM_AddEmployeePage.verifySuccessMessage();
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
	}
	
	@AfterMethod
	public void takeScreenshotAndTearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			PreDefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
		super.teardown();
	}
}