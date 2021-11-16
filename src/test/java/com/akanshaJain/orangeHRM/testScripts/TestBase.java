package com.akanshaJain.orangeHRM.testScripts;

import org.testng.asserts.SoftAssert;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.pages.LoginPage;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;

public class TestBase {
	SoftAssert softAssert = new SoftAssert();
	
	public SlideMenuPage setup() {
		System.out.println("STEP - Launch OrgHrm Application");
		PreDefinedActions.start(ConstantPath.URL);
		LoginPage loginPage = LoginPage.getObject();
		loginPage.enterCreds(ConstantPath.ADMIN, ConstantPath.PASSWORD);
		System.out.println("Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void teardown() {
		PreDefinedActions.closeBrowser();
	}
}