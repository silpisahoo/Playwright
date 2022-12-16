import { test, chromium, Browser, BrowserContext, Page } from "@playwright/test";
let browser: Browser;
let context: BrowserContext;
let page: Page;



test.beforeAll( async () =>  {

//we are trying to launch browser in head mode
  browser= await chromium.launch({
    headless:false
 });
//we have created a new context and new page


  context = await browser.newContext()
  page = await context.newPage();

  //We have load the url
  await page.goto("https://letcode.in/edit")
})
//Now we create a test
  test (" Enter your full Name ", async () => {
    
    //Here $ is bassically use to find the locater, It can be Id,name etc
    const name = await page.$("#fullName")
    //Here ? means optional chaining .It will check whether element type is null or not.
    //If not null than we are going to do type action
    await name?.type("silpi sahoo")
  })
  test("Append a text and press keyboard tab", async()=> {

    //So here $ is used to find the element which we can find after inspect the website 
   const join = await page.$("#join")
  
   //Here focus is going to focus on that pertical element.
  await join?.focus();

    //Once the focus has been set. The we are going to keyboard and going to press end 
    // It means it will move the cursor to last right of same line 
   await page.keyboard.press("End")

   //Now we are going to type function .Here human is value and we have to give some space before human
   await join?.type(" Human")
  })