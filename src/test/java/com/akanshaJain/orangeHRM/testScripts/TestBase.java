package com.akanshaJain.orangeHRM.testScripts;

import org.testng.asserts.SoftAssert;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.LoginPage;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;

public class TestBase {
	SoftAssert softAssert = new SoftAssert();
	
	public SlideMenuPage setup() {
		System.out.println("STEP - Launch OrgHrm Application");
		PreDefinedActions.start("https://automationaj06-trials72.orangehrmlive.com/");
		LoginPage loginPage = LoginPage.getObject();
		loginPage.enterCreds("Admin", "meK1hXRL@9");
		System.out.println("Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void teardown() {
		PreDefinedActions.closeBrowser();
	}
}