package PlaywrightAllureReport;
import Playwrightdownloadfile.Playwrightfactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ColorScheme;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})

public class LoginTest {
    public BrowserContext browserContext;
    public  Page page;

    @BeforeMethod // this method will be executed before every @test method
    public void setUp() {
        Playwrightfactory pf = new Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setColorScheme(ColorScheme.DARK));
    }

    @Test(priority = 1, description = "verifying login page title test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    public void verifyLoginPageTitleTest() {
        page = browserContext.newPage();
        page.navigate("https://automatenow.io/");
        Locator sandbox = page.locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
    }



    @AfterMethod // --this method will be executed after every test method
    public void tearDown() {
        page.context().browser().close();
    }

}

