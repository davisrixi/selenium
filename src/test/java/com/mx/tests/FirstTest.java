package com.mx.tests;

import com.herokuapp.LoginPage;
import com.herokuapp.SecurePage;
import com.mx.base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        // Clicking login button
        SecurePage securePage = loginPage.logIn();
        securePage.waitForSecurePage(10000);

        softAssert.assertTrue(securePage.isLogoutButtonVisible(), "Logout button is not displayed.");
        softAssert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"),
                "Page source doesn't contain expected text: 'You logged into a secure area!'");

        softAssert.assertAll();
    }
}
