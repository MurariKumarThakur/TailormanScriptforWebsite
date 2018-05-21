/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.Cart_page;

/**
 * @author Murari
 *
 */
public class Cart extends ActionEngine {
	
	
	@Test(priority=1)
	public void checkCartLinkIsWorking()
	{
		
		
	Cart_page checkCartIconIsWorking = PageFactory.initElements(driver, Cart_page.class)	;
	           
	   checkCartIconIsWorking.checkCartLinkIsWorking();
		
	}
	
	@Test(priority=2)
	public void checkCartSectionElementExistance()
	
	{
		
		Cart_page elementExistance = PageFactory.initElements(driver, Cart_page.class)	;
        
		   elementExistance.checkCartSectionElementExistance();	
	 	
		
		
	}
	@Test(priority=3)
	public void checkCartSectionGivenLinkIsWorkingOrNot()
	{

	Cart_page checkGivenLinkIsWorking = PageFactory.initElements(driver, Cart_page.class)	;
    
	checkGivenLinkIsWorking.checkCartSectionGivenLinkIsWorkingOrNot();
	
	}
		
		
		
		
		
	

}
