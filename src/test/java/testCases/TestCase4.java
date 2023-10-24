package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoggedHomePage;

public class TestCase4 extends TestBase{

	    @Test(priority=1)
	    //Test Case 4: Logout User
	  
	    public void logoutUser() throws IOException, ParseException {
	        TestCase2.loginUserWithCorrectEmailAndPassword();
	        verifyThatUserIsNavigatedToLoginPage();
	    }

	    @Test(priority=2)
	    //Verify that user is navigated to login page
	    private void verifyThatUserIsNavigatedToLoginPage() {
	        String loginToYourAccountText = new LoggedHomePage(getDriver())
	                .logoutButtonClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
	    }
	}
	

