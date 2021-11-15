package com.akanshaJain.orangeHRM.pages;

import java.util.List;
import org.openqa.selenium.By;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;

public class ProfilePage extends PreDefinedActions {
	
	public void clickOnUserArrowDropdown() {
		driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']")).click();
	}
	
	public List<String> getListOfUserDropdownOptions() {
		return getTextOfAllElements("XPATH", "//ul[@id='user_menu']/li/a", false);
	}
	
	public int getTotalAvailableUserDropdownOptions() {
		return getListOfUserDropdownOptions().size();
	}
	
	public void clickOnAbout() {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li/a[@id='aboutDisplayLink']")).click();
	}
	
	public List<String> getCompanyDetailsFromAboutPopUp() {
		return getTextOfAllElements("XPATH", "//div[@id='companyInfo']//p", false);
	}
	
	public void clickOkOnAboutPopUp() {
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}
}