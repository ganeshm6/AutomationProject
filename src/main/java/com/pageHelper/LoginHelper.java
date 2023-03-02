package com.pageHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import com.pageObject.LoginObject;
import com.pageaction.PageAction;
import com.ultils.ExcelReader.ExcelFileReader;


public class LoginHelper {
   
	public void validlogIn(WebDriver driver) {
		LoginObject login = new LoginObject(driver);
//		PageAction.ClickerEvent(login.loginIcon);
//		WebElement headerText = login.headerLoginText;
//		String actualText = headerText.getText();
//		String exceptedText = "Login";
//		Assert.assertTrue(actualText.contains(exceptedText));
		PageAction.sendEvent(login.emailTextBox,ExcelFileReader.getDataString(0, 1, 1));
		PageAction.sendEvent(login.passWordTextBox, "Smrk@1953");
		PageAction.ClickerEvent(login.signIn);
		//PageAction.ClickerEvent(login.signOut);
	}

	public void invalidlogIn(WebDriver driver) {
		LoginObject login = new LoginObject(driver);
		PageAction.ClickerEvent(login.loginIcon);
		WebElement headerText = login.headerLoginText;
		String actualText = headerText.getText();
		String exceptedText = "Login";
		Assert.assertTrue(actualText.contains(exceptedText));
		PageAction.sendEvent(login.emailTextBox, "smganesh1953");
		PageAction.sendEvent(login.passWordTextBox, "1953");
		PageAction.ClickerEvent(login.signIn);
		// PageAction.ClickerEvent(login.signOut);
		WebElement actualError = login.errorMesasge;
		String actualErrorText = actualError.getText();
		String exceptedError = "Incorrect email or password.";
		Assert.assertEquals(actualErrorText, exceptedError);
		PageAction.ClickerEvent(login.forgetPassword);

	}

	public void withoutUsernamePassword(WebDriver driver) {
		LoginObject login = new LoginObject(driver);
		PageAction.ClickerEvent(login.loginIcon);
		WebElement headerText = login.headerLoginText;
		String actualText = headerText.getText();
		String exceptedText = "Login";
		Assert.assertTrue(actualText.contains(exceptedText));
		// PageAction.sendEvent(login.emailTextBox,"smganesh1953");
		// PageAction.sendEvent(login.passWordTextBox,"1953");
		PageAction.ClickerEvent(login.signIn);
		// PageAction.ClickerEvent(login.signOut);
		WebElement actualError = login.errorMesasge;
		String actualErrorText = actualError.getText();
		String exceptedError = "Incorrect email or password.";
		Assert.assertEquals(actualErrorText, exceptedError);
		// PageAction.ClickerEvent(login.forgetPassword);
	}

}
