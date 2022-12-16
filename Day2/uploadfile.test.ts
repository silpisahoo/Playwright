import { test, chromium } from "@playwright/test";

test('upload file byusing setinput' , async()=>{

    //const filepath0 = 'C:/Users/silpi.sahoo/Desktop/Playwright/video/ff.txt'; //C:\Users\silpi.sahoo\Desktop\Playwright\video\ff.txt
    const filepath0 = './video/ff.txt';

    const browser = await chromium.launch({
        headless: false
      });

      const context = await browser.newContext();
        const page = await context.newPage();
        await page.goto('https://automatenow.io/');
        await page.getByRole('link', { name: 'Sandbox' }).click();
        await page.getByRole('link', { name: 'File Upload' }).click();
        // Upload fixture.pdf
       // await page.locator('input[name="file-upload"]').setInputFiles(filepath0);
        //await page.setInputFiles("input[name='file-upload']",filepath0).click();
        await page.click("input[name='file-upload']");
        await page.setInputFiles("input[name='file-upload']",filepath0);
        await page.click("//input[@class='wpcf7-form-control has-spinner wpcf7-submit']");
        await page.pause()
})