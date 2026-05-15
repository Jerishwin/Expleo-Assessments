package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	    public LoginPage(WebDriver driver) {
		super(driver);
		
	}

		@FindBy(xpath = "//span[text()='My Account']")
		public WebElement myAccountDropdown;

	    @FindBy(xpath = "//a[contains(text(),'Login')]")
	    public WebElement loginLink;

	    @FindBy(id = "input-email")
	    public WebElement emailInput;

	    @FindBy(id = "input-password")
	    public WebElement passwordInput;

	    @FindBy(xpath = "//input[@value='Login']")
	    public WebElement loginButton;
}
