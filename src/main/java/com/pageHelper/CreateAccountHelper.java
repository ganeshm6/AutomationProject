package com.pageHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pageObject.CreateAccountObject;
import com.pageObject.LoginObject;
import com.pageaction.PageAction;

public class CreateAccountHelper {
	public void validNewAccount(WebDriver driver) {
		LoginObject login = new LoginObject(driver);
		PageAction.ClickerEvent(login.loginIcon);
		CreateAccountObject createAccount = new CreateAccountObject(driver);
		PageAction.ClickerEvent(createAccount.createNewAccount);
		WebElement headerTitle = createAccount.CreateAccountTitle;
		String actualTitle = headerTitle.getText();
		String expectedTitle = "Create Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		PageAction.sendEvent(createAccount.firstName, "ganesh");
		PageAction.sendEvent(createAccount.lastName, "M");
		PageAction.sendEvent(createAccount.emailID, "smganesh9943@gmail.com");
		PageAction.sendEvent(createAccount.passWord, "Smrk@1953");
		PageAction.ClickerEvent(createAccount.submit);
		WebElement alertBox = createAccount.alertBox;
		boolean isEnabled = alertBox.isEnabled();
		if (isEnabled == true) {
			Assert.assertTrue(true);
			String alerttext = alertBox.getText();
			System.out.println("itsDisplayed" + isEnabled);
			System.out.println("AlreadyUserExist" + alerttext);
		} else {
			Assert.assertTrue(false);
			System.out.println("conditionFalse");
		}
	}

	public void InvalidcreditialAccount(WebDriver driver) {
		LoginObject login = new LoginObject(driver);
		PageAction.ClickerEvent(login.loginIcon);
		CreateAccountObject createAccount = new CreateAccountObject(driver);
		PageAction.ClickerEvent(createAccount.createNewAccount);
		WebElement headerTitle = createAccount.CreateAccountTitle;
		String actualTitle = headerTitle.getText();
		String expectedTitle = "Create Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		PageAction.sendEvent(createAccount.firstName, "  ");
		PageAction.sendEvent(createAccount.lastName, "M");
		PageAction.sendEvent(createAccount.emailID, "smganesh9943@");
		PageAction.sendEvent(createAccount.passWord, "Smrk@");
		PageAction.ClickerEvent(createAccount.submit);
		WebElement withoutMailAlert = createAccount.invalidEmailError;
		boolean isEnabled = withoutMailAlert.isEnabled();
		WebElement withoutCheckBoxAlert = createAccount.invalidmailCheckBoxError;
		boolean isEnable = withoutCheckBoxAlert.isEnabled();
		if (isEnabled && isEnable) {
			String alert1 = withoutMailAlert.getText();
			System.out.println("show the emailError" + alert1);
			Assert.assertTrue(isEnabled, alert1);
			String alert2 = withoutCheckBoxAlert.getText();
			Assert.assertTrue(isEnable, alert2);
			System.out.println("show the emailError" + alert2);
			Assert.assertTrue(isEnable, alert2);
		}
		PageAction.sendEvent(createAccount.firstName, "  ");
		PageAction.sendEvent(createAccount.lastName, "M");
		PageAction.sendEvent(createAccount.emailID, "smganesh9943");
		PageAction.sendEvent(createAccount.passWord, "Smr");
		PageAction.ClickerEvent(createAccount.submit);
		WebElement shortPasswordAlert = createAccount.CheckBoxpassWordError;
		boolean shortPasswordEnable = shortPasswordAlert.isEnabled();
		WebElement withoutMailandPassAlert = createAccount.invalidEmailError;
		boolean shortPasswordEnableAlert = withoutMailandPassAlert.isEnabled();
		if (shortPasswordEnable && shortPasswordEnableAlert) {
			String alert1 = shortPasswordAlert.getText();
			System.out.println("show the PassWordError" + alert1);
			Assert.assertTrue(shortPasswordEnable, alert1);
			String alert2 = withoutMailandPassAlert.getText();
			Assert.assertTrue(shortPasswordEnableAlert, alert2);
			System.out.print("show the passWordError" + alert2);
			Assert.assertTrue(isEnable, alert2);
		} else
			Assert.assertTrue(false);
		PageAction.ClickerEvent(createAccount.submit);
		WebElement blankEmailAndPassWord = createAccount.WithoutEmailandPasswordError;
		WebElement blankEmail = createAccount.WithoutEmailError;
		WebElement blankPassWord = createAccount.WithoutpassWordError;
		boolean blankEmailAndPassWordEnable = blankEmailAndPassWord.isEnabled();
		boolean blankEmailEnable = blankEmail.isEnabled();
		boolean blankPassWordEnable = blankPassWord.isEnabled();
		if (blankEmailAndPassWordEnable && blankEmailEnable && blankPassWordEnable) {
			Assert.assertTrue(blankEmailAndPassWordEnable);
			Assert.assertTrue(blankEmailEnable);
			Assert.assertTrue(blankPassWordEnable);
			String alert1 = blankEmailAndPassWord.getText();
			String alert2 = blankEmail.getText();
			String alert3 = blankPassWord.getText();
			System.out.print("Error1" + alert1 + "Error2" + alert2 + "Error3" + alert3);
		}

	}

}
