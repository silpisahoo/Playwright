import { test, chromium } from "@playwright/test";
test('Recorded clip' , async()=>{
const browser = await chromium.launch({
    headless: false
  });
  const context = await browser.newContext({
    recordVideo:{
        dir:"./video/"
        
    }
  });
        const page = await context.newPage();
        await page.goto('https://automatenow.io/');
        await page.click("text=Sandbox");
        await page.click("text=Reviews");
        await browser.close()
});
