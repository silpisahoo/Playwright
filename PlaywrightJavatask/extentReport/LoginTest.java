package extentReport;
import PlaywrightAllureReport.TestAllureListener;
import Playwrightdownloadfile.Playwrightfactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

@Listeners({TestAllureListener.class})

public class LoginTest {
    public BrowserContext browserContext;
    public  Page page;
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeMethod // this method will be executed before every @test method
    public void setUp(ITestResult result) {
        Playwrightfactory pf = new Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setColorScheme(ColorScheme.DARK));
        reports = ExtentManager.getReport(System.getProperty("user.dir")+"//Reports//");
        test = reports.createTest(result.getMethod().getMethodName());
    }

    @Test()
    public void verifyLoginPageTitleTest() throws IOException {
        test.log(Status.INFO,"Start of the test");
        page = browserContext.newPage();
        page.navigate(Constants.BASE_URL);
        test.log(Status.INFO,"Navigated successfully to the base url");
        Locator sandbox = page.locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
        page.screenshot
                (new Page.ScreenshotOptions().setPath(Paths.get(System.getProperty("user.dir")+"//test//screenshot.png")).setFullPage(true));
        test.log(Status.PASS,"Test completed successfully");
        test.log(Status.INFO,"Screenshot---->"+ test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//test//screenshot.png"));
    }



    @AfterMethod // --this method will be executed after every test method
    public void tearDown() {
        page.context().browser().close();
        if(reports!=null)
            reports.flush();
    }

}

