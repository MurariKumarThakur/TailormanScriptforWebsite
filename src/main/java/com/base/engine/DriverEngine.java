package com.base.engine;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.action.engine.ActionEngine;
import com.helper.utility.GetExtentReport;
import com.path.manager.pathManager;


public class DriverEngine {
	public static  RemoteWebDriver driver;
   static  WebDriverWait wait ;
	
	@BeforeSuite
	@Parameters("browserName")
	public static  void openBrowser(@Optional("chrome")  String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", pathManager.chromeDriverPath);
			driver = new ChromeDriver();
			
			initialBrowserCommand();
			
		
			
			
			

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdirver.geco.driver", pathManager.firfoxDriverPath);

			driver = new FirefoxDriver();
			initialBrowserCommand();
		} else if (browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdirver.geco.driver", pathManager.iEDriverPath);

			driver = new InternetExplorerDriver();
			
			initialBrowserCommand();

		}

	}

	public static void initialBrowserCommand() {

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		
		driver.get(pathManager.config.getPropertyFileValue("tailorManWebsiteUrl"));
		    handleTailorManPopup();
	}
	@AfterSuite
	public void endSuite(){
	
	  GetExtentReport.endReport();
	  driver.get(GetExtentReport.reportUrl);
		
	}
	@AfterMethod
	public void startMethod(ITestResult result){
		
		GetExtentReport.getStatus(result);
		
	}
	public static void waitForElementVisibility(WebElement locator) {

		wait = new WebDriverWait(driver, 35);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}
	public static void handleTailorManPopup() {
		WebElement popuploc = driver.findElementByXPath("//i[contains(@class ,'subscribtion-close')]");
		waitForElementVisibility(popuploc);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		popuploc.click();

	}
	
}
