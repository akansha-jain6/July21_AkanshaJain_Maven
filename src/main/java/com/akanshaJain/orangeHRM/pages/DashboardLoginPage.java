package com.akanshaJain.orangeHRM.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;

public class DashboardLoginPage extends PreDefinedActions {
	
	public String getPageHeaderTitle() {
		return getPageTitle();
	}
	
	public String getPageTitle() {
		WebElement element = getElement("XPATH", "//li[@class='page-title']", false);
		return getElementText(element);
		//return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}
	
	public int getTotalWidgets() {
		return getElements("XPATH", "//div[@class='widget-header']", false).size();
		//return driver.findElements(By.xpath("//div[@class='widget-header']")).size();
	}
	
	public List<String> getAllWidgetText() {
		return getTextOfAllElements("XPATH", "//div[@class='widget-header']/span[2]", false);
	}
	
	public String getWidgetTextBasedOnIndex(int index) {
		List<String> widgetsList = getAllWidgetText();
		return widgetsList.get(index);
	}
}