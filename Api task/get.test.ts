import{expect, test } from '@playwright/test';
test("api put response", async ({request})=>{

    const response = await request.get('https://fakerestapi.azurewebsites.net/api/v1/Activities/20', {
           data: {
            "id": 20,
            "title": "Activity 20",
            "dueDate": "2022-12-22T08:04:27.8408867+00:00",
            "completed": true
          }
       })
       const respBody = JSON.parse(await response.text())
       console.log(respBody)
       expect(respBody.id).toBe(20)
   })