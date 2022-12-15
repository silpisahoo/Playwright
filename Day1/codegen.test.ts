import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('https://automatenow.io/');
  await page.getByRole('link', { name: 'Sandbox' }).click();
  await page.getByRole('link', { name: 'JavaScript Delays' }).click();
  await page.getByRole('button', { name: 'Start' }).click();
  await page.getByRole('navigation', { name: 'Top Menu' }).getByRole('link', { name: 'Sandbox' }).click();
  await page.getByRole('heading', { name: 'Sandbox' }).click();
});