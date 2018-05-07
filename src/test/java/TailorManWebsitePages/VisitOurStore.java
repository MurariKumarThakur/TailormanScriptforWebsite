/**
 * 
 */
package TailorManWebsitePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.action.engine.ActionEngine;

/**
 * @author Murari
 *
 */
public class VisitOurStore extends ActionEngine {
	
	
	
	@FindBy(how = How.XPATH , using = "(//span[text()='VISIT OUR STORES'])[2]")
	
	    WebElement visitOurStores ;
	
	
	@FindBy(how = How.XPATH , using = "//h1[text()='OUR STORES']")
	
      WebElement OurStoresText ;

	
	@FindBy(how = How.XPATH , using ="//div[@class='bRWIWF']")
	
	WebElement firstStore ;
	
	
	@FindBy(how = How.XPATH , using = "(//div[@class ='hXzEwR'])[1]")
	
	WebElement StoreName ;
	
	
	@FindBy(how = How.XPATH , using = "//div[@class='storelocationcoutnCls']")
	
	 WebElement StoreNumber ;
	
	@FindBy(how = How.XPATH , using = "//i[contains(@class ,'subscribtion-close')]")
	
	 WebElement SubscribeRemendar ;
	
	
	
	
	
	
	
	
	
	public void VisitOurStoreExistance(String EnterTextName)
	{
		
	ActionEngine.waitForElementVisibility(SubscribeRemendar); 
	SubscribeRemendar.click();
	ActionEngine.verifyElementExistance(visitOurStores, EnterTextName);	
		
	}
	
	public void VisitOurStoreLinkRedirection(String headingText)
	{
	    ActionEngine.waitForElementVisibility(visitOurStores);
		ActionEngine.click(visitOurStores);
		
		ActionEngine.waitForElementVisibility(OurStoresText);
		
		ActionEngine.verifyElementExistance(OurStoresText, headingText );
		
		
		
	}
	
	public void CheckCorrectStoreIsOpeningOrNot()
	{
		
		String beforeClickStoreName = StoreName.getText();
		
		 
		  
		  StoreName.click();
		  
		  
		  ActionEngine.waitForElementVisibility(StoreName);
		  
		  
		 String afterClickStoreName = StoreName.getText();
		 
		   
		   if(beforeClickStoreName.equals(afterClickStoreName))
			   
		   {
			   
			
			 System.out.println(" Correct Store is Opening ");
			   
			   
		   }
		   
		   else 
			   
		   {
			   
			   System.out.println("Correct Store is not Opening ");
			   
		   }
		  
	
		   
		 
		 
		
	}
	
	
	
	
	

}
