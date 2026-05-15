package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public By search = By.xpath("//input[@class='form-control input-lg']");
	public By compare = By.id("compare-total");

}
