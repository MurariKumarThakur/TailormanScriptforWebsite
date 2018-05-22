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
public class MadeToMeasure_page extends ActionEngine {

	@FindBy(how = How.ID, using = "tm_header_made_to_measure")
	WebElement MadeToMeasure;

	@FindBy(how = How.XPATH, using = "//div[text()='Made-To-Measure ']")

	WebElement MadeToMeasureText;

	@FindBy(how = How.XPATH, using = "(//div[text()='At Home'])[2]")
	WebElement ATHomeLink;

	@FindBy(how = How.XPATH, using = "(//div[text()='Video Call'])[2]")
	WebElement videoLink;

	@FindBy(how = How.XPATH, using = "(//div[text()='At Our Showrooms'])[2]")
	WebElement AtOurShowrooms;

	@FindBy(how = How.XPATH, using = "//div[@class='headerlink item-menu-cls'][text()='Book A Home visit']")
	WebElement bookAHomeVisitLink;

	@FindBy(how = How.XPATH, using = "//a[@class='tm_book_a_home_visit hero-button']")
	WebElement bookAHomeVisitButton;

	@FindBy(how = How.XPATH, using = "//div[text()='Our Showrooms']")
	WebElement OurShowroomsText;

	public void checkMadeToMeasureLinkIsWorking() {

		

		ActionEngine.waitForElementVisibility(MadeToMeasure);

		ActionEngine.mouseOver(MadeToMeasure);

		ActionEngine.waitForElementVisibility(MadeToMeasureText);

		boolean expectedResult = true;

		boolean ActualMadeToMeasure = MadeToMeasureText.isDisplayed();

		Assert.assertEquals(ActualMadeToMeasure, expectedResult);

	}

	public void MadeToMeasureSectionElementVerification() {

		ActionEngine.mouseOver(MadeToMeasure);
		ActionEngine.checkElementExistance(MadeToMeasure);
		ActionEngine.checkElementExistance(ATHomeLink);
		ActionEngine.checkElementExistance(videoLink);
		ActionEngine.checkElementExistance(AtOurShowrooms);

	}

	public void CheckLinkIsClickableOrNot(WebElement web, WebElement expectedWEb) {
		boolean expectedText = true;
		ActionEngine.mouseOver(MadeToMeasure);

		ActionEngine.waitForElementVisibility(MadeToMeasureText);

		web.click();

		ActionEngine.waitForElementVisibility(expectedWEb);

		boolean actualText = expectedWEb.isDisplayed();

		Assert.assertEquals(actualText, expectedText);

	}

	public void CheckAllGivenLinkIsClickableOrNot() {

		CheckLinkIsClickableOrNot(ATHomeLink, bookAHomeVisitLink);
		CheckLinkIsClickableOrNot(videoLink, bookAHomeVisitButton);
		CheckLinkIsClickableOrNot(AtOurShowrooms, OurShowroomsText);

	}

}
