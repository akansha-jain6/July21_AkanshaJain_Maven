package com.akanshaJain.orangeHRM.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.customerExceptions.InvalidSelectorException;
import com.akanshaJain.orangeHRM.util.DateOperations;

public class PreDefinedActions {
	protected static WebDriver driver;
	private static WebDriverWait wait; 
	
	public static void start(String url) {
		System.setProperty(ConstantPath.CHROMEDRIVER_KEY, ConstantPath.CHROMEDRIVER_PATH);
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(ConstantPath.WAIT, TimeUnit.SECONDS);
		System.out.println("STEP - Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ConstantPath.WAIT);
	}
	
	protected WebElement getElement(String locator, boolean isWaitRequired) {
		WebElement element = null;
		String locatorType = locator.split(":-")[0].replace("[","").replace("]","");
		String locatorValue = locator.split(":-")[1];
		/*if(isWaitRequired)
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(getByReference(locatorType, locatorValue)));
		else
			element = driver.findElement(getByReference(locatorType, locatorValue));*/
		switch(locatorType) {
			case "XPATH" : 
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				else
					element = driver.findElement(By.xpath(locatorValue));
				break;
			case "ID":
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				else
					element = driver.findElement(By.id(locatorValue));
				break;
			default :
				throw new InvalidSelectorException("User Should Select values from XPATH, CSS, ID, NAME");
		}
		return element;
	}
	
	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement element = null;
		locatorType = locatorType.replace("[","").replace("]","");
		/*if(isWaitRequired)
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(getByReference(locatorType, locatorValue)));
		else
			element = driver.findElement(getByReference(locatorType, locatorValue));*/
		switch(locatorType) {
			case "XPATH" : 
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				else
					element = driver.findElement(By.xpath(locatorValue));
				break;
			case "ID":
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				else
					element = driver.findElement(By.id(locatorValue));
				break;
			default :
				throw new InvalidSelectorException("User Should Select values from XPATH, CSS, ID, NAME");
		}
		return element;
	}
	
	protected List<WebElement> getElements(String locator, boolean isWaitRequired) {
		List<WebElement> elements = null;
		String locatorType = locator.split(":-")[0].replace("[","").replace("]","");
		String locatorValue = locator.split(":-")[1];
		switch (locatorType) {
		case "XPATH":
			if (isWaitRequired)
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				elements = driver.findElements(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				elements = driver.findElements(By.id(locatorValue));
			break;
		default:
			throw new InvalidSelectorException("User Should Select values from XPATH, CSS, ID, NAME");
		}
		return elements;
	}
	
	protected List<WebElement> getElements(String locatorType, String locatorValue, boolean isWaitRequired) {
		List<WebElement> elements = null;
		locatorType = locatorType.replace("[","").replace("]","");
		switch (locatorType) {
		case "XPATH":
			if (isWaitRequired)
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				elements = driver.findElements(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				elements = driver.findElements(By.id(locatorValue));
			break;
		default:
			throw new InvalidSelectorException("User Should Select values from XPATH, CSS, ID, NAME");
		}
		return elements;
	}
	
	protected List<String> getTextOfAllElements(String locator, boolean isWaitRequired){
		List<WebElement> widgetsListElements = getElements(locator, isWaitRequired);
		List<String> widgetList = new ArrayList<String>();
		
		for(WebElement widgetElement : widgetsListElements) {
			widgetList.add(widgetElement.getText());
		}
		return widgetList;
	}
	
	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);		
	}
	
	protected void clickOnElement(WebElement element) {
		if(!element.isDisplayed())
			scrollToElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	protected boolean isElementDisplayed(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return isElementDisplayed(e);
	}
	
	protected boolean isElementDisplayed(WebElement element) {
		if(element.isDisplayed())
			return true;
		else {
			scrollToElement(element);
			return element.isDisplayed() ? true : false;
		}
	}
	
	protected boolean enterText(String locatorType, String locatorValue, boolean isWaitRequired, String keysToSend) {
		WebElement element = getElement(locatorType, locatorValue, isWaitRequired);
		return enterText(element, keysToSend);
	}
	
	protected boolean enterText(WebElement element, String keysToSend) {
		if(element.isEnabled()) {
			element.sendKeys(keysToSend);
			return true;
		}else
			return false;
	}
	
	protected String getElementText(WebElement element) {
		if(element.isDisplayed())
			return element.getText();
		else {
			scrollToElement(element);
			return element.getText();
		}
	}
	
	protected String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	protected String getPageTitle() {
		return driver.getTitle();
	}
	
	public static void captureScreenshot(String name) {
		name = name + DateOperations.getTimeStamp();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+name+".png");
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
}