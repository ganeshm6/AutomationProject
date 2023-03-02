package com.pageHelper;

import org.openqa.selenium.WebDriver;

import com.pageObject.PaymentObject;
import com.pageaction.PageAction;

public class PaymentHelper {

	public void paymentHelper(WebDriver driver) throws InterruptedException {
		PaymentObject payment = new PaymentObject(driver);
		PageAction.ClickerEvent(payment.continueShipping);
		PageAction.ClickerEvent(payment.continuePayment);
		PageAction.ClickerEvent(payment.tipsButton);
		Thread.sleep(2000);
		PageAction.moveToElement(driver, payment.payNow);
		PageAction.ClickerEvent(payment.payNow);
//		PageAction.ClickerEvent(payment.cancelPayment);
//		PageAction.ClickerEvent(payment.cancelConform);
	}
}
