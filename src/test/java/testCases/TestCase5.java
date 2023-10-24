package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginSignupPage;


public class TestCase5 extends TestBase {
	
	@Test(description = "Test Case 5: Register User with existing email")
	  public void registerUserWithExistingEmail() throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase1.verifyNewUserSignupIsVisible();
	        verifyErrorEmailAddressAlreadyExistIsVisible();
	    }

	    @Test(priority=1)
	    //("Verify error 'Email Address already exist!' is visible")
	    private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
	        String emailAddressAlreadyExistText = new LoginSignupPage(getDriver())
	                .fillIncorrectSignup()
	                .getEmailAddressAlreadyExist()
	                .getText();
	        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
	    }
	}

