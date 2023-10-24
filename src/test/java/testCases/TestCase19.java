package testCases;

import java.io.IOException;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JSONReader;
import pages.HomePage;
import pages.ProductPage;

public class TestCase19 extends TestBase{

	public void viewCartBrandProducts() throws IOException, ParseException {
        verifyThatBrandsAreVisibleOnLeftSideBar();
        verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed();
        verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts();
    }

	@Test(priority=1)
    //Verify that Brands are visible on left side bar")
    private void verifyThatBrandsAreVisibleOnLeftSideBar() {
        boolean brandsIsDisplayed = new HomePage(getDriver())
                .productsButtonClick()
                .getBrands()
                .isDisplayed();
        Assert.assertTrue(brandsIsDisplayed, "Verify that Brands are visible on left side bar");
    }

    @Test(priority=2)
	//Verify that user is navigated to brand page and brand products are displayed")
    private void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() throws IOException, ParseException {
        String titleTextCenter = new ProductPage(getDriver())
                .poloBrandClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "BRAND - POLO PRODUCTS", "Verify that user is navigated to brand page");

        List<String> productsNames = new ProductPage(getDriver()).getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.poloBrandProducts(String.valueOf(i)), "Verify that brand products are displayed");
        }
    }

    @Test(priority=3)
    //Verify that user is navigated to that brand page and can see products")
    private void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() throws IOException, ParseException {
        String titleTextCenter = new ProductPage(getDriver())
                .madameBrandClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "BRAND - MADAME PRODUCTS", "Verify that user is navigated to that brand page");

        List<String> productsNames = new ProductPage(getDriver()).getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.madameBrandProducts(String.valueOf(i)), "Verify that can see products");
        }
    }
}

