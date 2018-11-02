package com.herokuapp;

import com.mx.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePageObject {

    By logoutButtonLocator = By.xpath("//a[@class='button secondary radius']");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public void waitForSecurePage(long millis) {
        System.out.println("Waiting for secure page");
        waitForElementPresent(logoutButtonLocator, 15);
    }

    public boolean isLogoutButtonVisible() {
        return find(logoutButtonLocator).isDisplayed();
    }
}
