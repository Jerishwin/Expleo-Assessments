package com.selenium;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		//Task1 login to the account
		
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.id("login2"));
		login.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement username = driver.findElement(By.id("loginusername"));
		WebElement password = driver.findElement(By.id("loginpassword"));
		username.sendKeys("Banton");
		password.sendKeys("JeriJose");
		WebElement log = driver.findElement(By.xpath("//button[text()='Log in']"));
		log.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
        
        if(logout.isDisplayed()) {
        	System.out.println("Logged in ");
        }else {
        	System.out.println("Not Logged in ");
        }
        
        
        //Task2 Accessing laptop segment
        
        WebElement laptop = driver.findElement(By.xpath("//a[text()='Laptops']"));
        laptop.click();
        laptop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']/div/div/div/h4/a[text()='MacBook Pro']")));
        List<WebElement> laptopList = new ArrayList<>();
        
        laptopList = driver.findElements(By.xpath("//div[@id='tbodyid']/div/div/div/h4/a"));
        laptopList.sort(Comparator.comparing(WebElement::getText).reversed());// Ai
        for(WebElement i:laptopList) {
        	System.out.println(i.getText());
        	if("MacBook Pro".equals(i.getText())) {
        		System.out.println("Found Laptop: " + i.getText());
        	}
        }
		if(laptopList.size()>0) {
			System.out.println("Values are stored");
		}else {
			
			System.out.println("Values are not stored");
		}
		
		//Task3 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement mac = driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/h4/a[text()='MacBook Pro']"));
		mac.click();
		
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
		
		cart.click();
		
		cart=driver.findElement(By.id("cartur"));
		cart.click();
		
		cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));
		
		if("MacBook Pro".equals(cart.getText())) {
			System.out.println("Product added to cart");
			System.out.println("MacBook Pro added to cart.");
		}
		
		//Task4
		
		cart = driver.findElement(By.xpath("//button[text()='Place Order']"));
		cart.click();
		
		cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		cart.sendKeys("John");
		cart = driver.findElement(By.id("country"));
		cart.sendKeys("India");
		cart = driver.findElement(By.id("city"));
		cart.sendKeys("Salem");
		cart = driver.findElement(By.id("card"));
		cart.sendKeys("123444994");
		cart = driver.findElement(By.id("month"));
		cart.sendKeys("March");
		cart = driver.findElement(By.id("year"));
		cart.sendKeys("2026");
		
		cart = driver.findElement(By.xpath("//button[text()='Purchase']"));
		cart.click();
		
		cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']")));
		
		if(cart.isDisplayed()) {
			System.out.println("Order is placed successfully");
			} else {
			System.out.println("Order is Unsuccessful");
			}
		
		
		driver.quit();
		
		
	}

}
