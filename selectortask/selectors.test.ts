import { test, chromium } from "@playwright/test";

    
 //By default whatever code we are going 
 //to write everything should auto
 //here I am going to make this call back function as async

test('Open selectorhub Browser', async() => { // passed a massage 
     const browser = await chromium.launch({  //   Browser proxy option is required for Chromium on Windows.
         //launch going to return us browser instance 
        // Chromium on Windows needs a hint that proxy will be set.
        //To store it we are going to use const here
           headless : false
        })
        const context = await browser.newContext(); //new contest use to open a new browser 
        // we can play multiple browser at same time
        const page = await context.newPage(); // creating a new tab within the browser
        await page.goto('https://selectorshub.com/')
        await page.getByRole('link', { name: 'PracticePage' }).click();
        await page.click("//a[@class ='hfe-menu-item' and text()='PracticePage']")
        await page.type("input[name='email']", 'silpi123@gmail.com')
        await page.type("//input[@name='Password']", "silpi123")
        await page.type("//input[@name='company']", "Atmecs")
        await page.type("//input[@name='mobile number']", "1234567890")
        await page.click("//input[@value='Submit']")
       // await page.pause()
        await page.type("//input[@name='test']", "silpi")
        await page.hover("//div[@class='dropdown']")
        await page.click("//a[text()='SHub Youtube Channel']")
        await page.click("//a[text()='Join Training']")
        await page.click("//a[text()='Try TestCase Studio']")
        await page.waitForTimeout(5000)
        await browser.close()

    })

