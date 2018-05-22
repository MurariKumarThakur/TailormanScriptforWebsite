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
public class Registration_page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'classic-user')][text()='MY ACCOUNT']")
	WebElement MyAccountLink;

	@FindBy(how = How.XPATH, using = "(//span[text()='SIGN UP'])[2]")
	WebElement SignUpLink;

	@FindBy(how = How.XPATH, using = "//div[text()='REGISTRATION']")
	WebElement RegistrationLink;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_name')]")
	WebElement Name_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_email')]")
	WebElement email_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_phone')]")
	WebElement phone_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_pincode')]")
	WebElement pin_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_address_line_1')]")
	WebElement addressLineOne;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_address_line_2')]")
	WebElement addressLineTwo;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_city')]")
	WebElement city_Reg_Field;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'registration_country')]//input")
	WebElement country_Reg_Field;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'registration_states')]//input")
	WebElement state_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'registration_landmark')]")
	WebElement landmark_Reg_Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'referral_code')]")
	WebElement refferral_Reg_Field;

	@FindBy(how = How.XPATH, using = "//button[text()='REGISTER']")
	WebElement RegisterButton;

	@FindBy(how = How.XPATH, using = "//div[text()='error']")
	List<WebElement> errorMessage;

	@FindBy(how = How.XPATH, using = "//div[text()='success']")
	WebElement successMessage;

	public void redirectToRegistrationPage() {

		

		ActionEngine.waitForElementVisibility(MyAccountLink);

		MyAccountLink.click();

		ActionEngine.waitForElementVisibility(SignUpLink);

		SignUpLink.click();
		ActionEngine.waitForElementVisibility(RegistrationLink);

	}

	public void verifyRegistrationFieldExistance() {
		redirectToRegistrationPage();
		ActionEngine.checkElementExistance(Name_Reg_Field);

		ActionEngine.checkElementExistance(phone_Reg_Field);

		ActionEngine.checkElementExistance(email_Reg_Field);

		ActionEngine.checkElementExistance(addressLineOne);

		ActionEngine.checkElementExistance(addressLineTwo);

		ActionEngine.checkElementExistance(pin_Reg_Field);

		ActionEngine.checkElementExistance(city_Reg_Field);

		ActionEngine.checkElementExistance(state_Reg_Field);

		ActionEngine.checkElementExistance(country_Reg_Field);

		ActionEngine.checkElementExistance(landmark_Reg_Field);

		ActionEngine.checkElementExistance(refferral_Reg_Field);
	}

	public void checkUserIsAbleToEnterDataOrNot(WebElement elm) {
		String data = "Murari";
		ActionEngine.waitForElementVisibility(elm);
		String expectedResult = data;
		elm.click();
		elm.sendKeys(data);
		String inputSectionValueIs = ActionEngine.getAttributeValue(elm, "value");
		// System.out.println(inputSectionValueIs);
		Assert.assertEquals(inputSectionValueIs, expectedResult);

		elm.clear();

	}

	public void checkUserIsAbleToEnterDataOrNotInInputSection() {

		checkUserIsAbleToEnterDataOrNot(Name_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(phone_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(email_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(pin_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(addressLineOne);
		checkUserIsAbleToEnterDataOrNot(addressLineTwo);
		checkUserIsAbleToEnterDataOrNot(city_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(country_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(state_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(landmark_Reg_Field);
		checkUserIsAbleToEnterDataOrNot(refferral_Reg_Field);

	}

	public void verifyRegistrationWithMultipleData() {

		for (int i = 1; i <= pathManager.storeData.TotalRowNumber("RegistrationForm"); i++) {

			ActionEngine.sendKeys(Name_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "Name", i));
			ActionEngine.sendKeys(email_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "Email", i));
			ActionEngine.sendKeys(phone_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "Phone", i));
			ActionEngine.sendKeys(pin_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "pinCode", i));
			ActionEngine.sendKeys(addressLineOne,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "address_One", i));
			ActionEngine.sendKeys(addressLineTwo,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "address_Two", i));
			ActionEngine.sendKeys(city_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "City", i));

			ActionEngine.sendKeys(state_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "State", i));

			ActionEngine.clickOnEnterButton();
			ActionEngine.sendKeys(landmark_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "LandMark", i));
			ActionEngine.sendKeys(refferral_Reg_Field,
					pathManager.storeData.getColumeWiseData("RegistrationForm", "refferalCode", i));
			RegisterButton.click();

			ActionEngine.scrollIntoView(RegistrationLink);

			int size = errorMessage.size();

			if (size == 1) {
				int expectedsize = 1;
				Assert.assertEquals(size, expectedsize);

				System.out.println("Account Not Created Error Message is Displaying ");
			} else {

				boolean expectedMessage = true;

				boolean actualMessage = successMessage.isDisplayed();

				Assert.assertEquals(actualMessage, expectedMessage);

				System.out.println("Account Created  Successfully With Name--[ "
						+ pathManager.storeData.getColumeWiseData("RegistrationForm", "Name", i) + " ] Eamil--[ "
						+ pathManager.storeData.getColumeWiseData("RegistrationForm", "Email", i)
						+ " ] phone Number --[ "
						+ pathManager.storeData.getColumeWiseData("RegistrationForm", "Phone", i) + " ]");

			}
		}

	}

}
