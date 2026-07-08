import{Given,When,Then}from '@cucumber/cucumber'
import {CustomWorld} from '../worlds/customWorld'
import { expect } from '@playwright/test';

import{readRegister,user} from '../utils/csvReader'

const users: user[]=readRegister()

const login = users.find(user=>user.type ==='login')

Given('the user clicks the register link',async function (this:CustomWorld) {
    await this.homepage.clickLogin()

});

When('the user fills the email as {string}',async function (this:CustomWorld,string) {
    this.loginpage.fillEmail(string)
});

When('the user fills the password as {string}',async function (this:CustomWorld,string) {
    this.loginpage.fillPass(string)
});

When('clicks the login Button',async function (this:CustomWorld) {
    this.loginpage.clickLogin()
});

Then('the erroe message is shown as {string}',async function (this:CustomWorld,string) {
    if(string==='Please enter a valid email address.'){
        await expect(this.loginpage.errorMsg2).toContainText("Please enter a valid email address.")
    }else if(string==='No customer account found'){
        await expect(this.loginpage.errorMsg1).toContainText("No customer account found")
    }else if(string==='The credentials provided are incorrect'){
        await expect(this.loginpage.errorMsg1).toContainText("The credentials provided are incorrect")
    }
});

When('the user fills the valid credentials',async function (this:CustomWorld) {
    await this.loginpage.fillEmail(login?.email)
    await this.loginpage.fillPass(login?.pass)
});

Then('the user should see mail on home page',async function (this:CustomWorld) {
    await expect(this.homepage.acc).toContainText(login?.email)
});