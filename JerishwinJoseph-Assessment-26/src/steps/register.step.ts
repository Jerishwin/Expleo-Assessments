import{Given,When,Then}from '@cucumber/cucumber'
import {CustomWorld} from '../worlds/customWorld'
import { expect } from '@playwright/test';

Given('the User is on the home page of the application',async function (this:CustomWorld) {
  await this.basepage.navigate()
});

Given('the user clicks the register link',async function (this:CustomWorld) {
  await this.homepage.clickRegister()
});

When('the User fill the valid details in the register page', async function (this:CustomWorld) {
  await this.registerpage.fillDetails()
});

When('clicks the register button',async function (this:CustomWorld) {
  await this.registerpage.clickRegister()
});

Then('registraion completed message should be visible',async function (this:CustomWorld) {
  await expect(this.registerpage.confirmMsg).toContainText("Your registration completed")
});