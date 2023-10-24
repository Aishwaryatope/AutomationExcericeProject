package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import pages.HomePage;

public class TestCase11 extends TestBase{

	
	    public void verifySubscriptionInCartPage() throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        new HomePage(getDriver()).cartButtonClick();
	        TestCase10.verifyTextSubscription();
	        TestCase10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
	    }
	}

