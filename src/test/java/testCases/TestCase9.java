package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertiesLoader;
import pages.ProductPage;

public class TestCase9 extends TestBase{
	
	 static String search;

	    static {
	        try {
	            search = PropertiesLoader.loadProperty("search.product.input");
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Test(description = "Test Case 9: Search Product")
	    

		public void searchProduct() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        verifySearchedProductsIsVisible();
	        verifyAllTheProductsRelatedToSearchAreVisible();
	    }

	    @Test(priority=1)
	    //Verify 'SEARCHED PRODUCTS' is visible")
	    public static void verifySearchedProductsIsVisible() {
	        String searchedProductsText = new ProductPage(getDriver())
	                .fillSearchProductInput(search)
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");
	    }

	    @Test(priority=2)
	    //Verify all the products related to search are visible")
	    public static List<String> verifyAllTheProductsRelatedToSearchAreVisible() {
	        List<String> productsNames = new ProductPage(getDriver()).getProductsSearchNames();

	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
	            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
	        }
	        return productsNames;
	    }
	}


