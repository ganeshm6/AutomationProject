package com.pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageAction {
	// In this methode used in click() action
	public static void ClickerEvent(WebElement element) {
		element.click();
	}

	// In this methode used in sendKeys() action
	public static void sendEvent(WebElement element, String DataValues) {
		element.sendKeys(DataValues);

	}

	// In this methode used in selectByValue from select Class
	public static void selectByValue(WebElement element, String DataValues) {
		Select select = new Select(element);
		select.selectByValue(DataValues);

	}
	// In this methode used in selectByText from select Class

	public static void selectByVisibleText(WebElement element, String DataValues) {
		Select select = new Select(element);
		select.selectByVisibleText(DataValues);

	}

	// In this methode used in selectByIndex from select Class
	public static void selectByIndex(WebElement element, int dataValues) {
		Select select = new Select(element);
		select.selectByIndex(dataValues);

	}
	public static void moveToElement(WebDriver driver,WebElement Element) {
		Actions act = new Actions(driver);
		act.moveToElement(Element);
		
	}

}
