package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginSignupPage;


public class TC05_Register_ExistingEmail extends TestBase {
	
	@Test
	//Register User with existing email
	  public void registerUserWithExistingEmail() throws IOException, ParseException {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        TC01_RegisterUser.verifyNewUserSignupIsVisible();
	        verifyErrorEmailAddressAlreadyExistIsVisible();
	    }

	    @Test(priority=1)
	    // Verify error 'Email Address already exist!' is visible.
	    private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
	        String emailAddressAlreadyExistText = new LoginSignupPage(getDriver())
	                .fillIncorrectSignup()
	                .getEmailAddressAlreadyExist()
	                .getText();
	        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
	    }
	}

