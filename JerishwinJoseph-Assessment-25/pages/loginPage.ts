import type{Page,Locator} from '@playwright/test'

export class LoginPage{
    readonly page:Page
    readonly email:Locator
    readonly pass:Locator
    readonly loginButton:Locator
    readonly confirmMsg:Locator
    readonly errorMsg:Locator

    constructor(page:Page){
        this.page=page
        this.email= page.getByRole('textbox', { name: 'E-Mail Address' })
        this.pass=page.getByRole('textbox', { name: 'Password' })
        this.loginButton = page.getByRole('button', { name: 'Login' })
        this.confirmMsg = page.locator('#content').getByRole('heading', { name: 'My Account' })
        this.errorMsg = page.getByText('Warning: No match for E-Mail')
    }

    async login(email:string,pass:string){
        await this.email.fill(email)
        await this.pass.fill(pass)
        await this.loginButton.click()
    }
}