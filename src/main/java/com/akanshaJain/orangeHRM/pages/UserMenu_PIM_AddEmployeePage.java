package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;

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
		//driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeMiddleName(String mName) {
		WebElement element = getElement(propOperation.getValue("employeeMiddleName"), false);
		enterText(element, mName);
		//driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(mName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeLastName(String lName) {
		WebElement element = getElement(propOperation.getValue("employeeLastName"), false);
		enterText(element, lName);
		//driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lName);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeLocation(String location) {
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage clickOnButton(String buttonName) {
		driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeHobbies(String hobby) {
		driver.findElement(By.xpath("//input[@id='5']")).sendKeys(hobby);
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeWorkShift(String shiftValue) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement workShiftDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")));
		workShiftDropdown.click();
		WebElement workShiftOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+shiftValue+"']")));
		workShiftOptionSelect.click();
		return this;
	}
	
	//TODO - Sun, 20 Sep 2015
	public UserMenu_PIM_AddEmployeePage setEmployeeEffectiveFromDate(String date) {
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		driver.findElement(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"'][contains(@class,'--infocus')]")).click();
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeRegion(String region) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement regionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		regionDropdown.click();
		WebElement regionOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+region+"']")));
		regionOptionSelect.click();
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeFTE(String fte) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement fteDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='FTE']/preceding-sibling::div/input")));
		fteDropdown.click();
		WebElement fteOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+fte+"']")));
		fteOptionSelect.click();
		return this;
	}
	
	public UserMenu_PIM_AddEmployeePage setEmployeeTempDept(String tempDept) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement tempDeptDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Temporary Department']/preceding-sibling::div/input")));
		tempDeptDropdown.click();
		WebElement tempDeptOptionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]/li/span[text()='"+tempDept+"']")));
		tempDeptOptionSelect.click();
		return this;
	}
	
	public String verifySuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement displaySuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[text()='Successfully Saved']")));
		String successMessage = displaySuccessMessage.getText();
		return successMessage;
	}
}