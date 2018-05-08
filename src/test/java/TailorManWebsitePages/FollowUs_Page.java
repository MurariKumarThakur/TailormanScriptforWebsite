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
public class FollowUs_Page extends ActionEngine {

	@FindBy(how = How.XPATH, using = "//span[text()='FOLLOW US']")

	WebElement followUsLink;

	@FindBy(how = How.XPATH, using = "//span[text()='FACEBOOK']")

	WebElement facebookText;

	@FindBy(how = How.XPATH, using = "//span[text()='FACEBOOK']")

	WebElement INSTAGRAM;

	@FindBy(how = How.XPATH, using = "//span[text()='FACEBOOK']")

	WebElement TWITTER;

	@FindBy(how = How.XPATH, using = "//div[@class='gqlUWZ']")

	WebElement FollowUsHeading;

	@FindBy(how = How.XPATH, using = "//div[@class='gUYTbw']")

	List<WebElement> socialMediaName;
	
	
	@FindBy(how = How.XPATH, using = "//div[text()='FOLLOW US'][@class='gqlUWZ']")

	WebElement FollowUsHeadingText;

	@FindBy(how = How.XPATH, using = "")

	WebElement Name;

	public void checkFollowUsLink()

	{

		String Expected = "FOLLOW US";

		String followUsText = followUsLink.getText();

		Assert.assertEquals(followUsText, Expected);

	}

	public void CheckFollowUsLinkIsClickableOrNot()

	{

		boolean expectedResult = true;
		followUsLink.click();

		ActionEngine.waitForElementVisibility(facebookText);

		boolean facebooklinkDispalying = facebookText.isDisplayed();

		Assert.assertEquals(facebooklinkDispalying, expectedResult);

	}

	public void CheckFollowIsRedirectingCorrectPageOrNot() {

		String expectedResult = "FOLLOW US";

		String followUsHeading = FollowUsHeading.getText();

		Assert.assertEquals(followUsHeading, expectedResult);

	}

	public void checkSocialMediaLinkIsPresentOrNot()

	{

		boolean facebookLink = facebookText.isDisplayed();

		boolean instargramlink = INSTAGRAM.isDisplayed();

		boolean twitterLink = TWITTER.isDisplayed();

		if (facebookLink == true && instargramlink == true && twitterLink == true) {

			System.out.println(" All Social Medial Link is displaying ");

		}
	}
	
       /*
         
        * This  method will switch To on window 
        *  And get title 
        *  and then validate title
        *  and then Close switch window
        *  
      
        */
	public void validateSocialMediaTitle(WebElement socialMediaLink, String expectedTitle) {

		socialMediaLink.click();

		ActionEngine.switchOnWindow();

		String Title = driver.getTitle();

		Assert.assertEquals(Title, expectedTitle);

		driver.close();

	}

	public void checkSocialMediaLinkIsRedirectingOrNot() {
		String facebookExpectedTitle = "TAILORMAN - Home | Facebook";

		String instagramExpectedTitle = "Tailorman (@tailormanindia) • Instagram photos and videos";

		String twitterExpectedTitle = "Tailorman (@tailormanindia) | Twitter";

		validateSocialMediaTitle(facebookText, facebookExpectedTitle);

		validateSocialMediaTitle(INSTAGRAM, instagramExpectedTitle);

		validateSocialMediaTitle(TWITTER, twitterExpectedTitle);

	}
	
	public void validateFollowUsheading()
	{
	
		String  ExpectedHeading = "FOLLOW US";
		
	String ActualHeading =	FollowUsHeadingText.getText();	
	
	  
	 Assert.assertEquals(ActualHeading, ExpectedHeading);
	
		
	}
	

}
