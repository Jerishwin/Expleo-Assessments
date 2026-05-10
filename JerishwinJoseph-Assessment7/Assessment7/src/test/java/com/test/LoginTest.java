package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.page.BasePage;
import com.page.SignupPage;

@Listeners(com.utils.TestListener.class)
public class LoginTest {
	public WebDriver driver;
	BasePage basePage;
	SignupPage signupPage;
	
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="newSignupData", dataProviderClass=com.utils.ExcelUtils.class)
	public void newSignup(String name,String email,String password,String firstName,String lastName,String address,String state,String city,String zipcode,String mobileNumber) {
		signupPage = new SignupPage(driver);
		signupPage.signuppage(name, email, password, firstName, lastName, address, state, city, zipcode, mobileNumber);
		Assert.assertTrue(signupPage.verifySignup().contains("Account Created!"));
	}
	
	@Test(priority=2, dataProvider="newSignupData", dataProviderClass=com.utils.ExcelUtils.class)
	public void invalidnewSignup(String name,String email,String password,String firstName,String lastName,String address,String state,String city,String zipcode,String mobileNumber) {
		signupPage = new SignupPage(driver);
		signupPage.signuppage(name, email, password, firstName, lastName, address, state, city, zipcode, mobileNumber);
		Assert.assertTrue(signupPage.verifyInvalidSignup().contains("Email Address already exist!"));
		
	}
	
	@Test(priority=3, dataProvider="loginData", dataProviderClass=com.utils.ExcelUtils.class)
	public void login(String email, String password) {
		basePage = new BasePage(driver);
		basePage.login(email, password);
		Assert.assertTrue(basePage.verifyLogin().contains(" Logged in as "));
		
	}
	
	@Test(priority=4, dataProvider="loginData", dataProviderClass=com.utils.ExcelUtils.class)
	public void invalidLogin(String email, String password) {
		basePage = new BasePage(driver);
		basePage.login(email, password);
		Assert.assertTrue(basePage.verifyInvalidLogin().contains("Your email or password is incorrect!"));
	}
}
