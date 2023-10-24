package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JSONReader;
import pages.HomePage;
import pages.LoginSignupPage;

public class TestCase2 extends TestBase{


	    @Test(priority=1)
	    //Test Case 2: Login User with correct email and password
	    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyLoginToYourAccountIsVisible();
	        verifyThatLoggedInAsUsernameIsVisible();
	    }

	    @Test(priority=2)
	    //Verify 'Login to your account' is visible
	    public static void verifyLoginToYourAccountIsVisible() {
	        String loginToYourAccountText = new HomePage(getDriver())
	                .signupLoginClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
	    }

	    @Test(priority=3)
	    //Verify that 'Logged in as username' is visible
	    private static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException, org.json.simple.parser.ParseException {
	        String username = new LoginSignupPage(getDriver())
	                .fillCorrectLogin(JSONReader.existingUser("name"), JSONReader.existingUser("password"))
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");
	    }
	}

