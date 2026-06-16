package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payButton = By.id("submit");
    private By successMsg = By.xpath("//p[contains(text(),'Congratulations')]");

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    public void enterPaymentDetails(String name, String num, String cv, String month, String year){
        type(nameOnCard, name);
        type(cardNumber, num);
        type(cvc, cv);
        type(expiryMonth, month);
        type(expiryYear, year);
        click(payButton);
    }

    public String getSuccessMessage(){
        return driver.findElement(successMsg).getText();
    }
}
