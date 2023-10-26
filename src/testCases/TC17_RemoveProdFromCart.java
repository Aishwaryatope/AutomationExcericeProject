package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;

public class TC17_RemoveProdFromCart extends TestBase{

	@Test
	    public void removeProductsFromCart() {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        TC14_PlaceOrder_RegWhileCheckout.verifyThatCartPageIsDisplayed();
	        verifyThatProductIsRemovedFromTheCart();
	    }

	    @Test(priority=1)
	    //Verify that product is removed from the cart
	    private void verifyThatProductIsRemovedFromTheCart() {
	        String emptyCartText = new CartPage(getDriver())
	                .xButtonClick()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
	    }
	}

