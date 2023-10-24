package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestCase24 extends TestBase{

	
	@Test
	//Test Case 24: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
	public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifySubscriptionIsVisible();
        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
    }

    @Test(priority=1)
    //Verify 'SUBSCRIPTION' is visible
    public static void verifySubscriptionIsVisible() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getSubscription());
        boolean subscriptionIsDisplayed = new HomePage(getDriver()).getSubscription().isDisplayed();
        Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
    }

    @Test(priority = 2)
   // Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean fullFledgedTextIsDisplayed = new HomePage(getDriver())
                .scrollUpButtonClick()
                .getFullFledgedPracticeWebsiteForAutomationEngineers()
                .isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        double value = (double) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 2500, "Verify that page is scrolled up");
        System.out.println(value);
    }
}

