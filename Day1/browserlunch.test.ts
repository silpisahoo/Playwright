import { test, chromium } from "@playwright/test";
    
 //By default whatever code we are going 
 //to write everything should auto
 //here I am going to make this call back function as async

test('Open Letcode', async() => {
    //launch going to return us browser instance
    
    
    //To store it we are going to use const here
        const browser = await chromium.launch({
           headless : false
        })
//new contest use to open a new browser

        const context = await browser.newContext();
        const page = await context.newPage();
        await page.goto('https://letcode.in/')
        await browser.close()
    })