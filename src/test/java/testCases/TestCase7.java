package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestCase7 extends TestBase{

      @Test(priority=1)
      //verify test case
	    public void verifyTestCasesPage() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
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

