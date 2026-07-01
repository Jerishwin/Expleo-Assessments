import type{Page,Locator} from '@playwright/test'

export class HomePage{
    readonly page:Page
    readonly myAccount: Locator
    readonly register : Locator
    readonly login : Locator
    readonly search:Locator
    readonly searchButton:Locator

    constructor(page:Page){
        this.page=page
        this.myAccount=page.getByRole('link', { name: ' My Account' })
        this.register = page.getByRole('link', { name: 'Register' })
        this.login = page.getByRole('link', { name: 'Login' })
        this.search = page.getByRole('textbox', { name: 'Search' })
        this.searchButton = page.locator('#search').getByRole('button')
    }

    async navigate(){
        await this.page.goto("https://tutorialsninja.com/demo/")
    }

    async gotoRegister(){
        await this.myAccount.click()
        await this.register.click()
    }

    async gotoLogin(){
        await this.myAccount.click()
        await this.login.click()
    }

    async searching(key:string){
        await this.search.fill(key)
        await this.searchButton.click()
    }
}