/**
 * 
 */
package TailorManWebsitePages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.action.engine.ActionEngine;

/**
 * @author Murari
 *
 */
public class VisitOurStore extends ActionEngine {

	@FindBy(how = How.XPATH, using = "(//span[text()='VISIT OUR STORES'])[2]")

	WebElement visitOurStores;

	@FindBy(how = How.XPATH, using = "//h1[text()='OUR STORES']")

	WebElement OurStoresText;

	@FindBy(how = How.XPATH, using = "//div[@class='bRWIWF']")

	WebElement firstStore;

	@FindBy(how = How.XPATH, using = "(//div[@class ='hXzEwR'])[1]")

	WebElement StoreName_one;
	
	@FindBy(how = How.XPATH, using = "(//div[@class ='hXzEwR'])[2]")

	WebElement StoreName_two;

	@FindBy(how = How.XPATH, using = "(//div[@class ='hXzEwR'])[4]")

	WebElement AfterClickingStoreName;

	@FindBy(how = How.XPATH, using = "(//div[@class='storelocationcoutnCls'])[1]")

	WebElement StoreNumber_one;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='storelocationcoutnCls'])[2]")

	WebElement StoreNumber_two;

	// div[@class='storelocationcoutnCls']

	@FindBy(how = How.XPATH, using = "//i[contains(@class ,'subscribtion-close')]")

	WebElement SubscribeRemendar;

	@FindBy(how = How.XPATH, using = "//div[contains(@class ,'nine wide')]")

	List<WebElement> afterClickNumOfStore;

	public void VisitOurStoreExistance(String EnterTextName) {

		ActionEngine.waitForElementVisibility(SubscribeRemendar);
		SubscribeRemendar.click();
		ActionEngine.verifyElementExistance(visitOurStores, EnterTextName);

	}

	public void VisitOurStoreLinkRedirection(String headingText) {
		ActionEngine.waitForElementVisibility(visitOurStores);
		ActionEngine.click(visitOurStores);

		ActionEngine.waitForElementVisibility(OurStoresText);

		ActionEngine.verifyElementExistance(OurStoresText, headingText);

	}
	  /* This method  checking after clicking location it is opening same Location or not 
	   *  (if user click on Banglore then it is opening  Bangloare location or not )
	   *  
	   *  and check Number of store information is matching or not before click and after click 
	   * 
	   */
	public void ClickOnLocationAndValidate(WebElement StoreName , WebElement StoreNumber)
	
	{
		String beforeClickStoreName = StoreName.getText();

		String numberofStore = StoreNumber.getText();

		String[] name = numberofStore.split(" ");

		for (int i = 0; i < name.length; i++) {

			if (i == 1) {

				String number = name[i];

				int storeCount = Integer.parseInt(number);

				StoreName.click();

				int afterClickSize = afterClickNumOfStore.size();

				Assert.assertEquals(storeCount, afterClickSize);

			}

		}
	
		ActionEngine.waitForElementVisibility(StoreName);

		String afterClickStoreName = AfterClickingStoreName.getText();

		Assert.assertEquals(beforeClickStoreName, afterClickStoreName, "Both Job Location Address is not matching !!!");
		
	}

	public void VerifyCorrectStoreIsOpeningOrNotAndVerifyNumberOfLocation() {

		ActionEngine.scrollIntoView(firstStore);
		
		  // clicking on first location 
		ClickOnLocationAndValidate(StoreName_one , StoreNumber_one);	
		
		ClickOnLocationAndValidate(StoreName_two , StoreNumber_two);
	}

}
