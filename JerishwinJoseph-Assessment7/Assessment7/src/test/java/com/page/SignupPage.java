package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
	 public SignupPage(WebDriver driver) {
		super(driver);
	}

	    @FindBy(id = "id_gender1")
	    public WebElement radioMr;

	    @FindBy(id = "password")
	    public WebElement password;

	    @FindBy(id = "first_name")
	    public WebElement first_name;
	    
	    @FindBy(id = "last_name")
	    public WebElement last_name;

	    @FindBy(id = "address1")
	    public WebElement address1;
	    
	    @FindBy(id = "state")
	    public WebElement state;
	    
	    @FindBy(id = "mobile_number")
	    public WebElement mobile_number;
	    
	    @FindBy(id = "city")
	    public WebElement city;
	    
	    @FindBy(id = "zipcode")
	    public WebElement zipcode;
	    
	    @FindBy(xpath = "//button[@data-qa='create-account']")
	    public WebElement createButton;
	    
	    @FindBy(xpath = "//b[text()='Account Created!']")
	    public WebElement text;
	    
	    @FindBy(xpath = "//p[text()='Email Address already exist!']")
	    public WebElement failtext;

	    public void signuppage(String name, String email, String password, String firstName, String lastName, String address, String state, String city, String zipcode, String mobileNumber) {
	    	super.signup(name, email);
	    	radioMr.click();
	    	this.password.sendKeys(password);
	    	first_name.sendKeys(firstName);
	    	last_name.sendKeys(lastName);
	    	address1.sendKeys(address);
	    	this.state.sendKeys(state);
	    	this.city.sendKeys(city);
	    	this.zipcode.sendKeys(zipcode);
	    	this.mobile_number.sendKeys(mobileNumber);
	    	createButton.click();
	    	
	    	
	    }
	    
	    public String verifySignup() {
	    	return text.getText();
	    }
	    
	    public String verifyInvalidSignup() {
	    	return failtext.getText();
	    }
}
