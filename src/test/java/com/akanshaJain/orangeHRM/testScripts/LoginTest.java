package com.akanshaJain.orangeHRM.testScripts;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.pages.LoginPage;

public class LoginTest extends TestBase {
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void launchURL() {
		PreDefinedActions.start("https://automationaj06-trials72.orangehrmlive.com/auth/login");
	}
	
	@Test
	public void loginTest() {
		System.out.println("STEP- Verify logo displayed on login page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displaying on login page");
		
		System.out.println("STEP- Verify login panel displayed on login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Logo is not displaying on login page");
		
		System.out.println("STEP- Enter username and password");
		loginPage.enterCreds("Admin", "meK1hXRL@9");
		softAssert.assertAll();
		
		System.out.println("STEP- Click on login button");
		loginPage.clickOnLoginButton();
		softAssert.assertAll();
	}
	
	@Test
	public void loginTestWithoutPassword() {
		System.out.println("STEP- Verify logo displayed on login page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displaying on login page");
		
		System.out.println("STEP- Verify login panel displayed on login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Logo is not displaying on login page");
		
		System.out.println("STEP- Enter username and password");
		loginPage.enterCreds("Admin", "");
		softAssert.assertAll();
		
		System.out.println("STEP- Click on login button");
		loginPage.clickOnLoginButton();
		softAssert.assertAll();
		
		System.out.println("STEP- Verify login failed message showing below the login button");
		String expectedLoginFailedMsg = "Password cannot be empty";
		String actualLoginFailedMsg = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualLoginFailedMsg, expectedLoginFailedMsg);
	}
	
	@AfterMethod
	public void takeScreenshotAndTearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			PreDefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
		PreDefinedActions.closeBrowser();
	}
}