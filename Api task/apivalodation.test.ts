import{expect, test } from '@playwright/test';
test("api get response", async ({request})=>{
    const response = await request.get('https://fakerestapi.azurewebsites.net/api/v1/Activities', {
    })
    const respBody = JSON.parse(await response.text())
    console.log(respBody)
})

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
test("api get response1", async ({request})=>{

 const response1 = await request.get('https://fakerestapi.azurewebsites.net/api/v1/Activities/20', {
        data: {
  "id": 20,
  "title": "Activity 20",
  "dueDate": "2022-12-22T08:53:10.7149064+00:00",
  "completed": true
},
    })
    const respBody = JSON.parse(await response1.text())
    console.log(respBody)
    expect(respBody.id).toBe(20)
})
test("api update response", async ({request})=>{

    const response = await request.put('https://fakerestapi.azurewebsites.net/api/v1/Activities/1', {
           data: {
            "id": 1,
            "title": "top",
            "dueDate": "2022-12-21T12:51:00.865Z",
            "completed": true
          },
       })
       const respBody = JSON.parse(await response.text())
       console.log(respBody)
       expect(respBody.id).toBe(1)
   })
   test("api delete response", async ({request})=>{

    const response = await request.delete('https://fakerestapi.azurewebsites.net/api/v1/Activities/1', {
           
       })
       //const respBody = JSON.parse(await response.text())
       console.log(response)
       expect(response.status()).toBe(200)
   })