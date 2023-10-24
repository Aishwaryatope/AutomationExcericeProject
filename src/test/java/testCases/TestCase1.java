package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.Util;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.EnterAccountInformationPage;
import pages.HomePage;
import pages.LoggedHomePage;
import pages.LoginSignupPage;
public class TestCase1 extends TestBase{

    String name = "name" + Util.generateCurrentDateAndTime()+"Aishwarya";
    String email = "email" + Util.generateCurrentDateAndTime() + "aish.tope@gmail.com";
	
	
	public void registerUser() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyNewUserSignupIsVisible();
        verifyThatEnterAccountInformationIsVisible();
        verifyThatAccountCreatedIsVisible();
        verifyThatLoggedInAsUsernameIsVisible();
        verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Test(priority=1)
    //Verify that home page is visible successfully
    public static void verifyThatHomePageIsVisibleSuccessfully() {
        boolean homePageVisible = new HomePage(getDriver())
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "Verify that home page is visible successfully");
    }

    @Test(priority=2)
    //Verify 'New User Signup!' is visible)
    public static void verifyNewUserSignupIsVisible() {
        String newUserSignupText = new HomePage(getDriver())
                .signupLoginClick()
                .getNewUserSignup()
                .getText();
        Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
    }
    
     
    

    @Test(priority=3)
    //Verify that 'ENTER ACCOUNT INFORMATION' is visible
    private void verifyThatEnterAccountInformationIsVisible() {
        String enterAccountInformationText = new LoginSignupPage(getDriver())
                .fillCorrectSignup(name, email)
                .getEnterAccountInformation()
                .getText();
        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    @Test(priority=4)
    //Verify that 'ACCOUNT CREATED!' is visible
    private void verifyThatAccountCreatedIsVisible() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String accountCreatedText = new EnterAccountInformationPage(getDriver())
                .fillAccountDetails()
                .getAccountCreated()
                .getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");
    }

    @Test(priority=5)
    //Verify that 'Logged in as username' is visible
    private void verifyThatLoggedInAsUsernameIsVisible() {
        String username = new AccountCreatedPage(getDriver())
                .continueButtonClick()
                .getUsername()
                .getText();
        Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");
    }

    @Test(priority=6)
    //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    public static void verifyThatAccountDeletedIsVisibleAndClickContinueButton() {
        String accountDeletedText = new LoggedHomePage(getDriver())
                .deleteAccountButtonClick()
                .getAccountDeleted()
                .getText();
        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
        new AccountDeletedPage(getDriver()).continueButtonClick();
    }
}

