/**
 * 
 */
package com.tailorman.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.action.engine.ActionEngine;

/**
 * @author Murari
 *
 */
public class Cart_page  extends ActionEngine{

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'checkout_button')]")
	WebElement checkOutButton;

	@FindBy(how = How.XPATH, using = "//a[text()='SHOP NOW']")
	WebElement shopNow;

	@FindBy(how = How.XPATH, using = "//div[contains(text() ,'Bag is empty')]")
	WebElement BagIsEmptyMessage;

	@FindBy(how = How.XPATH, using = "//img[contains(@src,'empty-bag-image.png')]")
	WebElement emptyBagImage;

	@FindBy(how = How.XPATH, using = "//span[text()='show all']")
	WebElement showAll;

	public void checkCartLinkIsWorking() {
		
		
		ActionEngine.waitForElementVisibility(checkOutButton);
		checkOutButton.click();

		ActionEngine.waitForElementVisibility(shopNow);

		boolean ExpectedshopNowIsDisplaying = true;
		boolean ActualshopNowIsDisplaying = shopNow.isDisplayed();

		Assert.assertEquals(ActualshopNowIsDisplaying, ExpectedshopNowIsDisplaying);

	}

	public void checkCartSectionElementExistance() {

		ActionEngine.checkElementExistance(emptyBagImage);
		ActionEngine.checkElementExistance(BagIsEmptyMessage);
		ActionEngine.checkElementExistance(shopNow);
	}

	public void checkCartSectionGivenLinkIsWorkingOrNot() {

	  	shopNow.click();

		ActionEngine.waitForElementVisibility(showAll);
		boolean expectedResult = true;
		boolean ActualResult = showAll.isDisplayed();
		Assert.assertEquals(ActualResult, expectedResult);

	}

}
