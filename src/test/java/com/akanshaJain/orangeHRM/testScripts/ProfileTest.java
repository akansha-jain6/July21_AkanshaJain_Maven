package com.akanshaJain.orangeHRM.testScripts;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.ProfilePage;

public class ProfileTest extends TestBase {
	Logger log = Logger.getLogger(ProfileTest.class);
	
	@BeforeClass
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void verifyUserProfileDropdownOptions() {
		log.info("STEP- Click on arrow icon on profile");
		ProfilePage profilePage = ProfilePage.getObject();
		profilePage.clickOnUserArrowDropdown();
		softAssert.assertAll();
		
		log.info("STEP- Get list of user profile dropdown options");
		ArrayList<String> expectedUserDropdownList = new ArrayList<String>();
		expectedUserDropdownList.add("About");
		expectedUserDropdownList.add("Change Password");
		expectedUserDropdownList.add("Logout");
		ArrayList<String> actualUserDropdownList = (ArrayList<String>) profilePage.getListOfUserDropdownOptions();
		log.info("User dropdown options are- " + actualUserDropdownList);
		softAssert.assertEquals(actualUserDropdownList, expectedUserDropdownList);
		
		log.info("STEP- Get count of user profile dropdown options");
		int actualUserDropdownOptionsCount = profilePage.getTotalAvailableUserDropdownOptions();
		log.info("Total user dropdown options are- " + actualUserDropdownOptionsCount);
		softAssert.assertEquals(actualUserDropdownOptionsCount, 3);
		
		log.info("STEP- Click on About option");
		profilePage.clickOnAbout();
		softAssert.assertAll();
		
		log.info("STEP- Get about pop-up details");
		int expectedCompanydDetailsCount = 5;
		ArrayList<String> actualCompanyDetailsOnAboutPopUp = (ArrayList<String>) profilePage.getCompanyDetailsFromAboutPopUp();
		log.info("About pop-up details- " + actualCompanyDetailsOnAboutPopUp);
		int actualCompanydDetailsCount = actualCompanyDetailsOnAboutPopUp.size();
		softAssert.assertTrue(actualCompanydDetailsCount == expectedCompanydDetailsCount);
		
		log.info("STEP- Click on OK button on About pop-up");
		profilePage.clickOkOnAboutPopUp();
		softAssert.assertAll();
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