package com.akanshaJain.orangeHRM.pages;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.PropertiesOperation;

public class DashboardLoginPage extends PreDefinedActions {
	private PropertiesOperation propOperation;
	static private DashboardLoginPage dashboardLoginPage;
	Logger log = Logger.getLogger(DashboardLoginPage.class);
	
	private DashboardLoginPage() {
		try {
			propOperation = new PropertiesOperation(ConstantPath.DASHBOARDPAGELOCATOR_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DashboardLoginPage getObject() {
		if(dashboardLoginPage == null)
			dashboardLoginPage = new DashboardLoginPage();
		return dashboardLoginPage;
	}
	
	public String getPageHeaderTitle() {
		return getPageTitle();
	}
	
	public String getPageTitle() {
		WebElement element = getElement(propOperation.getValue("dashboardPageTitle"), false);
		log.debug(element);
		return getElementText(element);
		//return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}
	
	public int getTotalWidgets() {
		int size = getElements(propOperation.getValue("totalWidgets"), false).size();
		log.debug(size);
		return size;
		//return driver.findElements(By.xpath("//div[@class='widget-header']")).size();
	}
	
	public List<String> getAllWidgetText() {
		List<String> elementsText = getTextOfAllElements(propOperation.getValue("widgetName"), false);
		log.debug(elementsText);
		return elementsText;
	}
	
	public String getWidgetTextBasedOnIndex(int index) {
		List<String> widgetsList = getAllWidgetText();
		log.debug(widgetsList.get(index));
		return widgetsList.get(index);
	}
}