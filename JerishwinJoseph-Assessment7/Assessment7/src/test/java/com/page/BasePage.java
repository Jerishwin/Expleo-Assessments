package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    public WebElement signupLoginButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement signupName;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='email']")
    public WebElement signupMail;
    
    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signupButton;

    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    public WebElement loginMail;
    
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//li/a[text()=' Logged in as ']")
    public WebElement loggedInUser;
    
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement invalidloggedInUser;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickSignupLogin() {
    	signupLoginButton.click();
    }
    
	public void signup(String name, String email) {
		
		clickSignupLogin();
		signupName.sendKeys(name);
		signupMail.sendKeys(email);
		signupButton.click();
	}
	
	public void login(String email, String password) {
		clickSignupLogin();
		loginMail.sendKeys(email);
		this.password.sendKeys(password);
		loginButton.click();
	}
	
	public String verifyLogin() {
		return loggedInUser.getText();
	}
	
	public String verifyInvalidLogin() {
		return invalidloggedInUser.getText();
	}
    
}

