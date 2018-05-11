/**
 * 
 */
package TailorManWebsiteScript;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.action.engine.ActionEngine;

import TailorManWebsitePages.SearchBox_Page;

/**
 * @author Murari ;
 *
 */
public class SearchBox extends ActionEngine {

	@Test(priority = 1)
	public void checkSearchBoxExistance() {

		SearchBox_Page searchBoxExistance = PageFactory.initElements(driver, SearchBox_Page.class);

		searchBoxExistance.checkSearchBoxExistance();

	}

	@Test(priority = 2)
	public void checkSearchBoxInputDisplayingOrNot() {

		SearchBox_Page searchBoxInputFieldIsDisplayed = PageFactory.initElements(driver, SearchBox_Page.class);

		searchBoxInputFieldIsDisplayed.checkSearchBoxInputDisplayingOrNot();

	}

	@Test(priority = 3)
	public void verifyplaceholder() {

		SearchBox_Page verifyPlaceholder = PageFactory.initElements(driver, SearchBox_Page.class);

		verifyPlaceholder.verifyplaceholder();

	}

	@Test(priority = 4)
	public void CheckUserIsAbleToTypeOrNot() {

		SearchBox_Page inputIsTypeableOrNot = PageFactory.initElements(driver, SearchBox_Page.class);

		inputIsTypeableOrNot.CheckUserIsAbleToTypeOrNot();

	}
	@Test(priority =5)
	public void applicationResponseIfResultIsNotMatching()
	{
		SearchBox_Page ApplicationResponseIfResultNotMatching = PageFactory.initElements(driver, SearchBox_Page.class);

		 ApplicationResponseIfResultNotMatching.applicationResponseIfResultIsNotMatching();	
		
	}
	@Test(priority=6)
	public void searchBySkuNumber()
	{
		
		SearchBox_Page SearchBySkuNumber = PageFactory.initElements(driver, SearchBox_Page.class);

		SearchBySkuNumber.CheckSearchBoxSearchBySkuNumber();
		
	}
	@Test(priority=7)
	public void SearchByProductName()
	{
		

		SearchBox_Page SearchByProductName = PageFactory.initElements(driver, SearchBox_Page.class);

		SearchByProductName.CheckSearchBoxSearchByName();
	}
	@Test(priority=8)
	public void SearchByProductCategory()
	{
		

		SearchBox_Page searchByCategory = PageFactory.initElements(driver, SearchBox_Page.class);

		searchByCategory.CheckSearchBoxSearchByProductCategory();
	}

}