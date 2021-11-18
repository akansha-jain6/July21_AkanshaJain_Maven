package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.PropertiesOperation;

public class UserMenu_PIM_AddEmployeePage extends PreDefinedActions {
	private PropertiesOperation propOperation;
	static private UserMenu_PIM_AddEmployeePage userMenuPIMAddEmployeePage;
	Logger log = Logger.getLogger(UserMenu_PIM_AddEmployeePage.class);
	
	private UserMenu_PIM_AddEmployeePage() {
		try {
			propOperation = new PropertiesOperation(ConstantPath.USERMENUPIMADDEMPLOYEEPAGELOCATOR);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UserMenu_PIM_AddEmployeePage getObject() {
		if(userMenuPIMAddEmployeePage == null)
			userMenuPIMAddEmployeePage = new UserMenu_PIM_AddEmployeePage();
		return userMenuPIMAddEmployeePage;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeFirstName(String fName) {
		WebElement element = getElement(propOperation.getValue("employeeFirstName"), false);
		enterText(element, fName);
		log.debug(element);
		//driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeMiddleName(String mName) {
		WebElement element = getElement(propOperation.getValue("employeeMiddleName"), false);
		enterText(element, mName);
		log.debug(element);
		//driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(mName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeLastName(String lName) {
		WebElement element = getElement(propOperation.getValue("employeeLastName"), false);
		enterText(element, lName);
		log.debug(element);
		//driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeLocation(String location) {
		enterOnArrow();
		WebElement element = driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a"));
		clickOnElement(element);
		log.debug(element);
		return this;
	}
	
	private void enterOnArrow() {
		WebElement element = getElement(propOperation.getValue("arrowIcon"), false);
		clickOnElement(element);
		log.debug(element);
	}
	
	public UserMenu_PIM_AddEmployeePage clickOnButton(String buttonName) {
		WebElement element = driver.findElement(By.xpath("//button[text()='"+buttonName+"']"));
		clickOnElement(element);
		log.debug(element);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeHobbies(String hobby) {
		WebElement element = getElement(propOperation.getValue("employeeHobbies"), false);
		enterText(element, hobby);
		log.debug(element);
		//driver.findElement(By.xpath("//input[@id='5']")).sendKeys(hobby);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeWorkShift(String shiftValue) {
		WebElement workShiftDropdown = getElement(propOperation.getValue("employeeWorkShift"), true);
		clickOnElement(workShiftDropdown);
		log.debug(workShiftDropdown);
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.WAIT);
		//WebElement workShiftDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")));
		//workShiftDropdown.click();
		WebElement workShiftOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+shiftValue+"']")));
		clickOnElement(workShiftOptionSelect);
		log.debug(workShiftOptionSelect);
		return this;
	}
	
	//TODO - Sun, 20 Sep 2015
	public UserMenu_PIM_AddEmployeePage setEmployeeEffectiveFromDate(String date) {
		tapOnCalendarIcon();
		WebElement element = driver.findElement(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"'][contains(@class,'--infocus')]"));
		clickOnElement(element);
		log.debug(element);
		return this;
	}
	
	private void tapOnCalendarIcon() {
		//driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		WebElement element = getElement(propOperation.getValue("calendarIcon"), true);
		clickOnElement(element);
		log.debug(element);
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeRegion(String region) {
		WebElement regionDropdown = getElement(propOperation.getValue("regionDropdown"), true);
		//WebElement regionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		clickOnElement(regionDropdown);
		log.debug(regionDropdown);
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.WAIT);
		WebElement regionOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+region+"']")));
		clickOnElement(regionOptionSelect);
		log.debug(regionOptionSelect);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeFTE(String fte) {
		WebElement fteDropdown = getElement(propOperation.getValue("fteDropdown"), true);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='FTE']/preceding-sibling::div/input")));
		clickOnElement(fteDropdown);
		log.debug(fteDropdown);
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.WAIT);
		WebElement fteOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+fte+"']")));
		clickOnElement(fteOptionSelect);
		log.debug(fteOptionSelect);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeTempDept(String tempDept) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement tempDeptDropdown = getElement(propOperation.getValue("tempDeptDropDown"), true);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Temporary Department']/preceding-sibling::div/input")));
		clickOnElement(tempDeptDropdown);
		log.debug(tempDeptDropdown);
		WebElement tempDeptOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+tempDept+"']")));
		clickOnElement(tempDeptOptionSelect);
		log.debug(tempDeptOptionSelect);
		return this;
	}
	
	public String verifySuccessMessage() {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[text()='Successfully Saved']")));
		WebElement displaySuccessMessage = getElement(propOperation.getValue("successMessage"), true);
		String successMessage = displaySuccessMessage.getText();
		log.debug(successMessage);
		return successMessage;
	}
}