import{expect, test } from '@playwright/test';
test("api post response", async ({request})=>{
    const response = await request.post('https://fakerestapi.azurewebsites.net/api/v1/Activities', {
        data: {
            "id": 0,
            "title": "string",
            "dueDate": "2022-12-21T11:24:33.451Z",
            "completed": true
          },
    })
    expect(response.status()).toBe(200);
    expect(response.ok()).toBeTruthy();
    console.log(await response.json())
    // const respBody = JSON.parse(await response.text())
    // console.log(respBody)
    // expect(respBody.id).toBe(0)
})