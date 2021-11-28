package com.akanshaJain.orangeHRM.testScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.akanshaJain.orangeHRM.constants.ConstantPath;

public class TakeScreenshotTest {
	WebDriver driver;
	Logger log = Logger.getLogger(TakeScreenshotTest.class);
	
	@Test
	public void takeScreenShot() throws InterruptedException {
		System.setProperty(ConstantPath.CHROMEDRIVER_KEY, ConstantPath.CHROMEDRIVER_PATH);
		log.info("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ConstantPath.WAIT, TimeUnit.SECONDS);
		log.info("STEP - Enter url");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConstantPath.WAIT, TimeUnit.SECONDS);
		driver.findElement(By.id("registration21")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			String methodName = result.getMethod().getMethodName();
			long miliSecs = System.currentTimeMillis();
			Date date = new Date(miliSecs);
			SimpleDateFormat simpleDtFormat = new SimpleDateFormat("MMM dd HH:mm:ss");
			String timestamp = simpleDtFormat.format(date);
			FileUtils.copyFile(file, new File(".//" + methodName + timestamp +".jpeg"));
		}
		driver.close();
		driver.quit();
	}
}