package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utils.Util;

public class TC23_VerifyAddDetailsInCheckoutPage extends TestBase {

	

	    String name = "name" + Util.generateCurrentDateAndTime();
	    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gmail.com";

	    @Test
	    //Test Case 23: Verify address details in checkout page
	   
	    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        TC14_PlaceOrder_RegWhileCheckout.verifyAccountCreatedAndClickContinueButton(name, email);
	        TC14_PlaceOrder_RegWhileCheckout.verifyLoggedInAsUsernameAtTop(name);
	        TC14_PlaceOrder_RegWhileCheckout.verifyThatCartPageIsDisplayed();
	        verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount();
	        TC01_RegisterUser.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	    @Test(priority=1)
	    		//Verify that the delivery address and the billing address is same address filled at the time registration of account
	    private void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {
	        TC14_PlaceOrder_RegWhileCheckout.verifyAddressDetails();
	    }
	}
	


