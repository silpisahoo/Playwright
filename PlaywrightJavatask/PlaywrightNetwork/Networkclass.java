package PlaywrightNetwork;

import com.microsoft.playwright.*;

public class Networkclass {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            Browser browser = chromium.launch();
            Page page = browser.newPage();
            page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
            page.onResponse(response -> System.out.println("<<" + response.status() + " " + response.url()));
            page.navigate(Constants.BASE_URL);
            Locator sandbox = page.locator("text = Reviews");
            sandbox.hover();
            sandbox.click();
            System.out.println("RESPONSE AFTER CLICK");
            // Use a glob URL pattern
            Response response = page.waitForResponse("**/api/fetch_data", () -> {
                page.getByText("Home").click();
            });
            page.onResponse(response1 -> System.out.println("<<" + response1.status() + " " + response1.url()));
            browser.close();
        }
    }
}
