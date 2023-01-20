package extentReport;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class Util {
    public static String imagePath= System.getProperty("user.dir")+ "/screeshot/image_"+System.currentTimeMillis()+".png";
    public static void takeScreeshot(Page page){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(imagePath)).setFullPage(true));
    }

}
