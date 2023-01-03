import { test } from "@playwright/test";
test.describe.configure({ mode: 'parallel' });
    test('Open Letcode', async({page})=>{
       
        await page.goto('https://letcode.in/');
        await page.click("text=Log in");
        await page.fill("input[name='email']", 'ghoshpritishankar@gmail.com');
        await page.fill("input[name='password']", 'bapi1988');
        await page.click('button:text("LOGIN")')
        await page.click('"Sign out"');
     
    })
