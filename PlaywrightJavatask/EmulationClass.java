package Playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;


public class EmulationClass {
    Page page;
    BrowserContext context;
    @BeforeClass
    public void setup(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1280, 1024));
        context.grantPermissions(Arrays.asList("notifications"),
                new BrowserContext.GrantPermissionsOptions().setOrigin("https://automatenow.io/"));
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
