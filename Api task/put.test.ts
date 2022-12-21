import{expect, test } from '@playwright/test';
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