package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestCase22 extends TestBase{
	
	
	@Test
	   //Test Case 22: Add to cart from Recommended items
	    public void AddToCartFromRecommendedItems() {
	        verifyRecommendedItemsAreVisible();
	        verifyThatProductIsDisplayedInCartPage();
	    }

	    @Test(priority=1)
	    		//Verify 'RECOMMENDED ITEMS' are visible
	    private void verifyRecommendedItemsAreVisible() {
	        String recommendedItemsText = new HomePage(getDriver())
	                .getRecommendedItems()
	                .getText();
	        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
	    }

	    @Test(priority=2)
	    //Verify that product is displayed in cart page
	    private void verifyThatProductIsDisplayedInCartPage() {
	        List<String> productsNames = new HomePage(getDriver())
	                .blueTopAddToCartButtonClick()
	                .viewCartButtonClick()
	                .getProductsNames();
	        Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
	    }
	}

