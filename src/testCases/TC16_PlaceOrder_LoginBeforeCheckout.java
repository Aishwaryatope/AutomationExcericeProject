package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JSONReader;
import pages.CartPage;
import pages.HomePage;
import pages.LogoutHomePage;

public class TC16_PlaceOrder_LoginBeforeCheckout extends TestBase{
	
	
	 @Test
	 
	  public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
	        verifyLoggedInAsUsernameAtTop();
	        TC14_PlaceOrder_RegWhileCheckout.verifyThatCartPageIsDisplayed();
	        new CartPage(getDriver()).proceedToCheckoutButtonClick();
	        TC14_PlaceOrder_RegWhileCheckout.verifyAddressDetailsAndReviewYourOrder();
	        TC14_PlaceOrder_RegWhileCheckout.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	    }

	  @Test(priority=1)
	    //Verify 'Logged in as username' at top
	    private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
	        String username = new LogoutHomePage(getDriver())
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify 'Logged in as username' at top");
	    }
}
