package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.PropertiesOperation;

public class ProfilePage extends PreDefinedActions {
	private PropertiesOperation propOperation;
	static private ProfilePage profilePage;
	Logger log = Logger.getLogger(ProfilePage.class);
	
	private ProfilePage() {
		try {
			propOperation = new PropertiesOperation(ConstantPath.PROFILEPAGELOCATOR_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ProfilePage getObject() {
		if(profilePage == null)
			profilePage = new ProfilePage();
		return profilePage;
	}
	
	public void clickOnUserArrowDropdown() {
		WebElement element = getElement(propOperation.getValue("userDropdownArrow"), false);
		clickOnElement(element);
		log.debug(element);
		//driver.findElement(By.xpath("//i[text()='keyboard_arrow_down']")).click();
	}
	
	public List<String> getListOfUserDropdownOptions() {
		List<String> dropdownOptionsName = getTextOfAllElements(propOperation.getValue("userDropdownOptions"), false);
		log.debug(dropdownOptionsName);
		return dropdownOptionsName;
	}
	
	public int getTotalAvailableUserDropdownOptions() {
		int totalDropdownOptions = getListOfUserDropdownOptions().size();
		log.debug(totalDropdownOptions);
		return totalDropdownOptions;
	}
	
	public void clickOnAbout() {
		WebElement element = getElement(propOperation.getValue("aboutOption"), false);
		clickOnElement(element);
		log.debug(element);
		//driver.findElement(By.xpath("//ul[@id='user_menu']/li/a[@id='aboutDisplayLink']")).click();
	}
	
	public List<String> getCompanyDetailsFromAboutPopUp() {
		List<String> companyDetailsText = getTextOfAllElements(propOperation.getValue("aboutPopupCompanyDetails"), true);
		log.debug(companyDetailsText);
 		return companyDetailsText;
	}
	
	public void clickOkOnAboutPopUp() {
		WebElement element = getElement(propOperation.getValue("okButtonOnAboutPopup"), false);
		clickOnElement(element);
		log.debug(element);
		//driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}
}