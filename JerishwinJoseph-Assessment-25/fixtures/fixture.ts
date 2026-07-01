import {test as base,expect} from '@playwright/test'
import { HomePage } from '../pages/homePage'
import {RegisterPage} from '../pages/registerPage'
import {LoginPage}from '../pages/loginPage'
import {searchResultPage}from '../pages/searchResultPage'

type Fixtutes={
    registerpage:RegisterPage
    homepage:HomePage
    loginpage:LoginPage
    searchpage:searchResultPage
}

export const test = base.extend<Fixtutes>({

    homepage:async({page},use)=>{
        await use(new HomePage(page))
    },
    registerpage:async({page},use)=>{
        await use(new RegisterPage(page))
    },
    loginpage:async({page},use)=>{
        await use(new LoginPage(page))
    },
    searchpage:async({page},use)=>{
        await use(new searchResultPage(page))
    }

})

export{expect}

