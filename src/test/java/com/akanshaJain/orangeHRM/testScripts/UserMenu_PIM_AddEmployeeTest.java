package com.akanshaJain.orangeHRM.testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.pages.UserMenu_PIM_AddEmployeePage;

public class UserMenu_PIM_AddEmployeeTest extends TestBase {
	
	@BeforeMethod
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void addEmployeeTest() {
		SlideMenuPage slideMenuPage = new SlideMenuPage();
		slideMenuPage.navigateTo("PIM->Add Employee");
		UserMenu_PIM_AddEmployeePage userMenu_PIM_AddEmployeePage = new UserMenu_PIM_AddEmployeePage();
		System.out.println("STEP- Add first name");
		userMenu_PIM_AddEmployeePage.setEmployeeFirstName("Akansha");
		System.out.println("STEP- Add middle name");
		userMenu_PIM_AddEmployeePage.setEmployeeMiddleName("K");
		System.out.println("STEP- Add last name");
		userMenu_PIM_AddEmployeePage.setEmployeeLastName("Jain");
		System.out.println("STEP- Add employee location");
		userMenu_PIM_AddEmployeePage.setEmployeeLocation("Indian Development Center");
		System.out.println("STEP- Click on Next button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Next");
		System.out.println("STEP- Add hobbies");
		userMenu_PIM_AddEmployeePage.setEmployeeHobbies("Painting");
		System.out.println("STEP- Click on Next button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Next");
		System.out.println("STEP- Add work shift");
		userMenu_PIM_AddEmployeePage.setEmployeeWorkShift("General");
		System.out.println("STEP- Add effecive from date");
		userMenu_PIM_AddEmployeePage.setEmployeeEffectiveFromDate("6");
		System.out.println("STEP- Add region");
		userMenu_PIM_AddEmployeePage.setEmployeeRegion("Region-1");
		System.out.println("STEP- Add FTE");
		userMenu_PIM_AddEmployeePage.setEmployeeFTE("0.5");
		System.out.println("STEP- Add temporary department");
		userMenu_PIM_AddEmployeePage.setEmployeeTempDept("Sub unit-1");
		System.out.println("STEP- Click on Save button");
		userMenu_PIM_AddEmployeePage.clickOnButton("Save");
		System.out.println("STEP- Get success message");
		String expectedSuccessMessage = "Successfully Saved";
		String actualSuccessMessage = userMenu_PIM_AddEmployeePage.verifySuccessMessage();
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
	}
	
	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}