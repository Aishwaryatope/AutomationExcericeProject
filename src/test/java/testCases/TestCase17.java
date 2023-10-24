package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;

public class TestCase17 extends TestBase{

	@Test(description = "Test Case 17: Remove Products From Cart")
	    public void removeProductsFromCart() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase14.verifyThatCartPageIsDisplayed();
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

