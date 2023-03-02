package com.pageHelper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pageObject.AddressObject;
import com.pageaction.PageAction;

public class AddressHelper {	

	public void validAddress(WebDriver driver) {
		AddressObject address = new AddressObject(driver);
		PageAction.ClickerEvent(address.viewAddressBtn);
	    Assert.assertTrue(address.YourAddressHeader.isEnabled());
	    PageAction.ClickerEvent(address.addressNewButton);
	    PageAction.sendEvent(address.firstName, "ganesh");
	    PageAction.sendEvent(address.lastName, "m");
	    PageAction.sendEvent(address.addressLineOne, "insurancecompany");
	    PageAction.sendEvent(address.addressLineTwo, "chrompet");
	    PageAction.sendEvent(address.addressLineThree, "casaGrand");
	    PageAction.sendEvent(address.city, "chennai");
	    PageAction.selectByValue(address.countrySelect, "India");
	    PageAction.selectByValue(address.ProvinceSelect, "Tamil Nadu");
	    PageAction.sendEvent(address.postalCode, "600044");
	    PageAction.sendEvent(address.phoneNumber, "123456789");
	    PageAction.ClickerEvent(address.addAddress);
//	    PageAction.ClickerEvent(address.deleteAddress);
//	    Alert alert = driver.switchTo().alert();
//	    alert.accept();
	}
}
