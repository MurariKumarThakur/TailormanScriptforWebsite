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

	@FindBy(how = How.XPATH, using = "//a[@class='facebook jKCQvr']")
	WebElement facebookLink;

	@FindBy(how = How.XPATH, using = "//a[@class='google dIgkkV']")
	WebElement googleLink;

	@FindBy(how = How.XPATH, using = "//div[@class='ui fluid input']//input[@type='text']")
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
	WebElement erorMessage;

	@FindBy(how = How.XPATH, using = "//h4[text()='one time password']")
	WebElement oneTimePassword;

	public void redirectToLoginPage() {

		ActionEngine.handleTailorManPopup();
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

		ActionEngine.checkElementIsClickableOrNot(ResetPasswordLink, erorMessage);
		ActionEngine.checkElementIsClickableOrNot(erorMessage, erorMessage);

	}

	public void loginWithMultipleSetOfData() {
		boolean expectedResult = true;
		ActionEngine.waitForElementVisibility(userNameField);
		for (int i = 1; i <= pathManager.storeData.TotalRowNumber("LoginFunction"); i++) {

			ActionEngine.sendKeys(userNameField,
					pathManager.storeData.getColumeWiseData("LoginFunction", "UserName", i));
             // System.out.println(pathManager.storeData.getColumeWiseData("LoginFunction", "Password", i));
			ActionEngine.sendKeys(passwrodField,
			   
					pathManager.storeData.getColumeWiseData("LoginFunction", "Password", i));
			LoginButton.click();

			int size = LoginButtons.size();

			if (size == 1) {
				boolean loginbutton = LoginButton.isDisplayed();
				Assert.assertEquals(loginbutton, expectedResult);

			} else {

				System.out.println("LOGIN SUCCESS");
				driver.navigate().back();
				ActionEngine.waitForElementVisibility(LoginButton);

			}

		}
	}

	public void LoginWithMultipleSetOfData() {

	}

}
