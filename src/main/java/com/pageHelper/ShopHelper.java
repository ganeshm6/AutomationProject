package com.pageHelper;

import org.openqa.selenium.WebDriver;

import com.pageObject.ShopObject;
import com.pageaction.PageAction;

public class ShopHelper {

	public void shopProduct(WebDriver driver) throws InterruptedException {
		ShopObject product = new ShopObject(driver);
		PageAction.ClickerEvent(product.shopTextBox);
		PageAction.ClickerEvent(product.TshirtSelectquality);
		PageAction.moveToElement(driver, product.GreenTshirtselect);
		PageAction.ClickerEvent(product.GreenTshirtselect);
		PageAction.selectByValue(product.sizeSelect, "3XL");
		PageAction.ClickerEvent(product.buyButton);

	}
}
