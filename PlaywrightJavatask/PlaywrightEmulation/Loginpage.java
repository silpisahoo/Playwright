package PlaywrightEmulation;

import Playwrightdownloadfile.Playwrightfactory;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;

public class Loginpage {
    static Playwrightfactory pf;
    Page page;
    BrowserContext context;
    public static void main(String[] args){
        pf = new  Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
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
