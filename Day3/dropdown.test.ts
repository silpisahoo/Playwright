import { test, chromium, Browser, BrowserContext, Page, expect } from "@playwright/test";
let browser: Browser;
let context: BrowserContext;
let page: Page;


test.beforeAll( async () =>  {
 
  browser= await chromium.launch({
    headless:false
 });


  context = await browser.newContext()
  page = await context.newPage();


  await page.goto("https://letcode.in/dropdowns")
})

//we are going to create a test and it should Asynce,
//After that we will use call back function in which we are going to write actual code 
test ("Select a dropdown based on value", async () =>{

//We have to find dropdown first,Here we will find element 
//Based on that element we will try to do some selection
//In letcode webpage goto to select section and we will try to slect different value based on value index or text using playwright
//After selecting fruit we are going to do accertion as well and after getting id we have to paste
//Store it in variable called fruits
//If element is in select tag then it is dropdown
//In option we have two things first one value and second visible text that appears in dropdown.
const fruit =await page.$("#fruits")

//we are gong to use select option and then within double code that is string we have to pass the 2 
//Reason for passing two is by default select option function select the dropdown based on value

fruit?.selectOption("2");
const msg = await page.$("div.notification.is-success")

if(msg) {
    expect(await msg.textContent()).toContain("Orange")
} 
})

test("Select multiple", async () =>     {
    const heros = await page.$("#superheros");
    heros?.selectOption([
        {label:"Aquaman"}, {value:"bt"}, {index:8}
    ])
})

test("count of the select", async () => {
    const language= await page.$$("#lang")
    console.log(language.length);
})
test("get selected text", async() => {
    const text = await page.$eval<string, HTMLSelectElement>("#country", ele => ele.value);
    console.log(text);
})
   test.afterAll(async ()=> {
    await page.close()
    await context.close()
    await browser.close()
    //since we open browser firstwe will close it in last
   })