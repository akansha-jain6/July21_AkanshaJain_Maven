package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.PropertiesOperation;

public class UserMenu_EmployeeListPage extends PreDefinedActions {
	private PropertiesOperation propOperation;
	static private UserMenu_EmployeeListPage userMenuEmployeeListPage;
	Logger log = Logger.getLogger(UserMenu_EmployeeListPage.class);
	
	private UserMenu_EmployeeListPage() {
		try {
			propOperation = new PropertiesOperation(ConstantPath.USERMENUEMPLOYEELISTLOCATOR);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UserMenu_EmployeeListPage getObject() {
		if(userMenuEmployeeListPage == null)
			userMenuEmployeeListPage = new UserMenu_EmployeeListPage();
		return userMenuEmployeeListPage;
	}

	public UserMenu_EmployeeListPage findByUserName(String name) {
		enterEmployeeName(name);
		//driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(name);
		WebElement element = getElement(propOperation.getValue("searchIcon"), false);
		clickOnElement(element);
		log.debug(element);
		//driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
		return this;
	}
	
	private void enterEmployeeName(String name) {
		WebElement element = getElement(propOperation.getValue("employeeName"), false);
		enterText(element, name);
		log.debug(element);
	}
	
	public String getSearchedEmployeeName() {
		//WebDriverWait wait = new WebDriverWait(driver, ConstantPath.WAIT);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='employeeListTable']/tbody/tr[1]/td[3]")));
		WebElement listOfSearchUsers = getElement(propOperation.getValue("listOfUsersTable"), true);
		log.debug(listOfSearchUsers.getText());
		return listOfSearchUsers.getText();
	}
	
	public UserMenu_EmployeeListPage getDefaultRowCountAtEndOfPage() {
		//WebDriverWait wait = new WebDriverWait(driver, ConstantPath.WAIT);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select-dropdown']")));
		WebElement defaultRowCountDropdown = getElement(propOperation.getValue("defaultRowCountDropdown"), true);
		defaultRowCountDropdown.getText();
		log.debug(defaultRowCountDropdown.getText());
		return this;
	}
	
	public int getNoOfRowsAsPerDefaultCount() {
		int totalRowsPerPage = getElements(propOperation.getValue("defaultRowCount"), false).size();
		log.debug(totalRowsPerPage);
		return totalRowsPerPage;
		//return driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
	}
}