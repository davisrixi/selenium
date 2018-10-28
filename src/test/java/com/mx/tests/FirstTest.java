package com.mx.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void firstTest() {
        // Creating driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Opening page
        driver.get("http://the-internet.herokuapp.com/login");
        System.out.println("Page opened!");

        //Login page elements
        WebElement username = ((ChromeDriver) driver).findElementById("username");
        WebElement password = ((ChromeDriver) driver).findElementByCssSelector("input[name=password]");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Typing username and passwords
        // tomsmith for the username and SuperSecretPassword! for the password
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");

        // Clicking login button
        loginButton.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifications
        WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
        Assert.assertTrue(logoutButton.isDisplayed(),"logout button is not displayed");


        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("You logged into a secure area!"),"Page source doesn't contain expected text: 'You logged into a secure area!'");

        driver.quit();
    }
}
