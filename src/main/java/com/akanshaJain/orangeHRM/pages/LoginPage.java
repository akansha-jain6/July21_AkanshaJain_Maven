package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.PropertiesOperation;

public class LoginPage extends PreDefinedActions{
	private PropertiesOperation propOperation;
	static  private LoginPage loginPage;
	
	private LoginPage() {
		try {
			propOperation = new PropertiesOperation(ConstantPath.LOGINPAGELOCATOR_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LoginPage getObject() {
		if(loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}
	
	public boolean isLogoDisplayed() {
		String logoLocator = propOperation.getValue("logo");
		WebElement element = getElement(logoLocator, false);
		return isElementDisplayed(element);
		//return driver.findElement(By.xpath("//img")).isDisplayed();
	}
	
	public boolean isLoginPanelDisplayed() {
		String loginPanelLocator = propOperation.getValue("loginPanel");
		WebElement element = getElement(loginPanelLocator, false);
		return isElementDisplayed(element);
		//return driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).isDisplayed();
	}
	
	public void enterCreds(String username, String password) {
		enterUsername(username);
		enterPassword(password);
	}
	
	private void enterUsername(String username) {
		WebElement element = getElement(propOperation.getValue("username"), false);
		enterText(element, username);
		//driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
	}
	
	private void enterPassword(String password) {
		WebElement element = getElement(propOperation.getValue("password"), false);
		enterText(element, password);
		//driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	}
	
	public SlideMenuPage clickOnLoginButton() {
		String loginButtonLocator = propOperation.getValue("loginBtn");
		WebElement element = getElement(loginButtonLocator, false);
		clickOnElement(element);
		//driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return new SlideMenuPage();
	}
	
	public String getLoginErrorMessage() {
		String loginErrMsgLocator = propOperation.getValue("loginErrorMsg");
		WebElement element = getElement(loginErrMsgLocator, false);
		return element.getText();
		//return driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	}
}