import { Before,After,BeforeAll,AfterAll, setDefaultTimeout} from '@cucumber/cucumber'
import{chromium,Browser} from '@playwright/test'
import{CustomWorld}from '../worlds/customWorld'
import{BasePage}from '../pages/BasePage'
import { HomePage } from '../pages/homePage';
import { RegisterPage } from '../pages/registerPage';
import { LoginPage } from '../pages/loginPage';

setDefaultTimeout(60000);
let browser : Browser

BeforeAll(async()=>{
    browser = await chromium.launch({headless:false})
})

Before(async function(this:CustomWorld){
    this.browser=browser
    this.browserContext=await browser.newContext()
    this.page = await this.browserContext.newPage()
    this.basepage = new BasePage(this.page)
    this.homepage = new HomePage(this.page)
    this.registerpage = new RegisterPage(this.page)
    this.loginpage = new LoginPage(this.page)
})

After(async function(this:CustomWorld,scenario){
    if(scenario.result?.status==="FAILED"){
        const path =`report/screenshots/${Date.now()}.png`
        await this.page.screenshot({path})
    }

    await this.page.close()
    await this.browserContext.close()
})


AfterAll(async()=>{
    await browser.close()
})