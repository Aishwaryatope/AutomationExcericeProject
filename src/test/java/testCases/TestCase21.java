package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailPage;
import pages.ProductPage;

public class TestCase21 extends TestBase {
	
	@Test
	//"Test Case 21: Add review on product")

	    public void addReviewOnProduct() throws IOException, ParseException {
	        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        verifyWriteYourReviewIsVisible();
	        verifySuccessMessageThankYouForYourReview();
	    }

	    @Test(priority=1)
	    //"Verify 'Write Your Review' is visible"
	    private void verifyWriteYourReviewIsVisible() {
	        String writeYourReviewText = new ProductPage(getDriver())
	                .viewProductOfFirstProductButtonClick()
	                .getWriteYourReview()
	                .getText();
	        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
	    }

	    @Test(priority=2)
	    //Verify success message 'Thank you for your review
	    private void verifySuccessMessageThankYouForYourReview() throws IOException, ParseException {
	        String successMessageText = new ProductDetailPage(getDriver())
	                .fillReview()
	                .getSuccessMessage()
	                .getText();
	        Assert.assertEquals(successMessageText, "Thank you for your review.", "Verify success message 'Thank you for your review.'");
	    }
	}
	
	
	
	

