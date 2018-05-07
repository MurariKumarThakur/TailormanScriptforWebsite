package com.action.engine;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.engine.DriverEngine;

import com.helper.utility.GetExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.log.Logger;

public class ActionEngine extends DriverEngine {

	public static WebDriverWait wait;

	// navigate method
	public static void navigateToUrl(String enterUrl) {

		driver.navigate().to(enterUrl);

	}

	public static void navigateBack() {

		driver.navigate().back();
	}

	public static void navigateForward() {

		driver.navigate().forward();

	}

	public static void refreshBrowser() {

		driver.navigate().back();
	}
	// get Command

	public static String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

	public static String getTitle() {

		return driver.getTitle();

	}

	public static String getPageSource() {

		return driver.getPageSource();
	}

	public static String getText(WebElement name) {

		return name.getText();
	}

	public static String getTagName(WebElement name) {

		return name.getTagName();
	}

	public static String getAttributeValue(WebElement name, String enterAttributeName) {

		return name.getAttribute(enterAttributeName);
	}

	public static void click(WebElement name) {

		name.click();

		GetExtentReport.logger.log(LogStatus.INFO, "Clicked on Element");

	}

	public static void clear(WebElement name) {

		name.clear();
	}

	public static void sendKeys(WebElement name, String data) {
		name.clear();
		name.sendKeys(data);
	}

	public static void closeSingleWindow() {

		driver.close();
	}

	public static void closeAllWindow() {
		driver.quit();
	}

	// wait command
	public static void waitForElementVisibility(WebElement locator) {

		wait = new WebDriverWait(driver, 35);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public static void waitForElementClickable(WebElement locator) {

		wait = new WebDriverWait(driver, 35);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static boolean checkAlertBoxExistance() {

		wait = new WebDriverWait(driver, 35);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {

			return true;
		} else {

			return false;
		}

	}

	public static void WaitFor3sec() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// alert handling
	public static void alertAccept() {

		driver.switchTo().alert().accept();
	}

	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public static void alertDismiss() {

		driver.switchTo().alert().dismiss();
	}

	public static void sendDataInPromptBox(String putPromptData) {

		driver.switchTo().alert().sendKeys(putPromptData);

	}
	// conditional

	public static boolean CheckElementEnable(WebElement name) {

		return name.isEnabled();
	}

	public static boolean checkElementDisplay(WebElement name) {
		return name.isDisplayed();
	}

	public static boolean checkElementSelection(WebElement name) {

		return name.isSelected();
	}

	public static void HandleWindow() {

		String window = driver.getWindowHandle();

		driver.switchTo().window(window);

	}

	public static void verifyElementExistance(WebElement name, String ExpectedText)

	{

		String ActualText = name.getText();
		
		System.out.println(ActualText);

		if (ActualText.equals(ExpectedText)) {

			Assert.assertEquals(ActualText, ExpectedText);

		}

		else

		{

			System.out.println("ACTUAL RESULT IS NOT MATCHING WITH EXPECTED !!!");

		}

	}

	// scroll in to view

	public static void scrollIntoView(WebElement name) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.executeScript("arguments[0].scrollIntoView(true);", name);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}