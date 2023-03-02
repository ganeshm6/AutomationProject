package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject {
	WebDriver driver;

	public LoginObject(WebDriver baseDriver) {
		driver = baseDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".site-header__icon.site-header__account")
	public WebElement loginIcon;
	@FindBy(xpath = "//h1[text()='Login']")
	public WebElement headerLoginText;
	@FindBy(xpath = "//label[text()='Email']/following::input[@id='CustomerEmail']")
	public WebElement emailTextBox;
    @FindBy(xpath = "//label[text()='Password']/following::input[@id='CustomerPassword']")
	public WebElement passWordTextBox;
    @FindBy(css = "#RecoverPassword")
	public WebElement forgetPassword;
    @FindBy(xpath = "//input[@value='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//a[text()='Log out']")
   public WebElement signOut;
    @FindBy(xpath = "//div[@class='errors']/descendant::li[text()='Incorrect email or password.']")
    public WebElement errorMesasge;
 
	
	
	 
	
	
	
}
