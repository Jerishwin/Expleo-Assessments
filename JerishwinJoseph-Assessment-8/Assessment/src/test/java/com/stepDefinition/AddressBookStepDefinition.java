package com.stepDefinition;

import java.util.Map;

import org.testng.Assert;

import com.actions.AddressBookActions;
import com.actions.LoginAction;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AddressBookStepDefinition {
	
	private LoginAction       la;
    private AddressBookActions aa;

    @Given("the user is logged into TutorialsNinja")
    public void userIsLoggedIn() {
        la = new LoginAction(Hooks.driver);

        la.login("jeri24@gmail.com","jeri");
        System.out.println("Login successful");
    }

    @When("the user navigates to the Address Book page")
    public void navigateToAddressBook() {
        aa = new AddressBookActions(null);
        aa.navigateToAddressBook();
        System.out.println("Navigated to Address Book");
    }

    @And("the user clicks {string}")
    public void clickButton(String buttonLabel) {
        if (buttonLabel.equalsIgnoreCase("Add New Address")) {
            aa.clickAddNewAddress();
        }
    }

    @And("the user fills in the address form with the following details:")
    public void fillAddressForm(DataTable dataTable) {
        Map<String, String> addressData = dataTable.asMap(String.class, String.class);
        aa.fillAddressForm(addressData);
    }
    
    @Then("the address should be saved successfully")
    public void verifyAddressSaved() {
        boolean saved = aa.isAddressSavedSuccessfully();
        Assert.assertTrue(saved, "Address was NOT saved successfully – success alert not found.");
        System.out.println("Address saved successfully");
    }
}
