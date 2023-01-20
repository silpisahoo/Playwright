package extentReport;
import PlaywrightAllureReport.TestAllureListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Listeners({TestAllureListener.class})

public class LoginTest1 {
    public BrowserContext browserContext;
    public  Page page;
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeMethod // this method will be executed before every @test method
    public void setUp(ITestResult result) {
        PlaywrightFactory pf = new PlaywrightFactory();
        page = pf.initBrowser("chromium");
    }

    @Test()
    public void verifyLoginPageTitleTest() throws IOException {
        Locator sandbox = page.locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
        Assert.assertEquals(1,2);

    }



    @AfterMethod // --this method will be executed after every test method
    public void tearDown() {
        page.context().browser().close();
        if(reports!=null)
            reports.flush();
    }

}

