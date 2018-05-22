/**
 * 
 */
package com.tailorman.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.path.manager.pathManager;

/**
 * @author Murari
 *
 */
public class SearchBox_Page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//a[@id='tm_header_search_button']")
	WebElement SearchBox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'searchClass open-visible')]")
	WebElement SearchBoxInput;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search')]")
	WebElement placeholderForSearchBox;

	@FindBy(how = How.XPATH, using = "//h1[text()='No products']")
	WebElement NoProducts;

	@FindBy(how = How.XPATH, using = "//h1[text()='No products']")
	List<WebElement> NoProductsSize;

	@FindBy(how = How.XPATH, using = "//img[@class='ui centered image fCwhdQ']")
	WebElement ClickOnLogo;

	

	@FindBy(how = How.XPATH, using = "//li[@class='slide selected']")
	WebElement ResultValidation;

	public void checkSearchBoxExistance() {

		

		boolean ExpectedResult = true;
		boolean ActualResult = SearchBox.isDisplayed();

		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	public void checkSearchBoxInputDisplayingOrNot() {
		
		ActionEngine.waitForElementVisibility(SearchBox);
		
		SearchBox.click();

		boolean ExpectedResult = true;
		boolean ActualResult = SearchBoxInput.isDisplayed();

		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	public void verifyplaceholder() {

		boolean expectedResult = true;

		boolean placeHodlerDisplaying = placeholderForSearchBox.isDisplayed();

		Assert.assertEquals(expectedResult, placeHodlerDisplaying);

	}

	public void CheckUserIsAbleToTypeOrNot() {
		String value = "Murari";
		placeholderForSearchBox.sendKeys(value);

		String afterEnteringData = placeholderForSearchBox.getAttribute("value");

		Assert.assertEquals(value, afterEnteringData);

	}

	public void applicationResponseIfResultIsNotMatching() {

		SearchBox.click();

		String ExpectedText = "No Products";

		String ActualText = NoProducts.getText();

		Assert.assertEquals(ActualText, ExpectedText);

		ClickOnLogo.click();

	}

	public void CheckSearchBoxSearchBySkuNumber() {

		String sheetName = "SearchCriteria";

		// System.out.println(pathManager.storeData.TotalRowNumber(sheetName));

		for (int i = 1; i <= pathManager.storeData.TotalRowNumber(sheetName); i++) {

			String skuNumber = pathManager.storeData.getColumeWiseData(sheetName, "Search By SkU Number", i);

			// System.out.println(skuNumber);

			SearchBox.click();

			placeholderForSearchBox.sendKeys(skuNumber);

			SearchBox.click();

			// ActionEngine.waitForElementVisibility(searchedResult);

			boolean ExpectedResult = true;

			ActionEngine.waitForElementVisibility(ResultValidation);

			boolean ActulaResult = ResultValidation.isDisplayed();

			Assert.assertEquals(ActulaResult, ExpectedResult);

			ClickOnLogo.click();

		}

	}

	public void CheckSearchBoxSearchByName() {

		String sheetName = "SearchCriteria";

		for (int i = 1; i <= pathManager.storeData.TotalRowNumber(sheetName); i++) {

			String productName = pathManager.storeData.getColumeWiseData(sheetName, "Search By product Name", i);
			SearchBox.click();
			placeholderForSearchBox.sendKeys(productName);

			SearchBox.click();

			// ActionEngine.waitForElementVisibility(searchedResult);

			boolean ExpectedResult = true;

			ActionEngine.waitForElementVisibility(ResultValidation);

			boolean ActulaResult = ResultValidation.isDisplayed();

			Assert.assertEquals(ActulaResult, ExpectedResult);

			ClickOnLogo.click();

		}

	}

	public void CheckSearchBoxSearchByProductCategory() {

		String sheetName = "SearchCriteria";

		for (int i = 1; i <= pathManager.storeData.TotalRowNumber(sheetName); i++) {

			String CategoryName = pathManager.storeData.getColumeWiseData(sheetName, "Search by Category", i);
			SearchBox.click();
			placeholderForSearchBox.sendKeys(CategoryName);

			SearchBox.click();

			// ActionEngine.waitForElementVisibility(searchedResult);

			boolean ExpectedResult = true;

			ActionEngine.waitForElementVisibility(ResultValidation);

			boolean ActulaResult = ResultValidation.isDisplayed();

			Assert.assertEquals(ActulaResult, ExpectedResult);

			ClickOnLogo.click();

		}

	}
}
