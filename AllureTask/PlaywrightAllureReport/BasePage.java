package PlaywrightAllureReport;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.nio.file.Paths;
        import java.util.Properties;
        import java.util.concurrent.TimeUnit;

        import Playwrightdownloadfile.Playwrightfactory;
        import com.microsoft.playwright.Browser;
        import com.microsoft.playwright.BrowserContext;
        import com.microsoft.playwright.Page;
        import com.microsoft.playwright.options.ColorScheme;
        import org.apache.commons.io.FileUtils;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;


public class BasePage {

    public Properties prop;
    public BrowserContext browserContext;
    public static Page page;
    //public static ThreadLocal<Page> tdriver = new ThreadLocal<>();

    public void initialize() {
        Playwrightfactory pf = new Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setColorScheme(ColorScheme.DARK));
        page = browserContext.newPage();
    }

    public static synchronized Page getPage() {
        //return tdriver.get();
        return page;
    }





}