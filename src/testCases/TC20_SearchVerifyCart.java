package testCases;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JSONReader;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC20_SearchVerifyCart extends TestBase{
	
	    public void searchProductsAndVerifyCartAfterLogin() throws IOException, ParseException, InterruptedException {
	        TC08_VerifyProductDetails.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        TC09_SearchProduct.verifySearchedProductsIsVisible();
	        List<String> productsNames = TC09_SearchProduct.verifyAllTheProductsRelatedToSearchAreVisible();
	        new ProductPage(getDriver()).addAllProducts();
	        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	        new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
	        verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(productsNames);
	        verifyThatCartIsEmpty();
	    }

	    @Test(priority=1)
	    //Click 'Cart' button and verify that products are visible in cart.
	    private void clickCartButtonAndVerifyThatProductsAreVisibleInCart(@NotNull List<String> productsNames) {
	        List<String> productsNamesAdded = new HomePage(getDriver())
	                .cartButtonClick()
	                .getProductsNames();
	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
	            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
	        }
	    }

	    @Test(priority=2)
	    //Verify that those products are visible in cart after login as well.
	    private void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(@NotNull List<String> productsNames) {
	        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
	    }

	    @Test(priority=3)
	    //Verify 'Cart is empty! Click here to buy products.' is visible
	    private void verifyThatCartIsEmpty() throws InterruptedException {
	        String emptyCartText = new CartPage(getDriver())
	                .deleteAllAddedProducts()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
	    }
	}

