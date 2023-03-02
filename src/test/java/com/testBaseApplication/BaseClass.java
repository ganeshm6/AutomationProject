package com.testBaseApplication;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.browserSetup.BrowserLaunch;
import com.extendReport.ExtentReport;
import com.pageHelper.AddressHelper;
import com.pageHelper.CreateAccountHelper;
import com.pageHelper.HomeHelper;
import com.pageHelper.LoginHelper;
import com.pageHelper.PaymentHelper;
import com.pageHelper.ShopHelper;

public class BaseClass extends BrowserLaunch {

	@BeforeTest
	public void startReport() {
		startReport("EndtoEnd");

	}

	@Test(priority = 1)
	public void homePage() {
		ExtentReport.logger = ExtentReport.extent.startTest("SuccessHomePageReport");
		HomeHelper home = new HomeHelper();
		home.homePage(driver);
		System.out.println("Test");
	}

	@Test(priority = 3)

	public void vaildloginPage() {
		ExtentReport.logger = ExtentReport.extent.startTest("SuccessvalidLoginReport");
		LoginHelper login = new LoginHelper();
		login.validlogIn(driver);

	}

	@Ignore

	public void invalidlogInpage() {
		LoginHelper login = new LoginHelper();
		login.invalidlogIn(driver);
	}

	@Ignore
	@Test(priority = 1)
	public void withoutcreditials() {
		LoginHelper login = new LoginHelper();
		login.withoutUsernamePassword(driver);
	}

	@Ignore
	public void createAccount() {
		CreateAccountHelper Create = new CreateAccountHelper();
		Create.validNewAccount(driver);

	}

	@Ignore
	public void invalidCreateAccount() {
		CreateAccountHelper Create = new CreateAccountHelper();
		Create.InvalidcreditialAccount(driver);

	}

	@Ignore
	public void validAddress() {
		AddressHelper address = new AddressHelper();
		address.validAddress(driver);
	}

	@Test(priority = 2)
	public void shopProduct() throws InterruptedException {
		ExtentReport.logger = ExtentReport.extent.startTest("SuccessShopPageReport");
		ShopHelper shop = new ShopHelper();
		shop.shopProduct(driver);
	}

	@Test(priority = 4)
	public void paymentProduct() throws InterruptedException {
		ExtentReport.logger = ExtentReport.extent.startTest("SuccessPaymentPageReport");
		PaymentHelper payment = new PaymentHelper();
		payment.paymentHelper(driver);
	}
}
