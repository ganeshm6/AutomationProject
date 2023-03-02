package com.pageObject;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObject {
	WebDriver driver;
	public HomeObject(WebDriver baseDriver) {
		 driver = baseDriver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//a[@class='site-header__logo-image']") public WebElement
	// logo;
	@FindBy(css = ".site-nav__link.site-nav__link--main.site-nav__link--active")
	public WebElement homeButton;			
	@FindBy(tagName = "a")
	public List<WebElement> Links;
	@FindBy(tagName = "img")
	public List<WebElement>imgLinks;
	@FindBy(css =".product-card__image-with-placeholder-wrapper")
	public List<WebElement>productImage;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}