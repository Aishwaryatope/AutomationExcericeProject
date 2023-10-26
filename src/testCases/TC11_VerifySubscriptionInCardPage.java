package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import pages.HomePage;

public class TC11_VerifySubscriptionInCardPage extends TestBase{

	
	    public void verifySubscriptionInCartPage() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        new HomePage(getDriver()).cartButtonClick();
	        TC10_VerifySubscriptionInHomePage.verifyTextSubscription();
	        TC10_VerifySubscriptionInHomePage.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
	    }
	}

