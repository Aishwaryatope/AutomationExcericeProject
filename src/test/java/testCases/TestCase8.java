package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductPage;

public class TestCase8 extends TestBase{

	
	    public void verifyAllProductsAndProductDetailPage() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        new ProductPage(getDriver()).viewProductOfFirstProductButtonClick();
	        verifyThatDetailDetailIsVisible();
	    }

	    @Test(priority=1)
	    //Verify user is navigated to ALL PRODUCTS page successfully")
	    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
	        String allProductsText = new HomePage(getDriver())
	                .productsButtonClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
	    }

	    @Test(priority=2)
	    //Verify that detail detail is visible: product name, category, price, availability, condition, brand")
	    private void verifyThatDetailDetailIsVisible() {
	        boolean name = new ProductDetailPage(getDriver()).getProductName().isDisplayed();
	        boolean category = new ProductDetailPage(getDriver()).getProductCategory().isDisplayed();
	        boolean price = new ProductDetailPage(getDriver()).getProductPrice().isDisplayed();
	        boolean availability = new ProductDetailPage(getDriver()).getProductAvailability().isDisplayed();
	        boolean condition = new ProductDetailPage(getDriver()).getProductCondition().isDisplayed();
	        boolean brand = new ProductDetailPage(getDriver()).getProductBrand().isDisplayed();

	        Assert.assertTrue(name, "Verify that detail detail is visible: name");
	        Assert.assertTrue(category, "Verify that detail detail is visible: category");
	        Assert.assertTrue(price, "Verify that detail detail is visible: price");
	        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
	        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
	        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
	    }
	}


