package com.browserSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.extendReport.ExtentReport;
import com.propertyfile.ReadProperty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends ExtentReport  {
	Properties baseProperty;

	
	
	@BeforeClass
  public void setup() throws IOException {
		baseProperty = ReadProperty.loadProperty("/Users/manig/com.automatio testing/com.roarsouth/src/main/resources/config.properties");
		        String browser = baseProperty.getProperty("Browser");
				String Url = baseProperty.getProperty("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30l));
		driver.get(Url);

	}
//@AfterClass
	public void tearDown() {
		driver.quit();
		;

	}

}
