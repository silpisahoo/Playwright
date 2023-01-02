import{chromium, expect, Page, test } from '@playwright/test';
test.describe.configure({ mode: 'parallel' });
let page: Page;

test.beforeAll(async ({ browser }) => {
  page = await browser.newPage();
});

test.afterAll(async () => {
  await page.close();
});
const computerData = [{
    name : "Comp A",
    manufacture : "Tandy Corporation"
},
{
    name : "Comp B",
    manufacture : "Commodore International"
},
{
    name : "Comp c",
    manufacture : "Thinking Machines"
},
{
    name : "Comp D",
    manufacture : "MOS Technology"
}
]
computerData.forEach(data =>{

test(`parameterized test ${data.name}`, async({ })=>{
    // page.on('worker',Worker =>{
    //     Worker.evaluate('alert(),')
    // })

   const browser = await chromium.launch({
       headless : false
   })

   const context = await browser.newContext();
   
   const page = await context.newPage();
    await page.goto("http://computer-database.gatling.io/computers");
    await page.click("#add");
    await page.fill("#name" , data.name);
    //await page.fill("input[name='password']", 'silpi@123');
    await page.selectOption("#company" , {
        label: data.manufacture
})
    await page.click("input[type='submit']");
    //expect(page.locator("div.alert-message.warning")).toContainText("Done")
    
   await browser.close()
})
})