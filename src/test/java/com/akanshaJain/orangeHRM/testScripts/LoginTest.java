package com.akanshaJain.orangeHRM.testScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.pages.LoginPage;

public class LoginTest extends TestBase {
	SoftAssert softAssert = new SoftAssert();
	Logger log = Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void launchURL() {
		PreDefinedActions.start(ConstantPath.URL);
	}
	
	@Test
	public void loginTest() {
		log.info("STEP- Verify logo displayed on login page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displaying on login page");
		
		log.info("STEP- Verify login panel displayed on login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Logo is not displaying on login page");
		
		log.info("STEP- Enter username and password");
		loginPage.enterCreds("Admin", "meK1hXRL@9");
		softAssert.assertAll();
		
		log.info("STEP- Click on login button");
		loginPage.clickOnLoginButton();
		softAssert.assertAll();
	}
	
	@Test
	public void loginTestWithoutPassword() {
		log.info("STEP- Verify logo displayed on login page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displaying on login page");
		
		log.info("STEP- Verify login panel displayed on login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Logo is not displaying on login page");
		
		log.info("STEP- Enter username and password");
		loginPage.enterCreds("Admin", "");
		softAssert.assertAll();
		
		log.info("STEP- Click on login button");
		loginPage.clickOnLoginButton();
		softAssert.assertAll();
		
		log.info("STEP- Verify login failed message showing below the login button");
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