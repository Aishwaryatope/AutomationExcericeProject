package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utils.Util;
import pages.CartPage;



public class TestCase15 extends TestBase {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gmail.com";

    @Test(description = "Test Case 15: Place Order: Register before Checkout")
	
	    public void placeOrderRegisterBeforeCheckout(String name, String email) throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
	        TestCase14.verifyLoggedInAsUsernameAtTop(name);
	        TestCase14.verifyThatCartPageIsDisplayed();
	        new CartPage(getDriver()).proceedToCheckoutButtonClick();
	        TestCase14.verifyAddressDetailsAndReviewYourOrder();
	        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }
	}


