import { test, expect } from '../fixtures/fixture'
import { createUser } from '../factories/user.factory'

test.describe("Register User @smoke", () => {
    test.beforeEach(async ({ homepage }) => {
        await homepage.navigate()
    })

    test("Registering valid User", async ({ homepage, registerpage }) => {
        const user = createUser({lastName:"Joseph"})

        await homepage.gotoRegister()
        await registerpage.register(user.firstName, user.lastName, user.email, user.phone, user.password)
        await expect(registerpage.confirmMsg).toContainText("Your Account Has Been Created!")
    })
})