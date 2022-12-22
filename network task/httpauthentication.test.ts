import{
    expect,
    test
} from "@playwright/test";
test ("http authentication" , async ({ browser }) => { // to open thr browser
    const context = await browser.newContext({
        // proxy: {
        //     server: 'http://myproxy.com:3128',
        //     username: 'usr',
        //     password: 'pwd'
        //   }
        httpCredentials: {
            username: "admin",
            password: "admin"

        }
    }) // line no 5-12 creating a browser 
    const page = await context.newPage();
     await page.goto('https://the-internet.herokuapp.com/basic_auth');
     const header = await page.$("h3"); // verify the authenication is correct or not
     if(header){
        console.log(await header.textContent());
        expect(await header.textContent()).toBe("Basic Auth");
     }
    })
