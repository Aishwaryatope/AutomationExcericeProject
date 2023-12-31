package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC10_VerifySubscriptionInHomePage extends TestBase{

	 @Test
	 // Verify Subscription in home page
	    public void verifySubscriptionInHomePage() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        verifyTextSubscription();
	        verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
	    }

	    @Test(priority=1)
	    //Verify text 'SUBSCRIPTION".
	    public static void verifyTextSubscription() {
	        String subscriptionText = new HomePage(getDriver())
	                .getSubscription()
	                .getText();
	        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
	    }

	    @Test(priority=2)
	    //Verify success message 'You have been successfully subscribed!' is visible"
	    public static void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException, ParseException {
	        String messageAlert = new HomePage(getDriver())
	                .fillSubscribe()
	                .getAlertSuccessSubscribe()
	                .getText();
	        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
	    }
	

}

