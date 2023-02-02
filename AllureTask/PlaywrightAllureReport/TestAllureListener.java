package PlaywrightAllureReport;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.xml.soap.Text;
import java.nio.file.Paths;

public class TestAllureListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebPage", BasePage.getPage());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScrenshot(Page page) {
       return page.screenshot
                (new Page.ScreenshotOptions().setPath(Paths.get("test//screenshot2.png")).setFullPage(false));
    }

        // Text attachments for Allure
        @Attachment(value = "{0}", type = "text/plain")
        public static String saveTextLog (String message){
            return message;
        }

        // HTML attachments for Allure
        @Attachment(value = "{0}", type = "text/html")
        public static String attachHtml (String html){
            return html;
        }


        @Override
        public void onTestStart (ITestResult iTestResult){
            System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        }

        @Override
        public void onTestSuccess (ITestResult iTestResult){
            System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        }

        @Override
        public void onTestFailure (ITestResult iTestResult){
            System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
            Object testClass = iTestResult.getInstance();
            saveScrenshot(BasePage.getPage());

            // Save a log on allure.
            saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
        }

        @Override
        public void onTestSkipped (ITestResult iTestResult){
            System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage (ITestResult iTestResult){
            System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        }

}
