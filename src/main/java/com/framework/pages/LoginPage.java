package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");
    private By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String email, String password){
        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public void clickLogout(){
        click(logoutButton);
    }

    public boolean isLogoutButtonDisplayed(){
        return driver.findElement(logoutButton).isDisplayed();
    }
}
