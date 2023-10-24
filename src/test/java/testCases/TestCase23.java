package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utils.Util;

public class TestCase23 extends TestBase {

	

	    String name = "name" + Util.generateCurrentDateAndTime();
	    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gmail.com";

	    @Test
	    //Test Case 23: Verify address details in checkout page
	   
	    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
	        TestCase14.verifyLoggedInAsUsernameAtTop(name);
	        TestCase14.verifyThatCartPageIsDisplayed();
	        verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount();
	        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	    @Test(priority=1)
	    		//Verify that the delivery address and the billing address is same address filled at the time registration of account
	    private void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {
	        TestCase14.verifyAddressDetails();
	    }
	}
	


