import { test, chromium } from "@playwright/test";
  test('automateNow', async()=>{
        const browser = await chromium.launch({
           headless : false
        })

        const context = await browser.newContext();
        const page = await context.newPage();
        await page.goto('https://automatenow.io/');
        await page.click("text=Sandbox");
        await page.click("text=Reviews");
        await browser.close()
    })