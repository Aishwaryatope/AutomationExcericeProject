package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TestCase18 extends TestBase{

	  @Test(description = "Test Case 18: View Category Products")
	    public void viewCategoryProducts() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyThatCategoriesAreVisibleOnLeftSideBar();
	        verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts();
	        verifyThatUserIsNavigatedToThatCategoryPage();
	    }

	    @Test(priority=1)
	    //Verify that categories are visible on left side bar
	    private void verifyThatCategoriesAreVisibleOnLeftSideBar() {
	        boolean categoriesAreVisible = new HomePage(getDriver())
	                .getCategories()
	                .isDisplayed();
	        Assert.assertTrue(categoriesAreVisible, "Verify that categories are visible on left side bar");
	    }

	    @Test(priority=2)
	    //Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS
	    private void verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts() {
	        String titleTextCenter = new HomePage(getDriver())
	                .womenCategoryClick()
	                .dressCategoryClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(titleTextCenter, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
	    }

	    @Test(priority=3)
	    //Verify that user is navigated to that category page
	    private void verifyThatUserIsNavigatedToThatCategoryPage() {
	        String titleTextCenter = new ProductPage(getDriver())
	                .menCategoryClick()
	                .tShirtsCategoryClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(titleTextCenter, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");
	    }
	}

