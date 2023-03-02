package com.pageHelper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageObject.HomeObject;
import com.pageaction.PageAction;

public class HomeHelper {

	public void homePage(WebDriver driver) {
		//PageAction actions = new PageAction();
		HomeObject HomeObject1 = new HomeObject(driver);
		PageAction.ClickerEvent(HomeObject1.homeButton);

		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Roarsouth")) {
			Assert.assertTrue(true);
			List<WebElement> allLinks = HomeObject1.Links;
			allLinks.addAll(HomeObject1.imgLinks);
			List<WebElement> activeLinks = new ArrayList<WebElement>();
			for (int i = 0; i < allLinks.size(); i++) {
				if (allLinks.get(i).getAttribute("href") != null) {
					activeLinks.add(allLinks.get(i));
				}
			}
			System.out.println("pageTittle" + pageTitle);
			System.out.println("activeLinks" + activeLinks.size());
			List<WebElement> Allimage = HomeObject1.productImage;
			int productSize = Allimage.size();
			System.out.println("number of image in homePage" + productSize);

		} else
			Assert.assertTrue(false);

	}
}