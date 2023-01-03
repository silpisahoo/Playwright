import{Page, test } from '@playwright/test';
test.describe.configure({ mode: 'parallel' });
// let page: Page;

// test.beforeAll(async ({ browser }) => {
//   page = await browser.newPage();
// }); //You can annotate inter-dependent tests as serial. If one of the serial tests fails, 
// //all subsequent tests are skipped. All tests in a group are retried together.

// test.afterAll(async () => {
//   await page.close();
// });
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
computerData.forEach(data =>{ //keep it in a loop

test(`parameterized test ${data.name}`, async({ page })=>{ // parametrized this test case with multiple data 
    // dupicate test  case are not allowed so for this we write ${data.name} so all the test case are unique
    // page.on('worker',Worker =>{
    //     Worker.evaluate('alert(),')
    // })
   

    await page.goto("http://computer-database.gatling.io/computers");
    await page.click("#add");
    await page.fill("#name" , data.name);
    //await page.fill("input[name='password']", 'silpi@123');
    await page.selectOption("#company" , {
        label: data.manufacture
})
    await page.click("input[type='submit']");
    //expect(page.locator("div.alert-message.warning")).toContainText("Done")
    

})
})