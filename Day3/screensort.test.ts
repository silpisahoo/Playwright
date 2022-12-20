import { test, chromium, Browser, BrowserContext, Page } from "@playwright/test";
//since we have to use these objects in other block ,so we have declare it here in sweet level
let browser: Browser;
let context: BrowserContext;
let page: Page;


//If we put all the object inside scope we will be not able
//to use them for further test
test.beforeAll( async () =>  {
 
//we are trying to launch browser in head mode
  browser= await chromium.launch({
    headless:false
 })

 context = await browser.newContext()
        page = await context.newPage();
        await page.goto("https://letcode.in/elements")
    })

    
    test("Enter Git username", async () => {
         
        //Element lable screenshot
        const header = await page.$("nav[role='navigation']")
       //if header is avalable we have to specify path in optional parameter
        header?.screenshot({ path: "header.png" })
        //finding the username
        const ele = await page.$("input[name='username']")
        await ele?.fill("ortonikc");
        await ele?.press("Enter");
    })
    test("Print all the repos", async () => {
       // Then we are waiting for selector because it is dynamically generated in UI

        await page.waitForSelector("app-gitrepos ol li", { timeout: 5000 })

        //Then we are trying to find multiple elements and we are printing the length
        const repos = await page.$$("app-gitrepos ol li");
        console.log(repos.length);

        const allUrls = await Promise.all(repos.map(async (repo, i) => {
            return await repo.innerText()
        }))
        console.log(allUrls);
        //for full page screen shot
        await page.screenshot({ path: "fs.png", fullPage: true })
    })
    test.afterEach(async () => {
     //After each and every test we have to take screenshot   
    //We have to pass path eithin option
    //It should be async so that we can use await
    //If I use same file name then it will be duplicate
        await page.screenshot({ path: Date.now() + 'screenshot1.png' })
    })
    test.afterAll(async () => {
        await page.close();
        await context.close();
        await browser.close()
    })