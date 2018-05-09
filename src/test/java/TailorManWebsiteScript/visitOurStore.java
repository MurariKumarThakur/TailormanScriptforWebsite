/**
 * 
 */
package TailorManWebsiteScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;

import TailorManWebsitePages.VisitOurStore;

/**
 * @author Murari
 *
 */
public class visitOurStore extends ActionEngine {

	String visitOurStoresText = "VISIT OUR STORES";

	String OurStoreText = "OUR STORES";

	@Test(priority = 1)
	public void VerifyvisitOurStoreLinkExistance() {
		
	

		VisitOurStore visitOurStoreLinkExit = PageFactory.initElements(driver, VisitOurStore.class);

		visitOurStoreLinkExit.VisitOurStoreExistance(visitOurStoresText);

	}

	@Test(priority = 2)
	public void VisitOurStoreLinkRedirection() {

		VisitOurStore visitOurStoreLinkRedirection = PageFactory.initElements(driver, VisitOurStore.class);

		visitOurStoreLinkRedirection.VisitOurStoreLinkRedirection(OurStoreText);

	}
	
	@Test(priority=3)
	public void checkCorrectStoreIsOpeningOrNot()
	
	{
		
		VisitOurStore locationChecking = PageFactory.initElements(driver, VisitOurStore.class);	
		
	    locationChecking.VerifyCorrectStoreIsOpeningOrNotAndVerifyNumberOfLocation();
		
		
		
	}
	
	
	

}
