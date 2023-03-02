package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountObject {
 WebDriver driver;
 public CreateAccountObject(WebDriver baseDriver) {
		driver = baseDriver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(css = "#customer_register_link")
	public WebElement createNewAccount;
@FindBy(xpath="//h1[text()='Create Account']")
public WebElement CreateAccountTitle;
@FindBy(xpath="//label[text()='First Name']/following::input[@name='customer[first_name]']")
public WebElement firstName;
@FindBy(xpath="//label[text()='Last Name']/following::input[@name='customer[last_name]']")
public WebElement lastName; 
@FindBy(xpath="//label[text()='Email']/following::input[@name='customer[email]']")
public WebElement emailID; 
@FindBy(xpath="//label[text()='Password']/following::input[@name='customer[password]']")
public WebElement passWord; 
@FindBy(xpath="//input[@value='Create']")
public WebElement submit;  
@FindBy(css=".form-message")
public WebElement alertBox; 
@FindBy(css=".form-message.form-message--error")
public WebElement invalidEmailError; 
@FindBy(xpath="//span[text()='Email is invalid.']")
 public WebElement invalidmailCheckBoxError;
@FindBy(css="#RegisterForm-password-error")
public WebElement CheckBoxpassWordError; 
@FindBy(css=".form-message.form-message--error")
public WebElement invalidEmailandPasswordError; 
@FindBy(css=".form-message.form-message--error")
public WebElement WithoutEmailandPasswordError; 
@FindBy(css="#RegisterForm-email-error")
public WebElement WithoutEmailError; 
@FindBy(css="#RegisterForm-password-error")
public WebElement WithoutpassWordError;  

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
