package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utils.Util;
import pages.CartPage;



public class TC15_PlaceOrder_RegBeforeCheckout extends TestBase {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gmail.com";

    @Test
	    public void placeOrderRegisterBeforeCheckout(String name, String email) throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        TC14_PlaceOrder_RegWhileCheckout.verifyAccountCreatedAndClickContinueButton(name, email);
	        TC14_PlaceOrder_RegWhileCheckout.verifyLoggedInAsUsernameAtTop(name);
	        TC14_PlaceOrder_RegWhileCheckout.verifyThatCartPageIsDisplayed();
	        new CartPage(getDriver()).proceedToCheckoutButtonClick();
	        TC14_PlaceOrder_RegWhileCheckout.verifyAddressDetailsAndReviewYourOrder();
	        TC14_PlaceOrder_RegWhileCheckout.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        TC01_RegisterUser.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }
	}


