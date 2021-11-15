package com.akanshaJain.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;

public class UserMenu_EmployeeListPage extends PreDefinedActions {

	public UserMenu_EmployeeListPage findByUserName(String name) {
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(name);
		driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
		return this;
	}
	
	public String getSearchedEmployeeName() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement listOfSearchUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='employeeListTable']/tbody/tr[1]/td[3]")));
		return listOfSearchUsers.getText();
	}
	
	public UserMenu_EmployeeListPage getDefaultRowCountAtEndOfPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement defaultRowCountDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select-dropdown']")));
		defaultRowCountDropdown.getText();
		return this;
	}
	
	public int getNoOfRowsAsPerDefaultCount() {
		return driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
	}
}