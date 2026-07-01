import {test, expect } from '@playwright/test';

test("Task3",async({page})=>{

    await page.goto("https://www.bing.com/")
    const title = await page.title()
    const url = await page.url()

    await expect(title).toContain("Bing")
    console.log("Title: "+title)
    await expect(url).toContain("bing")
    console.log("URL: "+url)


    console.log( await page.locator("//div[@class='tools_list']/a[1]").innerText())
    console.log( await page.locator("//div[@class='tools_list']/a[1]").getAttribute('id'))

    await page.getByRole('combobox', { name: 'Enter your search here -' }).fill("playwright ")
    await page.locator('#search_icon > svg').click()
    await page.locator('div').filter({ hasText: 'Playwrighthttps://playwright.' }).nth(1).click()

    console.log(await page.title())

})