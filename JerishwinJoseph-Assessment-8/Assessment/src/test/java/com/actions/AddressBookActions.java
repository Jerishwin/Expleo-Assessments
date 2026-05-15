package com.actions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddressBookPage;

public class AddressBookActions extends BaseAction{
	WebDriverWait wait;
	AddressBookPage ap;
	
    public AddressBookActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
	}

    public void navigateToAddressBook() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.myAccount)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ap.addressBook)).click();
        wait.until(ExpectedConditions.urlContains("address"));
    }

    public void clickAddNewAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(ap.addNewAddress)).click();
    }

    public void fillAddressForm(Map<String, String> data) {

        typeInField(ap.firstName, data.get("First Name"));
        typeInField(ap.lastName,  data.get("Last Name"));
        typeInField(ap.address1,  data.get("Address 1"));
        typeInField(ap.city,      data.get("City"));
        typeInField(ap.postCode,  data.get("Post Code"));

        selectByVisibleText(ap.country, data.get("Country"));

        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeToBe(
                        By.id("input-zone"), "disabled", "true")
        ));

        selectByVisibleText(ap.region, data.get("Region/State"));

        wait.until(ExpectedConditions.elementToBeClickable(ap.continuee)).click();
    }

    public boolean isAddressSavedSuccessfully() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ap.successAlert));
            return ap.successAlert.getText().contains("Your address has been successfully added");
        } catch (Exception e) {
            return false;
        }
    }

    private void typeInField(WebElement element, String value) {
        if (value == null) return;
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    private void selectByVisibleText(WebElement element, String text) {
        if (text == null) return;
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Select(element).selectByVisibleText(text);
    }

}
