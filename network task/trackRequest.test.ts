import{ chromium, test } from "@playwright/test";
test ("Track all request" , async ({ page }) => {
    const browser = await chromium.launch({
        headless: false
})

    await page.routeFromHAR("har/booksapi.har", {
        update : true
    })
    const context = await browser.newContext();
        const page1 = await context.newPage();
    await page.goto("https://bookcart.azurewebsites.net/" ,{
        waitUntil:"domcontentloaded"
    })
    await context.close();
    await page.waitForTimeout(5000)
})
