package Playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;

public class LoginPage {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //BrowserContext browserContext = browser.newContext();
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setColorScheme(ColorScheme.DARK));
        Page page = browserContext.newPage();
        page.navigate("https://automatenow.io/");
        Locator sandbox = page.locator("text = Sandbox");
        sandbox.hover();
        sandbox.click();
        page.context().browser().close();
    }
        }
