import {Browser,Page,BrowserContext} from '@playwright/test'
import {setWorldConstructor, World} from '@cucumber/cucumber'
import{BasePage}from '../pages/BasePage'
import { RegisterPage } from '../pages/registerPage';
import {HomePage}from '../pages/homePage'
import { LoginPage } from '../pages/loginPage';

export class CustomWorld extends World{
    browser!:Browser;
    browserContext!:BrowserContext;
    page!:Page;
    basepage!:BasePage
    homepage!:HomePage
    registerpage!:RegisterPage
    loginpage!:LoginPage
  
}
setWorldConstructor(CustomWorld);