import{chromium, request, test} from "@playwright/test";
test ("Block images - Network Intercept" , async ({ page }) => {
    const browser = await chromium.launch({
        headless: false
})
    await page.route("**/*", request =>{
        return request.request().url().startsWith("https://googleads.g.doubleclick.net/pagead/ads")
       // return request.request().resourceType() === "image" 
        ? request.abort() : 
        request.continue();
        })
        const context = await browser.newContext();
        const page1 = await context.newPage();
        await page.goto("https://letcode.in/playwright")
   //await page.goto("https://unsplash.com/t/people")
 await page.waitForTimeout(5000); // just to show the output
})