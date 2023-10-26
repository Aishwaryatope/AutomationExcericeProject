package testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogoutHomePage;

public class TC04_Logout extends TestBase{

	    @Test(priority=1)
	    // Logout User
	  
	    public void logoutUser() throws IOException, ParseException {
	        TC02_LoginWithValid.loginUserWithCorrectEmailAndPassword();
	        verifyThatUserIsNavigatedToLoginPage();
	    }

	    @Test(priority=2)
	    //Verify that user is navigated to login page
	    private void verifyThatUserIsNavigatedToLoginPage() {
	        String loginToYourAccountText = new LogoutHomePage(getDriver())
	                .logoutButtonClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
	    }
	}
	

