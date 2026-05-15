package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;


public class LoginAction extends BaseAction{
	
	WebDriverWait wait;
	LoginPage lp;
	
	public LoginAction(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		lp = new LoginPage(driver);
	}

	public void login(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(lp.myAccountDropdown)).click();

        wait.until(ExpectedConditions.elementToBeClickable(lp.loginLink)).click();

        wait.until(ExpectedConditions.visibilityOf(lp.emailInput));
        
        lp.emailInput.sendKeys(email);

        lp.passwordInput.sendKeys(password);

        lp.loginButton.click();

        wait.until(ExpectedConditions.urlContains("account"));
    }

}
