/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.DesignYourOwn_page;

/**
 * @author Murari
 *
 */
public class DesignYourOwn extends ActionEngine {
	
	
	
	
	
	@Test(priority=1)
	public void CheckDesignYourOwnSectionMouseOverIsWorkingOrNot()
	{
		
		DesignYourOwn_page MouseOverOnDesignYourOwn =	PageFactory.initElements(driver, DesignYourOwn_page.class);
				
				MouseOverOnDesignYourOwn.CheckDesignYourOwnSectionMouseOverIsWorkingOrNot();
		 
		
	}
	@Test(priority=2)
	public void verifyDesignYourOwnMainHeading()
	{
		

		DesignYourOwn_page verifyDesignYourOwnSectionHeading =	PageFactory.initElements(driver, DesignYourOwn_page.class);
				
		verifyDesignYourOwnSectionHeading.verifyDesignYourOwnMainHeading();
		 	
		
	}
	@Test(priority=3)
	public void checkReadyToDesignSectionAllSuiteLinkIsWorkingOrNot()
	{
		
		DesignYourOwn_page verifyDesignYourOwnSectionHeading =	PageFactory.initElements(driver, DesignYourOwn_page.class);
		
		verifyDesignYourOwnSectionHeading.checkReadyToDesignSectionAllSuiteLinkIsWorkingOrNot();
		
		
		
	}

}
