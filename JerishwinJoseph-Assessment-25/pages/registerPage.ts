import type{Page,Locator} from '@playwright/test'

export class RegisterPage{
    readonly page:Page
    readonly firstName:Locator
    readonly lastName:Locator
    readonly email:Locator
    readonly phone:Locator
    readonly pass:Locator
    readonly confirmPass:Locator
    readonly policyCheckBox:Locator
    readonly continueButton:Locator
    readonly confirmMsg:Locator

    constructor(page:Page){
        this.page=page
        this.firstName = page.getByRole('textbox', { name: '* First Name' })
        this.lastName = page.getByRole('textbox', { name: '* Last Name' })
        this.email= page.getByRole('textbox', { name: '* E-Mail' })
        this.phone = page.getByRole('textbox', { name: '* Telephone' })
        this.pass=page.getByRole('textbox', { name: '* Password', exact: true })
        this.confirmPass = page.getByRole('textbox', { name: '* Password Confirm' })
        this.policyCheckBox = page.getByRole('checkbox')
        this.continueButton = page.getByRole('button', { name: 'Continue' })
        this.confirmMsg = page.getByRole('heading', { name: 'Your Account Has Been Created!' })
    }

    async register(firstName:string,lastName:string,email:string,phone:string,pass:string){
        await this.firstName.fill(firstName)
        await this.lastName.fill(lastName)
        await this.email.fill(email)
        await this.phone.fill(phone)
        await this.pass.fill(pass)
        await this.confirmPass.fill(pass)
        await this.policyCheckBox.click()
        await this.continueButton.click()
    }
}