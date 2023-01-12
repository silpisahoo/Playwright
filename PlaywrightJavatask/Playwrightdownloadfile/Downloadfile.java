package Playwrightdownloadfile;

import Playwrightsessions.Constants;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Downloadfile {
    Playwrightfactory pf;
    Page page;
    @BeforeClass
    public void setup(){
        pf = new  Playwrightfactory();
        Browser browser = pf.intBrowser("chromium");
        page = browser.newPage();
    }
    @AfterClass
    public void tearDown(){
        page.context().browser().close();
    }
    @Test
    public void downloadFileTest(){
        page.navigate(Constants.DOWNLOAD_URL);
        Download download = page.waitForDownload(() ->{
            page.click(Constants.CHROME_SELECTOR);
        });
        System.out.println(download.url());
        System.out.println(download.page().title());

        String path = download.page().toString();
        System.out.println(path);

        download.saveAs(Paths.get(Constants.ZIPFILE_NAME));
    }
}
