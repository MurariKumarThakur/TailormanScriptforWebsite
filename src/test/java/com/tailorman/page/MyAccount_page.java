/**
 * 
 */
package com.tailorman.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.path.manager.pathManager;
import com.tailorman.script.MyAccount;

/**
 * @author Murari
 *
 */
public class MyAccount_page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'classic-user')][text()='MY ACCOUNT']")
	WebElement MyAccountLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='LOGIN'])[2]")
	WebElement LoginLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='SIGN UP'])[2]")
	WebElement SignUpLink;

	@FindBy(how = How.XPATH, using = "//div[text()='LOGIN']")
	WebElement LoginHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='REGISTRATION']")
	WebElement RegistrationLink;

	@FindBy(how = How.XPATH, using = "//div[@class='ui fluid input']//input[@type='text']")
	WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement passwrodField;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	WebElement LoginButton;

	@FindBy(how = How.XPATH, using = "(//span[text()='PROFILE'])[2]")
	WebElement profileLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='SIGN OUT'])[2]")
	WebElement signOutLink;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Account']")
	WebElement AccountHeading;
	
	

	public void MyAccountLinkExistance()

	{
		
		ActionEngine.handleTailorManPopup();
		
		boolean ExpectedResult = true;

		ActionEngine.waitForElementVisibility(MyAccountLink);
		boolean accountDisplay = MyAccountLink.isDisplayed();

		Assert.assertEquals(accountDisplay, ExpectedResult);

	}

	public void CheckLoginAndSignUpLinkExistance() {

		MyAccountLink.click();

		boolean ExpectedResult = true;

		ActionEngine.waitForElementVisibility(LoginLink);
		boolean LoginLinkDisplay = LoginLink.isDisplayed();

		boolean signuplinkDisplay = SignUpLink.isDisplayed();

		Assert.assertEquals(LoginLinkDisplay, ExpectedResult);

		Assert.assertEquals(signuplinkDisplay, ExpectedResult);

	}

	public void CheckLoginButtonIsClickableAndAfterClickingLoginIsitRedirectingToCorrectPage() {
		boolean ExpctedResult = true;
		LoginLink.click();

		ActionEngine.waitForElementVisibility(LoginHeading);

		boolean LoginHeadingIsDIsplay = LoginHeading.isDisplayed();

		Assert.assertEquals(LoginHeadingIsDIsplay, ExpctedResult);

	}

	public void SignUpLinkIsWorking() {
		boolean ExpectedResult = true;
		MyAccountLink.click();
		ActionEngine.waitForElementVisibility(SignUpLink);
		SignUpLink.click();
		ActionEngine.waitForElementVisibility(RegistrationLink);

		boolean RegistrationDisplay = RegistrationLink.isDisplayed();

		Assert.assertEquals(RegistrationDisplay, ExpectedResult);

	}

	public void CheckAfterLoginProfileLinkExistance() {
		boolean expectedResult = true;
		MyAccountLink.click();
		ActionEngine.waitForElementVisibility(LoginLink);
		LoginLink.click();
		ActionEngine.waitForElementVisibility(LoginHeading);
		userNameField.sendKeys(pathManager.config.getPropertyFileValue("userNameWebsite"));
		passwrodField.sendKeys(pathManager.config.getPropertyFileValue("passwordWebsite"));
		LoginButton.click();
		MyAccountLink.click();
		ActionEngine.waitForElementVisibility(profileLink);

		boolean profileIsDisplay = profileLink.isDisplayed();

		Assert.assertEquals(profileIsDisplay, expectedResult);

	}
	
	public void checkProfileLinkWorking()
	{
		boolean expectedResult = true ; 
		
		profileLink.click();
		
		ActionEngine.waitForElementVisibility(AccountHeading);
		
	  boolean AccountHeadingExistance =	AccountHeading.isDisplayed();
	  
	  Assert.assertEquals(AccountHeadingExistance, expectedResult);
	}

	public void CheckSignOutFunctionalityIsWorking() {
		boolean expectedResult = true;
		
		ActionEngine.waitForElementVisibility(MyAccountLink);

		MyAccountLink.click();
		ActionEngine.waitForElementVisibility(signOutLink);	
		signOutLink.click();

		ActionEngine.waitForElementVisibility(LoginHeading);

	 

	

		boolean LoginLinkExistance = LoginHeading.isDisplayed();

		Assert.assertEquals(LoginLinkExistance, expectedResult);

	}
}
