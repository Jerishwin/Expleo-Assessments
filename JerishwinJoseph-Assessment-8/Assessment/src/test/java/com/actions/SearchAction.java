package com.actions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePage;

public class SearchAction extends BaseAction{

	public SearchAction(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		hp = new HomePage(driver);
	}
	
	WebDriverWait wait;
	HomePage hp;
	
	public void search(String str) {
		WebElement search =wait.until(ExpectedConditions.visibilityOfElementLocated(hp.search));
		search.sendKeys(str);
		search.sendKeys(Keys.ENTER);
	}
	
	public boolean vie() {
		WebElement compare = driver.findElement(hp.compare);
		if(compare.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}

}
