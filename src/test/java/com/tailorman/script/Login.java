/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.Login_page;

/**
 * @author Murari 
 *
 */
public class Login extends ActionEngine {
	
	
	@Test(priority=1)
	public void fieldVerificationInLoginpageSection()
	{
		
	Login_page elementExistance = PageFactory.initElements(driver, Login_page.class)	;
	elementExistance.checkLoginPageFieldExistance();
		
		
	}
	@Test(priority =2)
	public void checkAllLinkIsRedirectingToCorrectPageOrNotOrLinkIsClickableOrNot()
	{
		
		Login_page elmIsClickableOrnot = PageFactory.initElements(driver, Login_page.class)	;
		elmIsClickableOrnot.checkAllLinkIsRedirectingToCorrectPageOrNot();	
		
		
	}
	@Test(priority=3)
	public void loginWithMultipleSetOfData()
	{
		
		Login_page loginWithMultipleSet = PageFactory.initElements(driver, Login_page.class)	;
		loginWithMultipleSet.loginWithMultipleSetOfData();
		
	}

}
