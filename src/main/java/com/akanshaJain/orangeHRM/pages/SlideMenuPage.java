package com.akanshaJain.orangeHRM.pages;

import org.openqa.selenium.By;
import com.akanshaJain.orangeHRM.base.PreDefinedActions;

public class SlideMenuPage extends PreDefinedActions {

	public void navigateTo(String menu){
		String[] arr = menu.split("->");
		for(String item : arr) {
			driver.findElement(By.xpath("//span[text()='"+item+"']")).click();
		}		
	}
}