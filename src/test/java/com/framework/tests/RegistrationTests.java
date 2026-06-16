package com.framework.tests;

import com.framework.pages.HomePage;
import com.framework.pages.SignUpPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    @Test
    public void testNewUserSignup() {
        new HomePage(driver).clickOnLoginLink();

        SignUpPage signupPage = new SignUpPage(driver);
        String dynamicEmail = "testuser" + System.currentTimeMillis() + "@mail.com";

        signupPage.startSignup("QA Engineer", dynamicEmail);
        signupPage.fillAccountDetails("Pass123", "Test", "User", "No 123, Colombo");

        Assert.assertEquals(signupPage.getSuccessText(), "ACCOUNT CREATED!");
    }

    @Test
    public void testExistingEmailSignup() {
        new HomePage(driver).clickOnLoginLink();

        SignUpPage signupPage = new SignUpPage(driver);
        signupPage.startSignup("QA Engineer", "qa_test_user@mail.com");


        boolean isErrorVisible = driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed();
        Assert.assertTrue(isErrorVisible, "Already registered email error message not shown!");
    }

    @Test
    public void testEmptySignup() {
        new HomePage(driver).clickOnLoginLink();
        SignUpPage signupPage = new SignUpPage(driver);
        signupPage.startSignup("", "");

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Account created without email and password!");
    }

    @Test
    public void testSignupAndDeleteAccount() {
        new HomePage(driver).clickOnLoginLink();
        SignUpPage signupPage = new SignUpPage(driver);
        String email = "delete_test" + System.currentTimeMillis() + "@mail.com";

        signupPage.startSignup("To Be Deleted", email);
        signupPage.fillAccountDetails("Pass123", "Delete", "Me", "Colombo");


        signupPage.clickContinue();


        signupPage.deleteAccount();
        Assert.assertTrue(signupPage.isAccountDeletedVisible(), "Account is not deleted!");
    }

    @Test
    public void testMissingMandatoryField() {
        new HomePage(driver).clickOnLoginLink();
        SignUpPage signupPage = new SignUpPage(driver);
        signupPage.startSignup("Missing Pass", "missing" + System.currentTimeMillis() + "@mail.com");


        signupPage.fillAccountDetails("", "First", "Last", "Address");


        Assert.assertFalse(driver.getCurrentUrl().contains("account_created"), "Account creates without password!");
    }
}
