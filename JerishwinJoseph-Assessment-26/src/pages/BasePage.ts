import {Locator,Page} from '@playwright/test'

export class BasePage{
    readonly page:Page
    constructor(page:Page){
        this.page = page
    }

    async click(element:Locator){
        await element.click()
    }

    async fill(element:Locator,string:string){
        await element.fill(string)
    }

    async navigate(){
        await this.page.goto("https://demowebshop.tricentis.com/",{
            waitUntil: "domcontentloaded",
            timeout: 30000
        })
    }
}
