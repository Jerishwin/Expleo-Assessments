import {test,expect} from '../fixtures/fixture'

test.describe("Search Test @smoke",()=>{

    test.beforeEach(async({homepage})=>{
        homepage.navigate()
    })

    test("Search ",async({homepage,searchpage})=>{
        homepage.searching("macbook")

        await expect(searchpage.items).toContainText("MacBook")
    })
})