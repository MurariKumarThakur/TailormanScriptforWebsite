/**
 * 
 */
package TailorManWebsiteScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.action.engine.ActionEngine;

import TailorManWebsitePages.FollowUs_Page;

/**
 * @author Murari Kumar
 *
 */
public class FollowUs extends ActionEngine {

	@Test(priority = 1)
	public void checkFollowUsLinkExistance() {

		FollowUs_Page followUsLinkExistance = PageFactory.initElements(driver, FollowUs_Page.class);

		followUsLinkExistance.checkFollowUsLink();

	}

	@Test(priority = 2)
	public void CheckFollowUsLinkIsClickableOrNot()

	{

		FollowUs_Page checkFollowUsLinkClickable = PageFactory.initElements(driver, FollowUs_Page.class);

		checkFollowUsLinkClickable.CheckFollowUsLinkIsClickableOrNot();

	}

	@Test(priority = 3)
	public void CheckFollowUsLinkIsRedirectingCorrectPageOrNot() {

		FollowUs_Page followUsLinkIsRedirectingCorrectPageOrNot = PageFactory.initElements(driver, FollowUs_Page.class);

		followUsLinkIsRedirectingCorrectPageOrNot.CheckFollowUsLinkIsClickableOrNot();

	}

	@Test(priority = 4)
	public void checkSocialMediaLinkIsPresentOrNot() {

		FollowUs_Page CheckLinkIsPresentOrNot = PageFactory.initElements(driver, FollowUs_Page.class);

		CheckLinkIsPresentOrNot.CheckFollowUsLinkIsClickableOrNot();

	}

	@Test(priority = 5)
	public void checkSocialMediaLinkIsRedirectingOrNot() {

		FollowUs_Page checkSocialMediaLinkRedirection = PageFactory.initElements(driver, FollowUs_Page.class);

		checkSocialMediaLinkRedirection.checkSocialMediaLinkIsRedirectingOrNot();
		

	}
	
	@Test(priority=6)
	public void validateFollowUsheading()
	{
		
		FollowUs_Page checkHeading = PageFactory.initElements(driver, FollowUs_Page.class);

		checkHeading.validateFollowUsheading();	
		
		
	}
	

}
