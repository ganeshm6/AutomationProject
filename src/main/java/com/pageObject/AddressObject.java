package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressObject {
	WebDriver driver;

	public AddressObject(WebDriver baseDriver) {
		driver = baseDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn.btn--small")
	public WebElement viewAddressBtn;
	@FindBy(xpath = "//h1[text()='Your Addresses']")
	public WebElement YourAddressHeader;
	@FindBy(css = "#AddressNewButton")
	public WebElement addressNewButton;
	@FindBy(id = "AddressFirstNameNew")
	public WebElement firstName;
	@FindBy(id = "AddressLastNameNew")
	public WebElement lastName;
	@FindBy(id = "AddressCompanyNew")
	public WebElement addressLineOne;
	@FindBy(id = "AddressAddress1New")
	public WebElement addressLineTwo;
	@FindBy(id = "AddressAddress2New")
	public WebElement addressLineThree;
	@FindBy(id = "AddressCityNew")
	public WebElement city;
	@FindBy(id = "AddressCountryNew")
	public WebElement countrySelect;
	@FindBy(id = "AddressProvinceNew")
	public WebElement ProvinceSelect;
	@FindBy(id = "AddressZipNew")
	public WebElement postalCode;
	@FindBy(id = "AddressPhoneNew")
	public WebElement phoneNumber;
	@FindBy(xpath = "//input[@value='Add Address']")
	public WebElement addAddress;
	@FindBy(css=".btn.btn--secondary.btn--small.address-delete")
	public WebElement deleteAddress;
}
