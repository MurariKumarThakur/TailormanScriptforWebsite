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

	@FindBy(how = How.XPATH, using = "//span[@class='kUaDtV']")
	WebElement getCategoryNameActiveSection;

	@FindBy(how = How.XPATH, using = "//li[@class='slide selected']")
	List<WebElement> SearchedRecord;

	@FindBy(how = How.XPATH, using = "(//img[@alt='Tailorman Logo'])[2]")
	WebElement tailorManLogo;

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
		tailorManLogo.click();

	}

	public void checkAllCategoryLinkIsWorking(List<WebElement> getNumberOfLinkBasedOnCategory, String methodReturnXpath,
			String passCategoryNameInCapitalLetter) {
		ActionEngine.waitForElementVisibility(DesignYourOwn);
		ActionEngine.mouseOver(DesignYourOwn);
		ActionEngine.waitForElementVisibility(ShirtsHeading);
		int designYourOwnSuiteNum = getNumberOfLinkBasedOnCategory.size();

		for (int i = 1; i <= designYourOwnSuiteNum; i++) {

			String categoryName = methodReturnXpath + "[" + i + "]";

			WebElement getLinkNameOneByOne = driver.findElement(By.xpath(categoryName));

			String LinkName = getLinkNameOneByOne.getText();

			getLinkNameOneByOne.click();

			ActionEngine.waitForElementVisibility(getCategoryNameActiveSection);

			String afterClickGetText = getCategoryNameActiveSection.getText();

			if (afterClickGetText.contains(LinkName.toUpperCase())
					&& afterClickGetText.contains(passCategoryNameInCapitalLetter)) {

				if (SearchedRecord.size() >=1) {
					
					System.out.println("Searched Result Is Coming For "+LinkName);
					
				}

				Assert.assertTrue(afterClickGetText.contains(LinkName.toUpperCase()));
				System.out.println(LinkName + " Link  Is working ");
				ActionEngine.mouseOver(DesignYourOwn);

				ActionEngine.waitForElementVisibility(ShirtsHeading);

			} else if (afterClickGetText.contains(LinkName.toUpperCase())) {

				
				if (SearchedRecord.size() >= 1) {

					
					System.out.println("Searched Result Is Coming For "+LinkName);
				
				

				}
				
				System.out.println(LinkName + " Link  Is working ");
				
				Assert.assertTrue(afterClickGetText.contains(LinkName));

				ActionEngine.mouseOver(DesignYourOwn);

				ActionEngine.waitForElementVisibility(ShirtsHeading);

			}

			else {

				System.out.println(LinkName + " Link  Is Not working  ");
				ActionEngine.mouseOver(DesignYourOwn);

				ActionEngine.waitForElementVisibility(ShirtsHeading);
			}

		}
		tailorManLogo.click();
	}

	public String SuitecategoryLoc() {

		return "(//div[contains(@class,'ltwrapper')]//a[contains(@id,'suits')])";

	}

	public String ShirtcategoryLoc() {

		return "(//div[contains(@class,'ltwrapper')]//a[contains(@id,'shirts')])";

	}

	public String TrousercategoryLoc() {

		return "(//div[contains(@class,'ltwrapper')]//a[contains(@id,'trousers')])";

	}

	public void checkReadyToDesignSectionAllSuiteLinkIsWorkingOrNot() {

		checkAllCategoryLinkIsWorking(GetAllDesignYourOwnSuite, SuitecategoryLoc(), "SUITS");

		checkAllCategoryLinkIsWorking(GetAllDesignYourOwnShirt, ShirtcategoryLoc(), "SHIRTS");

		checkAllCategoryLinkIsWorking(GetAllDesignYourOwnTrouser, TrousercategoryLoc(), "TROUSER");

		
	}

	public void DesignYourOwnShirtAllLinkIsWorkingOrNot() {

	}
}