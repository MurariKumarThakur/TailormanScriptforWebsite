/**
 * 
 */
package com.tailorman.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.action.engine.ActionEngine;

/**
 * @author Murari
 *
 */
public class Login_page extends ActionEngine {
	
	@FindBy(how = How.XPATH , using="//div[text()='LOGIN']")
	WebElement LoginHeading ;
	
	@FindBy(how =How.XPATH , using ="//a[@class='facebook jKCQvr']")
	WebElement facebookLink ;
	
	
	@FindBy(how =How.XPATH , using ="//a[@class='google dIgkkV']")
	WebElement googleLink ;
	

	
	@FindBy(how = How.XPATH, using = "//div[@class='ui fluid input']//input[@type='text']")
	WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement passwrodField;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	WebElement LoginButton;
	
	

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
 
	

	@FindBy(how = How.XPATH, using = "//span[text()='Log in to Facebook']")
	WebElement facebookLoginHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='Sign in with Google']")
	WebElement SignInWithGoogle;
	
	

	public void redirectToLoginPage()
	{
		
	  ActionEngine.waitForElementVisibility(MyAccountLink);	
	  MyAccountLink.click();
	  ActionEngine.waitForElementVisibility(LoginLink);
	  LoginLink.click();
	  ActionEngine.waitForElementVisibility(LoginHeading);
	  
		
	}
	
	  public void checkLoginPageFieldExistance()
	  {
		  
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
	  
	  public void checkAllLinkIsClickableOrNot()
	  {
		  
		  ActionEngine.checkElementIsClickableOrNot(facebookLink,facebookLoginHeading );
		  ActionEngine.navigateBack();
		  ActionEngine.checkElementIsClickableOrNot(googleLink,SignInWithGoogle );
		  ActionEngine.navigateBack();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
