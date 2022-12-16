import { test, chromium, Browser, BrowserContext, Page } from "@playwright/test";
//since we have to use these objects in other block ,so we have declare it here in sweet level
let browser: Browser;
let context: BrowserContext;
let page: Page;


//if we ut all the object inside scope we will be not able
//to use them for further test
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
    //We have to find element and we have to enter name//
    //For that we use function called type,for that We can use loacter and format value
    //Value is your name and we have to pass locater first, here we have used latexpath which has unique id called full name
    //That means we are finding element by id and id value is your name
    await page.type("id=fullName", "silpi sahoo")
  })
  //Inorder to run the code we have to open terminal and type
// npx playwright test filename(On which you are coducting test)