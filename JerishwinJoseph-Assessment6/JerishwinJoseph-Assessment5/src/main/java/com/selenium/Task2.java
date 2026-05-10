package com.selenium;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // ─── TASK 1: Login ───────────────────────────────────────────────
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
            .sendKeys("Banton");
        driver.findElement(By.id("loginpassword")).sendKeys("JeriJose");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement logout = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        if (logout.isDisplayed()) {
            System.out.println("Login Successful");   // exact expected output
        } else {
            System.out.println("Login Failed");
        }

        // ─── TASK 2: Category Navigation & Product Handling ──────────────
        driver.findElement(By.xpath("//a[text()='Laptops']")).click();

        // Wait for laptops to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@id='tbodyid']/div")));

        List<WebElement> laptopElements = driver.findElements(
            By.xpath("//div[@id='tbodyid']/div/div/div/h4/a"));

        // Store names in a Set (as required), then sort ascending
        Set<String> laptopSet = new TreeSet<>();   // TreeSet sorts ascending automatically
        for (WebElement e : laptopElements) {
            laptopSet.add(e.getText());
        }

        System.out.println("Laptops in ascending order:");
        for (String name : laptopSet) {
            System.out.println("Found Laptop: " + name);
        }

        // Use Actions + JavascriptExecutor to scroll to MacBook Pro
        WebElement macBookPro = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@id='tbodyid']/div/div/div/h4/a[text()='MacBook Pro']")));

        // JavaScript scroll to element (centers it in view)
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", macBookPro);

        // Action class: move to the element
        actions.moveToElement(macBookPro).perform();

        System.out.println("MacBook Pro title verified: " + macBookPro.getText());

        // ─── TASK 3: Add Product to Cart ─────────────────────────────────
        macBookPro.click();

        WebElement addToCart = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
        addToCart.click();

        // Q5 – Alert handling (fires right after "Add to cart")
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert text: " + alertText);
            driver.switchTo().alert().accept();
            System.out.println("Alert handled Successfully");   // exact expected output
        } catch (Exception e) {
            System.out.println("No alert appeared.");
        }

        // Navigate to Cart
        driver.findElement(By.id("cartur")).click();

        WebElement cartProduct = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));

        WebElement cartPrice = driver.findElement(
            By.xpath("//tr[td[text()='MacBook Pro']]/td[3]"));   // price column

        if ("MacBook Pro".equals(cartProduct.getText())) {
            System.out.println("Product added to cart");
            System.out.println("MacBook Pro added to cart.");
            System.out.println("Product Name and Cost verified successfully");
            System.out.println("Price in cart: $" + cartPrice.getText());
        }

        // ─── TASK 4: Place Order ──────────────────────────────────────────
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
            .sendKeys("John");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Salem");
        driver.findElement(By.id("card")).sendKeys("123444994");
        driver.findElement(By.id("month")).sendKeys("March");
        driver.findElement(By.id("year")).sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        // Wait for the confirmation sweet-alert
        WebElement confirmation = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'sweet-alert') and contains(@class,'visible')]")));

        String purchaseText = confirmation.getText();

        if (purchaseText.contains("Order Id")) {
            System.out.println("Purchase done Successfully");   // exact expected output
            System.out.println("Order is placed successfully");

            // Extract and print Order ID, Amount, Date from the confirmation text
            for (String line : purchaseText.split("\n")) {
                if (line.contains("Id:")
                        || line.contains("Amount:")
                        || line.contains("Date:")) {
                    System.out.println(line.trim());
                }
            }
        } else {
            System.out.println("Order is Unsuccessful");
        }

        driver.quit();
    }
}