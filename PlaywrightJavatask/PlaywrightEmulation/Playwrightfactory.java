package PlaywrightEmulation;

import com.microsoft.playwright.*;

public class Playwrightfactory {

    Playwright playwright;
    Browser browser;
   // BrowserContext browserContext;
   // Page page;
    public Browser intBrowser(String browserName){
        System.out.println("browser name is : " + browserName);
        playwright = Playwright.create();
        switch (browserName){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                break;
        }
        /*browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://automatenow.io/");
        return page;*/
        return browser;
    }
}
