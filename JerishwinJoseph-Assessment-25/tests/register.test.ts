import {test,expect} from '../fixtures/fixture'

test.describe("Register User @smoke",()=>{

    test.beforeEach(async({homepage})=>{
        homepage.navigate()
    })

    test("Registering valid User ",async({homepage,registerpage})=>{
        homepage.gotoRegister()
        registerpage.register("Jerish","Joseph","Jerri24@gmail.com","9944662748","jeri1234")
        await expect(registerpage.confirmMsg).toContainText("Your Account Has Been Created!")
    })
})