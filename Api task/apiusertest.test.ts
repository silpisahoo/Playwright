import{expect, test } from '@playwright/test';
test("api get response", async ({request})=>{
    const response = await request.get('https://fakerestapi.azurewebsites.net/api/v1/Users', {
    })
    const respBody = JSON.parse(await response.text())
    console.log(respBody)
})
test("apiuser post response", async ({request})=>{
    const response = await request.post('ttps://fakerestapi.azurewebsites.net/api/v1/Users', {
        data: {
            "id": 0,
            "userName": "string",
            "password": "string"
          },
    })
    expect(response.status()).toBe(200);
    expect(response.ok()).toBeTruthy();
    console.log(await response.json())
})
test("apiuser get response1", async ({request})=>{
    const response1 = await request.get('https://fakerestapi.azurewebsites.net/api/v1/Users/2', {
        data: {
            "id": 2,
            "userName": "User 2",
            "password": "Password2"
          },
    })
    expect(response1.status()).toBe(2);
    expect(response1.ok()).toBeTruthy();
    console.log(await response1.json())
})
test("apiuser put response1", async ({request})=>{
    const response1 = await request.put('https://fakerestapi.azurewebsites.net/api/v1/Users/1', {
        data: {
            "id": 1,
            "userName": "silpi",
            "password": "Password"
          },
    })
    expect(response1.status()).toBe(1);
    expect(response1.ok()).toBeTruthy();
    console.log(await response1.json())
})
test("apiuser delete response1", async ({request})=>{
    const response1 = await request.delete('https://fakerestapi.azurewebsites.net/api/v1/Users/55', {
    
})
//const respBody = JSON.parse(await response.text())
console.log(response1)
expect(response1.status()).toBe(200)
})