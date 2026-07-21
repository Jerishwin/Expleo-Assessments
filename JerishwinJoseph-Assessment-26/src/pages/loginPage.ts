import {Page, Locator} from "@playwright/test"
import { BasePage } from "./BasePage"

export class LoginPage extends BasePage{
    readonly page:Page
    readonly email:Locator
    readonly pass:Locator
    readonly loginButton:Locator
    readonly errorMsg1:Locator
    readonly errorMsg2:Locator

    constructor(page:Page){
        super(page)
        this.page =page
        this.email = this.page.getByRole('textbox', { name: 'Email:' })
        this.pass =this.page.getByRole('textbox', { name: 'Password:' })
        this.loginButton = this.page.getByRole('button', { name: 'Log in' })
        this.errorMsg1 = this.page.locator("//div[@class='validation-summary-errors']/child::*[2]")
        this.errorMsg2 = this.page.locator("//span[@data-valmsg-for='Email']/span")
    }

    async fillEmail(string:string){
        this.fill(this.email,string)
    }

    async fillPass(string:string){
        this.fill(this.pass,string)
    }

    async clickLogin(){
        this.click(this.loginButton)
    }


}