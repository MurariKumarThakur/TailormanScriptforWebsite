/**
 * 
 */
package com.tailorman.script;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;
import com.tailorman.page.MadeToMeasure_page;

/**
 * @author Walkingtree
 *
 */
public class MadeToMeasure extends ActionEngine {
	
	@Test(priority=1)
	public void checkMadeToMeasureLinkIsWorking()
	{
	 MadeToMeasure_page MeasureLinkIsWorking =	PageFactory.initElements(driver, MadeToMeasure_page.class);
	 MeasureLinkIsWorking.checkMadeToMeasureLinkIsWorking();
		
	}
	@Test(priority=2)
	public void MadeToMeasureSectionElementVerification()
	{
		MadeToMeasure_page elmVerification =	PageFactory.initElements(driver, MadeToMeasure_page.class);
		elmVerification.MadeToMeasureSectionElementVerification();
		
	}
	
	@Test(priority=3)
	public void CheckAllGivenLinkIsClickableOrNot()
	{
		
		MadeToMeasure_page checkAllLinkIsClickable =	PageFactory.initElements(driver, MadeToMeasure_page.class);
		checkAllLinkIsClickable.CheckAllGivenLinkIsClickableOrNot();	
		
	}

}
