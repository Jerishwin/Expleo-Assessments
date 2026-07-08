import {Page, Locator} from "@playwright/test"
import { BasePage } from "./BasePage"
import{readRegister,user} from '../utils/csvReader'

const users: user[]=readRegister()

const register = users.find(user=>user.type ==='register')

export class RegisterPage extends BasePage{

    readonly page:Page
    readonly fname:Locator
    readonly lname:Locator
    readonly email:Locator
    readonly password:Locator
    readonly confirmPassword:Locator
    readonly registerButton:Locator
    readonly confirmMsg:Locator

    constructor(page:Page){
        super(page)
        this.page=page
        this.fname= this.page.getByRole('textbox', { name: 'First name:' })
        this.lname= this.page.getByRole('textbox', { name: 'Last name:' })
        this.email = this.page.getByRole('textbox', { name: 'Email:' })
        this.password = this.page.getByRole('textbox', { name: 'Password:', exact: true })
        this.confirmPassword = this.page.getByRole('textbox', { name: 'Password:', exact: true })
        this.registerButton = this.page.getByRole('button', { name: 'Register' })
        this.confirmMsg = this.page.locator("//div[@class='result']")
    }

    async fillDetails(){
        await this.fill(this.fname,register?.fname)
        await this.fill(this.lname,register?.lname)
        await this.fill(this.email,"jeri" + Date.now()+"@gmail.com")
        await this.fill(this.password,register?.pass)
        await this.fill(this.confirmPassword,register?.pass)
    }

    async clickRegister(){
        await this.click(this.registerButton)
    }

}