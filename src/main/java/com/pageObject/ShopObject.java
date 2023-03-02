package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopObject {
	WebDriver driver;
public ShopObject(WebDriver baseDriver) {
	driver=baseDriver;
	PageFactory.initElements(driver, this);	
}
@FindBy(xpath = "//button[@aria-controls='SiteNavLabel-shop']")
public WebElement shopTextBox;
@FindBy(xpath = "//a[@class='site-nav__link site-nav__child-link']/following::span[text()='Gold Premium Full Sleeve ']")
public WebElement TshirtSelectquality;
@FindBy(xpath = "//span[text()='Gold Premium Green Full Sleeve T Shirt']/parent::a")
public WebElement GreenTshirtselect;
@FindBy(css = "#SingleOptionSelector-0")
public WebElement sizeSelect;
@FindBy(xpath = "//button[@data-testid='Checkout-button']")
public WebElement buyButton;







}
