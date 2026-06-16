package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{

    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    private By passwordInput = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private By successMsg = By.xpath("//b[text()='Account Created!']");
    private By errorMsg = By.xpath("//p[text()='Email Address already exist!']");
    private By deleteAccountLink = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedMsg = By.xpath("//b[text()='Account Deleted!']");

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    public void startSignup(String name, String email) {
        type(nameInput, name);
        type(emailInput, email);
        click(signupButton);
    }

    public void fillAccountDetails(String pwd, String fname, String lname, String addr) {
        type(passwordInput, pwd);
        type(firstName, fname);
        type(lastName, lname);
        type(address, addr);
        type(state, "Western");
        type(city, "Colombo");
        type(zipcode, "10100");
        type(mobile, "0771234567");
        click(createAccountBtn);
    }

    public String getSuccessText() {
        return driver.findElement(successMsg).getText();
    }

    public void deleteAccount() {
        clickUsingJS(deleteAccountLink);
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedMsg).isDisplayed();
    }

    public void clickContinue() {
        click(continueBtn);
    }
}
