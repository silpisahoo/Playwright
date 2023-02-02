package PlaywrightAllureReport;

import com.microsoft.playwright.Locator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class FailureScreenshotAttachmentTest {

    BasePage basePage;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage();
        basePage.initialize();
    }


    @AfterMethod // --this method will be executed after every test method
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        basePage.getPage().context().browser().close();
    }


    @Test(priority = 1, description = "verifying login page title test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    public void verifyLoginPageTitleTest() {
        basePage.getPage().navigate("https://automatenow.io/");
        Locator sandbox = basePage.getPage().locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
        Assert.assertEquals(1,6);
    }


}