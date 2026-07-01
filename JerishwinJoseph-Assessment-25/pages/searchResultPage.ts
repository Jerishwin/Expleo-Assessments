import type{Page,Locator} from '@playwright/test'

export class searchResultPage{
    readonly page:Page
    readonly items:Locator

    constructor(page:Page){
        this.page=page
        this.items=page.locator("//div[@class='row']/div/div[@class='product-thumb']/div/div/h4").nth(1)
    }

}