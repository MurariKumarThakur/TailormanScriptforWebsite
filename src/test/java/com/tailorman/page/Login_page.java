/**
 * 
 */
package com.tailorman.page;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.action.engine.ActionEngine;
import com.path.manager.pathManager;

/**
 * @author Murari
 *
 */
public class Login_page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//div[text()='LOGIN']")
	WebElement LoginHeading;

	@FindBy(how = How.XPATH, using = "//a[@id='tm_login_facebook']")
	WebElement facebookLink;

	@FindBy(how = How.XPATH, using = "//a[@id='tm_login_google']")
	WebElement googleLink;

	@FindBy(how = How.XPATH, using = "//input[@id='tm_login_user_name']")
	WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement passwrodField;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	WebElement LoginButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	List<WebElement> LoginButtons;

	@FindBy(how = How.XPATH, using = "//span[text()='Reset Password']")
	WebElement ResetPasswordLink;

	@FindBy(how = How.XPATH, using = "//span[text()='Use OTP']")
	WebElement useOtpLink;

	@FindBy(how = How.XPATH, using = "//button[text()='Register']")
	WebElement RegisterLink;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'classic-user')][text()='MY ACCOUNT']")
	WebElement MyAccountLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='LOGIN'])[2]")
	WebElement LoginLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='LOGIN'])[2]")
	List<WebElement> LoginLinks;

	@FindBy(how = How.XPATH, using = "//span[text()='Log in to Facebook']")
	WebElement facebookLoginHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='Sign in with Google']")
	WebElement SignInWithGoogle;

	@FindBy(how = How.XPATH, using = "//div[text()='REGISTRATION']")
	WebElement RegistrationPage;

	@FindBy(how = How.XPATH, using = "//div[text()='error']")
	WebElement errorMessage;

	@FindBy(how = How.XPATH, using = "//div[text()='success']")
	WebElement successMessage;

	@FindBy(how = How.XPATH, using = "//h4[text()='one time password']")
	WebElement oneTimePassword;

	public void redirectToLoginPage() {

		
		ActionEngine.waitForElementVisibility(MyAccountLink);
		MyAccountLink.click();
		ActionEngine.waitForElementVisibility(LoginLink);
		LoginLink.click();
		ActionEngine.waitForElementVisibility(LoginHeading);

	}

	public void checkLoginPageFieldExistance() {

		redirectToLoginPage();
		ActionEngine.checkElementExistance(LoginHeading);
		ActionEngine.checkElementExistance(facebookLink);
		ActionEngine.checkElementExistance(googleLink);
		ActionEngine.checkElementExistance(userNameField);
		ActionEngine.checkElementExistance(passwrodField);
		ActionEngine.checkElementExistance(LoginButton);
		ActionEngine.checkElementExistance(ResetPasswordLink);
		ActionEngine.checkElementExistance(useOtpLink);
		ActionEngine.checkElementExistance(RegisterLink);

	}

	public void checkAllLinkIsRedirectingToCorrectPageOrNot() {

		ActionEngine.checkElementIsClickableOrNot(facebookLink, facebookLoginHeading);
		ActionEngine.navigateBack();
		ActionEngine.checkElementIsClickableOrNot(googleLink, SignInWithGoogle);
		ActionEngine.navigateBack();
		ActionEngine.checkElementIsClickableOrNot(RegisterLink, RegistrationPage);
		ActionEngine.navigateBack();

		ActionEngine.checkElementIsClickableOrNot(ResetPasswordLink, errorMessage);
		ActionEngine.checkElementIsClickableOrNot(errorMessage, errorMessage);

	}

	public void loginWithMultipleSetOfData() {
		boolean expectedResult = true;
		ActionEngine.waitForElementVisibility(userNameField);
		for (int i = 1; i <= pathManager.storeData.TotalRowNumber("LoginFunction"); i++) {

			ActionEngine.sendKeys(userNameField,
					pathManager.storeData.getColumeWiseData("LoginFunction", "UserName", i));
			
			ActionEngine.sendKeys(passwrodField,

					pathManager.storeData.getColumeWiseData("LoginFunction", "Password", i));
			LoginButton.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int size = LoginButtons.size();

			if (size == 1) {
				boolean loginbutton = LoginButton.isDisplayed();
				Assert.assertEquals(loginbutton, expectedResult);
				System.out.println("Login Not Success");

			} else if (size == 0) {

				System.out.println("Login Success");

				driver.navigate().back();

				ActionEngine.waitForElementVisibility(LoginButton);

			}

		}
	}

	public void checkResetLinkIsWorkingOrNot() {

		// try to check without email

		ActionEngine.waitForElementVisibility(ResetPasswordLink);
		ResetPasswordLink.click();
		ActionEngine.waitForElementVisibility(errorMessage);
		boolean ActualResult = errorMessage.isDisplayed();

		Assert.assertEquals(ActualResult, true);

		// try to check with wrong email

		userNameField.sendKeys("murariraj.one@gmail.Murari");

		ResetPasswordLink.click();

		ActionEngine.waitForElementVisibility(errorMessage);

		boolean errorMessageIsdisplaying = errorMessage.isDisplayed();

		Assert.assertEquals(errorMessageIsdisplaying, true);

		// reset button testing with valid email

		ActionEngine.sendKeys(userNameField, "murariraj.one@gmail.com");

		ResetPasswordLink.click();
		ActionEngine.waitForElementVisibility(successMessage);

		boolean successMessageIsDisplaying = successMessage.isDisplayed();

		Assert.assertEquals(successMessageIsDisplaying, true);

	}

}
