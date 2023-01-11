package Playwrightsessions;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class DownloadFile {
    Page page;
    @BeforeClass
    public void setup(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }
    @AfterClass
    public void tearDown(){
        page.context().browser().close();
    }
    @Test
    public void downloadFileTest(){
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");
        Download download = page.waitForDownload(() ->{
            page.click("a:text('chromedriver_win32.zip')");
                });
        System.out.println(download.url());
        System.out.println(download.page().title());

        String path = download.page().toString();
        System.out.println(path);

        download.saveAs(Paths.get("xyz.zip"));
    }
}
