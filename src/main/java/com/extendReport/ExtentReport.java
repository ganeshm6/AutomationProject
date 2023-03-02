package com.extendReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	public static WebDriver driver;

	public static ExtentReports extent;
	public static ExtentTest logger;

	public void startReport(String testName) {

		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/" + testName + ".html", true);
//		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/test-output/FailedTestsScreenshots/" + screenshotName
				+ "-" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void getReport(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentReport.logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			ExtentReport.logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

			String screenshotPath = ExtentReport.getScreenshot(ExtentReport.driver, result.getName());

			ExtentReport.logger.log(LogStatus.FAIL, ExtentReport.logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentReport.logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentReport.logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
			String screenshotPath = ExtentReport.getScreenshot(ExtentReport.driver, result.getName());

			ExtentReport.logger.log(LogStatus.PASS, ExtentReport.logger.addScreenCapture(screenshotPath));
		}

		ExtentReport.extent.endTest(ExtentReport.logger);
	}

	public static void logPassedStepToReportWithScreenshot(WebDriver driver, ExtentTest test, String passedMessage) {

		test.log(LogStatus.PASS, passedMessage);
		String base64Info = takeScreenshotAsBase64(driver);
		test.log(LogStatus.PASS, "" + test.addBase64ScreenShot(base64Info));
		extent.endTest(test);
		extent.flush();
	}

	public static String takeScreenshotAsBase64(WebDriver driver) {
		String destination = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, " + destination;
	}

	@AfterTest
	public void testEnd() {

		extent.flush();
//		extent.close();
	}
}
