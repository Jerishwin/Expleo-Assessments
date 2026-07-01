import {test,expect} from '../fixtures/fixture'
import {readlogin, user}from '../utils/csvReader'

const users: user[]=readlogin()

const validuser = users.find(user=>user.type ==='valid')
const invalidusers = users.find(user=>user.type==='invalid')


test.describe("Login Tests @regression",()=>{

    test.beforeEach(async({homepage})=>{
        homepage.navigate()
    })

    test("Valid Login",async({homepage,loginpage})=>{

        homepage.gotoLogin()
        if(!validuser){
            throw new Error("User not found")
        }

        loginpage.login(
            validuser?.email,
            validuser?.pass
        )

        await expect(loginpage.confirmMsg).toContainText("My Account")
    })

    test("Invalid email format",async({homepage,loginpage})=>{

        homepage.gotoLogin()
        if(!validuser){
            throw new Error("User not found")
        }
         if(!invalidusers){
            throw new Error("User not found")
        }

        loginpage.login(
            invalidusers?.email,
            validuser?.pass
        )

        await expect(loginpage.errorMsg).toContainText("Warning: No match for E-Mail Address and/or Password.")
    })

    test("Incorrect password",async({homepage,loginpage})=>{

        homepage.gotoLogin()
        if(!validuser){
            throw new Error("User not found")
        }
         if(!invalidusers){
            throw new Error("User not found")
        }

        loginpage.login(
            validuser?.email,
            invalidusers?.pass
        )

        await expect(loginpage.errorMsg).toContainText("Warning: No match for E-Mail Address and/or Password.")
    })
})
