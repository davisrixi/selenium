package com.herokuapp;

import com.mx.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    By usernameLocator = By.id("username");
    By passwordLocator = By.cssSelector("input[name=password]");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    private String loginPageUrl = "http://the-internet.herokuapp.com/login";
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SecurePage logIn() {
        System.out.println("Entering username and password");
        find(usernameLocator).sendKeys(username);
        find(passwordLocator).sendKeys(password);

        System.out.println("Clicking Login button");
        find(loginButtonLocator).click();

        return new SecurePage(driver);
    }

    public void open() {
        openUrl(loginPageUrl);
    }
}
