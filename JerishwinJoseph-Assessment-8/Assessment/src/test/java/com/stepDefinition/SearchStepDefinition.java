package com.stepDefinition;

import org.junit.Assert;

import com.actions.SearchAction;

import io.cucumber.java.en.*;

public class SearchStepDefinition {
	SearchAction sa;

	@Given("the user is on the Home page")
	public void the_user_is_on_the_home_page() {
		sa = new SearchAction(Hooks.driver);
	}

	@When("the user searches for the <{string}>")
	public void the_user_searches_for_the(String string) {
	    sa.search(string);
	}

	@Then("the user views the <{string}>")
	public void the_user_views_the(String string) {
	    if(string=="contain") {
	    	Assert.assertTrue(string, sa.vie());
	    }
	}
}
