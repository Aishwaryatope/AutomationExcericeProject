package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Util;
import pages.LoginSignupPage;

public class TestCase3 extends TestBase{

	    @Test(priority=1)
	    //Test Case 3: Login User with incorrect email and password
	
	    public void loginUserWithIncorrectEmailAndPassword() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase2.verifyLoginToYourAccountIsVisible();
	        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
	    }

	    @Test(priority=2)
	    //Verify error 'Your email or password is incorrect!' is visible
	    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
	        String email = "email" + Util.generateCurrentDateAndTime() + "incorrect@gmail.com";
	        String password = "pass" + Util.generateCurrentDateAndTime();

	        String errorLoginText = new LoginSignupPage(getDriver())
	                .fillIncorrectLogin(email, password)
	                .getErrorLogin()
	                .getText();
	        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
	    }
	}


