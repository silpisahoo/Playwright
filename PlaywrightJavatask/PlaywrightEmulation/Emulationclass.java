package PlaywrightEmulation;

import Playwrightdownloadfile.Playwrightfactory;
import Playwrightsessions.Constants;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Emulationclass {
    Playwrightfactory pf;
    Page page;
    BrowserContext context;
    @BeforeClass
    public void setup(){

        pf = new  Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1280, 1024));
        context.grantPermissions(Arrays.asList("notifications"),
                new BrowserContext.GrantPermissionsOptions().setOrigin(Constants.BASE_URL));
        page = context.newPage();
        //page = browser.newPage(new Browser.NewPageOptions().setColorScheme(ColorScheme.DARK)); // or "light"
    }
    @AfterClass
    public void tearDown(){
        context.clearPermissions();
        page.context().browser().close();
    }
    @Test
    public void sandBoxTest() throws InterruptedException {
        page.emulateMedia(new Page.EmulateMediaOptions().setColorScheme(ColorScheme.DARK));

        page.navigate("https://automatenow.io/");

// Resize viewport for individual page
        page.setViewportSize(1000, 800);
        Thread.sleep(3000);
        page.setViewportSize(1280, 1024);
        Locator sandbox = page.locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
    }
}
