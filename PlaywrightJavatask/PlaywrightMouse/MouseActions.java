package PlaywrightMouse;

import Playwrightdownloadfile.Playwrightfactory;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import com.microsoft.playwright.options.MouseButton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseActions {
    Playwrightfactory pf;
    Page page;
    BrowserContext context;

    @BeforeClass
    public void setup() {
        pf = new Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setColorScheme(ColorScheme.DARK));
        Page page = browserContext.newPage();
    }
        @AfterClass
        public void tearDown () {
            page.context().browser().close();
        }
        @Test
        public void Mousehover () throws InterruptedException {
            page.navigate(Constants.BASE_URL);
            page.mouse().move(900, 40);
           // Thread.sleep(3000);
            page.mouse().click(900, 33);
            //Thread.sleep(3000);
            page.mouse().dblclick(900,42);
            //page.mouse().down();

        }
    }
