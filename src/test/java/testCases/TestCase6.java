package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ContactUsPage;

public class TestCase6 extends TestBase {


	//Test Case 6: Contact Us Form
	    
	 @Test
	  
	    public void contactUsForm() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyGetInTouchIsVisible();
	        verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();
	        clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully();
	    }

	    @Test(priority=1)
	   // Verify 'GET IN TOUCH' is visible
	    private void verifyGetInTouchIsVisible() {
	        String getGetInTouchText = new HomePage(getDriver())
	                .contactUsButtonClick()
	                .getGetInTouch()
	                .getText();
	        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "Verify 'GET IN TOUCH' is visible");
	    }

	    @Test(priority=2)
	    //Verify success message 'Success! Your details have been submitted successfully.' is visible
	    private void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
	        String alertSuccessText = new ContactUsPage(getDriver())
	                .fillForm()
	                .submitButtonClick()
	                .okButtonClick()
	                .getAlertSuccess()
	                .getText();
	        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "Verify success message 'Success! Your details have been submitted successfully.' is visible");
	    }

	    @Test(priority=3)
	    		//Click 'Home' button and verify that landed to home page successfully
	    private void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
	        boolean homePageVisible = new ContactUsPage(getDriver())
	                .homePageButtonClick()
	                .homePageIsVisible()
	                .isDisplayed();
	        Assert.assertTrue(homePageVisible, "Click 'Home' button and verify that landed to home page successfully");
	    }
	}


