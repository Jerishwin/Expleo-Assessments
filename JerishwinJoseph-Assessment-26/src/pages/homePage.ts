import {Page, Locator} from "@playwright/test"
import { BasePage } from "./BasePage"

export class HomePage extends BasePage{
    readonly page:Page
    readonly registerLink:Locator
    readonly loginLink:Locator
    readonly acc:Locator
    constructor(page:Page){
        super(page)
        this.page=page
        this.registerLink = this.page.locator("//div[@class='header-links']/ul/child::*[1]/a")
        this.loginLink = this.page.locator("//div[@class='header-links']/ul/child::*[2]/a")
        this.acc = this.page.locator("//div[@class='header-links']/ul/li[1]/a")
    }

    async clickLogin(){
        await this.click(this.loginLink)
    }

    async clickRegister(){
        await this.click(this.registerLink)
    }
}