package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage{

    public AddressBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(linkText = "Address Book")
    public WebElement addressBook;

    @FindBy(css = "a.btn.btn-default[href*='address/add']")
    public WebElement addNewAddress;

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(id = "input-address-1")
    public WebElement address1;

    @FindBy(id = "input-city")
    public WebElement city;

    @FindBy(id = "input-postcode")
    public WebElement postCode;

    @FindBy(id = "input-country")
    public WebElement country;

    @FindBy(id = "input-zone")
    public WebElement region;

    @FindBy(css = "input[value='Continue']")
    public WebElement continuee;

    @FindBy(css = "div.alert-success")
	public WebElement successAlert;

}
