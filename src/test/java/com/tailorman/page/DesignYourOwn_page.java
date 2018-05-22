/**
 * 
 */
package com.tailorman.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.action.engine.ActionEngine;

/**
 * @author Murari
 *
 */
public class DesignYourOwn_page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//div[text()='DESIGN YOUR OWN'][@class='headerlink item-menu-cls']")
	WebElement DesignYourOwn;

	@FindBy(how = How.XPATH, using = "//div[text()='DESIGN YOUR OWN'][@class='gCkgzh']")
	WebElement DesignYourOwnText;

	@FindBy(how = How.XPATH, using = "//div[text()='SUITS']")
	WebElement SuitsHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='SHIRTS']")
	WebElement ShirtsHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='TROUSERS']")
	WebElement TrousersHeading;

	@FindBy(how = How.XPATH, using = "//div[text()='MORE']")
	WebElement MoreHeading;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ltwrapper')]//a[contains(@id,'suits')]")
	List<WebElement> GetAllDesignYourOwnSuite;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ltwrapper')]//a[contains(@id,'shirts')]")
	List<WebElement> GetAllDesignYourOwnShirt;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ltwrapper')]//a[contains(@id,'trousers')]")
	List<WebElement> GetAllDesignYourOwnTrouser;

	@FindBy(how = How.XPATH, using = "//div[text()='MORE']/following::a")
	List<WebElement> GetAllDesignYourOwnMore;

	@FindBy(how = How.XPATH, using = "//div[@class='active section']")
	WebElement getCategoryNameActiveSection;

	public void CheckDesignYourOwnSectionMouseOverIsWorkingOrNot() {
		boolean DesignYourOwnTextIsDisplaying = true;
		ActionEngine.waitForElementVisibility(DesignYourOwn);
		ActionEngine.mouseOver(DesignYourOwn);
		ActionEngine.waitForElementVisibility(DesignYourOwnText);
		boolean designYourOwnText = DesignYourOwnText.isDisplayed();
		Assert.assertEquals(designYourOwnText, DesignYourOwnTextIsDisplaying);

	}

	public void verifyDesignYourOwnMainHeading() {
		ActionEngine.checkElementExistance(SuitsHeading);
		ActionEngine.checkElementExistance(ShirtsHeading);
		ActionEngine.checkElementExistance(TrousersHeading);
		ActionEngine.checkElementExistance(MoreHeading);
	}

	public void checkReadyToDesignSectionAllSuiteLinkIsWorkingOrNot() {

		int designYourOwnSuiteNum = GetAllDesignYourOwnSuite.size();

		for (int i = 1; i <= designYourOwnSuiteNum; i++) {

			String SuiteLoc = "(//div[contains(@class,'ltwrapper')]//a[contains(@id,'suits')])[" + i + "]";

			WebElement suiteLocOneByOne = driver.findElement(By.xpath(SuiteLoc));

			String SuiteCategoryName = suiteLocOneByOne.getText();

			suiteLocOneByOne.click();

			ActionEngine.waitForElementVisibility(getCategoryNameActiveSection);

			String afterClickGetText = getCategoryNameActiveSection.getText();

			if (afterClickGetText.contains(SuiteCategoryName) && afterClickGetText.contains("Suite"))
			{
				
			  	

			}

		}

	}

}