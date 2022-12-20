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
 });
//we have created a new context and new page


  context = await browser.newContext()
  page = await context.newPage();

  //We have load the url
  await page.goto("https://letcode.in/edit")
})
//we are going to create a test
test("Handle dialogs", async ()=>{
    //So here $ is used to find the element which we can find after inspect the website
    //So we ave to go to letcode website and then click on work space and click on alert and inspect
    //And will get a uique id called prompt 
    //It is going to return element and we have to store it 
    
    const element = await page.$("#prompt")
    
    page.on("dialog", (dialog) =>{
      //message is going to return the text that is going to appear in alert
        console.log('Message:' + dialog.message());//In dialog we have message,default value,type and message
        
        console.log('Deafault value: ' + dialog.defaultValue() );//If dialog is prompt, returns default prompt value. Otherwise, returns empty string.
        console.log('Type: ' + dialog.type());
       // If we want to accept anything  use fuction accept
        dialog.accept("Hello silpisahoo");
        //If we want to do dismiss we have fuction called dismiss

       // dialog.dismiss()

     })
    //Now we use click action to bring the dailer
    await element?.click();
    //So use listener first and then trigger the action (click)

})
 //afterAll means after all the test blocks got execute
   //we are going to close the objects
   test.afterAll(async ()=> {
    await page.close()
    await context.close()
    await browser.close()
    //since we open browser firstwe will close it in last
   })