package com.framework.tests;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        new HomePage(driver).clickOnLoginLink().login("chandima6416suboda@gmail.com", "Apple@123");

        Assert.assertTrue(new LoginPage(driver).isLogoutButtonDisplayed(), "Logout button is not displayed, Login unsuccessful.");
    }

    @Test
    public void testInvalidPassword() {
       new HomePage(driver).clickOnLoginLink().login("chandima6416suboda@gmail.com", "WrongPassword123");
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains("incorrect"), "Error message is wrong!");
    }

    @Test
    public void testEmptyLogin() {
        new HomePage(driver).clickOnLoginLink().login("", "");

        Assert.assertFalse(driver.getCurrentUrl().contains("account"), "Even those empty it's logged in.");
    }

    @Test
    public void testLogout() {
        new HomePage(driver).clickOnLoginLink().login("chandima6416suboda@gmail.com", "Apple@123");
        new LoginPage(driver).clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Not navigate to login page after logout");
    }
}
