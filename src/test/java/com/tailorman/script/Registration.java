/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.Registration_page;

/**
 * @author Murari
 *
 */
public class Registration extends ActionEngine {

	@Test(priority = 1)
	public void verifyRegistrationFieldExistance()

	{

		Registration_page elm_existance = PageFactory.initElements(driver, Registration_page.class);

		elm_existance.verifyRegistrationFieldExistance();
	}

	@Test(priority = 2)
	public void checkUserIsAbleToEnterDataOrNotInInputSection() {
		Registration_page checkUserIsAbleToInsertData = PageFactory.initElements(driver, Registration_page.class);

		checkUserIsAbleToInsertData.checkUserIsAbleToEnterDataOrNotInInputSection();
	}

	@Test(priority = 3)
	public void checkRegistrationFunctionalityWithMulitpleData() {

		Registration_page RegistrationWithMultipleData = PageFactory.initElements(driver, Registration_page.class);

		RegistrationWithMultipleData.verifyRegistrationWithMultipleData();

	}
}
