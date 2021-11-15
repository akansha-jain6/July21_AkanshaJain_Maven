package com.akanshaJain.orangeHRM.testScripts;

import java.util.ArrayList;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.pages.ProfilePage;

public class ProfileTest extends TestBase {

	@BeforeClass
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void verifyUserProfileDropdownOptions() {
		System.out.println("STEP- Click on arrow icon on profile");
		ProfilePage profilePage = new ProfilePage();
		profilePage.clickOnUserArrowDropdown();
		softAssert.assertAll();
		
		System.out.println("STEP- Get list of user profile dropdown options");
		ArrayList<String> expectedUserDropdownList = new ArrayList<String>();
		expectedUserDropdownList.add("About");
		expectedUserDropdownList.add("Change Password");
		expectedUserDropdownList.add("Logout");
		ArrayList<String> actualUserDropdownList = (ArrayList<String>) profilePage.getListOfUserDropdownOptions();
		System.out.println("User dropdown options are- " + actualUserDropdownList);
		softAssert.assertEquals(actualUserDropdownList, expectedUserDropdownList);
		
		System.out.println("STEP- Get count of user profile dropdown options");
		int actualUserDropdownOptionsCount = profilePage.getTotalAvailableUserDropdownOptions();
		System.out.println("Total user dropdown options are- " + actualUserDropdownOptionsCount);
		softAssert.assertEquals(actualUserDropdownOptionsCount, 3);
		
		System.out.println("STEP- Click on About option");
		profilePage.clickOnAbout();
		softAssert.assertAll();
		
		System.out.println("STEP- Get about pop-up details");
		int expectedCompanydDetailsCount = 5;
		ArrayList<String> actualCompanyDetailsOnAboutPopUp = (ArrayList<String>) profilePage.getCompanyDetailsFromAboutPopUp();
		System.out.println("About pop-up details- " + actualCompanyDetailsOnAboutPopUp);
		int actualCompanydDetailsCount = actualCompanyDetailsOnAboutPopUp.size();
		softAssert.assertTrue(actualCompanydDetailsCount == expectedCompanydDetailsCount);
		
		System.out.println("STEP- Click on OK button on About pop-up");
		profilePage.clickOkOnAboutPopUp();
		softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}