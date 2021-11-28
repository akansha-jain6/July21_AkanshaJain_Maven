package com.akanshaJain.orangeHRM.testScripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.asserts.SoftAssert;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.pages.LoginPage;
import com.akanshaJain.orangeHRM.pages.SlideMenuPage;
import com.akanshaJain.orangeHRM.util.DateOperations;

public class TestBase {
	SoftAssert softAssert = new SoftAssert();
	Logger log = Logger.getLogger(TestBase.class);
	
	static {
		System.setProperty("current.date.time", DateOperations.getTimeStamp());
		PropertyConfigurator.configure(ConstantPath.LOG4J_FILE_PATH);
	}
	
	public SlideMenuPage setup() {
		log.info("STEP - Launch OrgHrm Application");
		PreDefinedActions.start(ConstantPath.URL);
		LoginPage loginPage = LoginPage.getObject();
		loginPage.enterCreds(ConstantPath.ADMIN, ConstantPath.PASSWORD);
		log.info("Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void teardown() {
		PreDefinedActions.closeBrowser();
	}
}