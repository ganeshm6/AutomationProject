package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentObject {
	WebDriver driver;

	public PaymentObject(WebDriver baseDriver) {
		driver = baseDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Continue to shipping']/parent::button")
	public WebElement continueShipping;
	@FindBy(xpath = "//span[text()='Continue to payment']/parent::button")
	public WebElement continuePayment;
	@FindBy(xpath = "//p[text()='₹42.90']/ancestor::button")
	public WebElement tipsButton;
	@FindBy(xpath = "//span[text()='Pay now']/parent::button")
	public WebElement payNow;
    @FindBy(css = ".modal-close.svelte-f8jo93")
	public WebElement cancelPayment;
	@FindBy(css = "#positiveBtn")
	public WebElement cancelConform;

}
