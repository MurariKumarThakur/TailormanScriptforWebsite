/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.MyAccount_page;

/**
 * @author Murari
 *
 */
public class MyAccount extends ActionEngine {

	@Test(priority = 1)
	public void checkMyAccountExistance() {

		MyAccount_page myAccountExistance = PageFactory.initElements(driver, MyAccount_page.class);

		myAccountExistance.MyAccountLinkExistance();

	}

	@Test(priority = 2)
	public void CheckLoginAndSingUpLinkExistance()

	{

		MyAccount_page checkLoginAndSignUpLinkExistance = PageFactory.initElements(driver, MyAccount_page.class);

		checkLoginAndSignUpLinkExistance.CheckLoginAndSignUpLinkExistance();

	}

	@Test(priority = 3)
	public void CheckLoginButtonIsClickableAndAfterClickingLoginIsitRedirectingToCorrectPage() {

		MyAccount_page checkLoginLinkisWorkingOrNot = PageFactory.initElements(driver, MyAccount_page.class);

		checkLoginLinkisWorkingOrNot.CheckLoginButtonIsClickableAndAfterClickingLoginIsitRedirectingToCorrectPage();

	}

	@Test(priority = 4)
	public void SignUpLinkIsWorking() {

		MyAccount_page SignUpLinkWorkingOrNot = PageFactory.initElements(driver, MyAccount_page.class);

		SignUpLinkWorkingOrNot.SignUpLinkIsWorking();

	}

	@Test(priority = 5)
	public void CheckAfterLoginProfileLinkExistance()

	{

		MyAccount_page checkProfileLinkExistance = PageFactory.initElements(driver, MyAccount_page.class);

		checkProfileLinkExistance.CheckAfterLoginProfileLinkExistance();

	}

	@Test(priority = 6)
	public void checkProfileLinkWorking() {

		MyAccount_page checkProfileLinkWorking = PageFactory.initElements(driver, MyAccount_page.class);

		checkProfileLinkWorking.checkProfileLinkWorking();

	}

	@Test(priority = 7)
	public void CheckSignOutFunctionalityIsWorking()

	{

		MyAccount_page SignOutFunctionality = PageFactory.initElements(driver, MyAccount_page.class);

		SignOutFunctionality.CheckSignOutFunctionalityIsWorking();

	}

}
