import { test, chromium } from "@playwright/test";
test('Recorded clip' , async()=>{
const browser = await chromium.launch({
    headless: false
  });
  const context = await browser.newContext({
    recordVideo:{
        dir:"./video/"
        
    }
  });
  const page = await context.newPage();
  await page.goto('https://letcode.in/');
  await page.getByRole('link', { name: 'Log in' }).click();
  await page.getByRole('textbox', { name: 'Enter registered email' }).click();
  await page.getByRole('textbox', { name: 'Enter registered email' }).fill('ghoshpritishankar@gmail.com');
  await page.getByPlaceholder('Enter password').click();
  await page.getByPlaceholder('Enter password').fill('bapi1988');
  await page.getByRole('button', { name: 'LOGIN' }).click();
  await page.getByRole('link', { name: 'Work-Space' }).click();
  await page.getByRole('link', { name: 'All in One' }).click();
  await page.locator('#firstname').click();
  await page.locator('#firstname').fill('Pritishh');
  await page.locator('#lasttname').click();
  await page.locator('#lasttname').fill('Ghosh');
  await page.getByPlaceholder('Email input').click();
  await page.getByPlaceholder('Email input').fill('ghosh@gmail.com');
  await page.getByPlaceholder('Email input').click();
  await page.getByPlaceholder('Phone Number').click();
  await page.getByPlaceholder('Phone Number').fill('88888888');
  await page.getByPlaceholder('Address Line-1').click();
  await page.getByPlaceholder('Address Line-1').fill('baxibazzar');
  await page.getByPlaceholder('Address Line-2').click();
  await page.getByPlaceholder('Address Line-1').click();
  await page.getByPlaceholder('Address Line-1').fill('Baxibazzar');
  await page.getByPlaceholder('Address Line-2').click();
  await page.getByPlaceholder('Address Line-2').fill('Cuttack');
  await page.getByPlaceholder('State').click();
  await page.getByPlaceholder('State').fill('Odisha');
  await page.getByPlaceholder('Postal-Code').click();
  await page.getByPlaceholder('Postal-Code').fill('709090');
  await page.locator('#Date').fill('2009-09-09');
  await page.locator('#male').check();
  await page.getByLabel('I agree to the terms and conditions').check();
  await page.getByRole('button', { name: 'Submit' }).click();
  await page.getByPlaceholder('Phone Number').fill('9090909090');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByPlaceholder('Phone Number').press('ArrowLeft');
  await page.getByRole('button', { name: 'Submit' }).click();
  await page.getByRole('link', { name: 'Sign out' }).click();

  // ---------------------
  await context.close();
  await browser.close();
})