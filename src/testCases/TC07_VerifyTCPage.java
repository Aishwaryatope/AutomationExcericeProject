package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC07_VerifyTCPage extends TestBase{

      @Test(priority=1)
      //verify test case
	    public void verifyTestCasesPage() {
	        TC01_RegisterUser.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToTestCasesPageSuccessfully();
	    }

	    @Test
	    //Verify user is navigated to test cases page successfully
	    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
	        String testCasesText = new HomePage(getDriver())
	                .testCasesButtonClick()
	                .getTestCases()
	                .getText();
	        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
	    }
	}

