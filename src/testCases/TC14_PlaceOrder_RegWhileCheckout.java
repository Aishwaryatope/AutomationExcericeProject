package testCases;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JSONReader;
import Utils.Util;
import pages.AccountCreatedPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LogoutHomePage;
import pages.ProductPage;

public class TC14_PlaceOrder_RegWhileCheckout extends TestBase{

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gamil.com";
    
    
	@Test
	    public void placeOrderRegisterWhileCheckout() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        verifyThatCartPageIsDisplayed();
	        verifyAccountCreatedAndClickContinueButton(name, email);
	        verifyLoggedInAsUsernameAtTop(name);
	        verifyAddressDetailsAndReviewYourOrder();
	        verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        TC01_RegisterUser.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	    @Test(priority=1)
	    		//Verify that cart page is displayed
	    public static void verifyThatCartPageIsDisplayed() {
	        String shoppingCartText = new ProductPage(getDriver())
	                .addProductsToCart()
	                .getShoppingCart()
	                .getText();
	        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
	    }

	    @Test(priority=2)
	    //Verify 'ACCOUNT CREATED!' and click 'Continue' button
	    public static void verifyAccountCreatedAndClickContinueButton(String name, String email) throws IOException, ParseException {
	        String accountCreatedText = new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectSignup(name, email)
	                .fillAccountDetails()
	                .getAccountCreated()
	                .getText();
	        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify 'ACCOUNT CREATED!'");
	        new AccountCreatedPage(getDriver()).continueButtonClick();
	    }

	    @Test(priority=3)
	    //Verify ' Logged in as username' at top
	    public static void verifyLoggedInAsUsernameAtTop(String name) {
	        String username = new LogoutHomePage(getDriver())
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, name, "Verify ' Logged in as username' at top");
	    }

	    @Test(priority=4)
	     //Verify Address Details and Review Your Order
	    public static void verifyAddressDetailsAndReviewYourOrder() throws IOException, ParseException {
	        verifyAddressDetails();

	        List<String> productNames = new CartPage(getDriver()).getProductsNames();
	        List<String> prices = new CartPage(getDriver()).getPrices();
	        List<String> quantity = new CartPage(getDriver()).getQuantity();
	        List<String> totalPrices = new CartPage(getDriver()).getTotalPrices();
	        String totalAmount = new CheckoutPage(getDriver()).getTotalAmount().getText();
	        for (int i = 0; i < 2; i++) {
	            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify Review Your Order");
	            Assert.assertEquals(quantity.get(i), "1", "Verify Review Your Order");
	        }

	        Assert.assertEquals(productNames.get(0), "Blue Top", "Verify Review Your Order");
	        Assert.assertEquals(productNames.get(1), "Men Tshirt", "Verify Review Your Order");
	        Assert.assertEquals(totalAmount, "Rs. 900", "Verify Review Your Order");
	    }

	    @Test(priority=5)
	    public static void verifyAddressDetails() throws IOException, ParseException{
	        List<String> addressDelivery = new HomePage(getDriver())
	                .cartButtonClick()
	                .proceedToCheckoutLoggedButtonClick()
	                .getAddressDelivery();
	        List<String> addressInvoice = new CheckoutPage(getDriver()).getAddressInvoice();

	        Assert.assertEquals(addressDelivery.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
	        Assert.assertEquals(addressInvoice.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

	        for (int i = 1; i < 8; i++) {
	            Assert.assertEquals(addressDelivery.get(i), addressInvoice.get(i), "Verify Address Details");
	        }

	        String no1 = "Mr. " + JSONReader.accountDetails("firstName") + " " + JSONReader.accountDetails("lastName");
	        String no2 = JSONReader.accountDetails("company");
	        String no3 = JSONReader.accountDetails("address1");
	        String no4 = JSONReader.accountDetails("address2");
	        String no5 = JSONReader.accountDetails("city") + " " + JSONReader.accountDetails("state") + " " + JSONReader.accountDetails("zipcode");
	        String no6 = JSONReader.accountDetails("country");
	        String no7 = JSONReader.accountDetails("mobileNumber");

	        Assert.assertEquals(addressDelivery.get(1), no1, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(2), no2, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(3), no3, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(4), no4, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(5), no5, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(6), no6, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(7), no7, "Verify Address Details");
	    }

	    @Test(priority=6)
	    //Verify success message 'Congratulations! Your order has been confirmed!'
	    public static void verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed() throws IOException, ParseException {
	        String alertSuccessText = new CheckoutPage(getDriver())
	                .enterComment("my order is timing delivering to me")
	                .fillPaymentDetails()
	                .getSuccessMessage()
	                .getText();
	        Assert.assertEquals(alertSuccessText, "Congratulations! Your order has been confirmed!", "Verify success message 'Congratulations! Your order has been confirmed!'");
	    }
	}



