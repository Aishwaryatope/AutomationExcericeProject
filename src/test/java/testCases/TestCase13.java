package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;

public class TestCase13 extends TestBase{
	
	
	  @Test(description = "Test Case 13: Verify Product quantity in Cart")
	    public void verifyProductQuantityInCart() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyProductDetailIsOpened();
	        verifyThatProductIsDisplayedInCartPageWithExactQuantity();
	    }

	    @Test(priority=1)
	    //Verify product detail is opened")
	    private void verifyProductDetailIsOpened() {
	        new HomePage(getDriver()).viewProduct1ButtonClick();
	        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
	    }

	    @Test(priority=2)
	     //Verify that product is displayed in cart page with exact quantity")
	    private void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
	        List<String> quantity = new ProductDetailPage(getDriver()).increaseQuantity("4")
	                .addToCartButtonClick()
	                .viewCartButtonClick().getQuantity();
	        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");
	    }
	}


