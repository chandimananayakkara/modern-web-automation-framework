package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private By messageArea = By.name("message");
    private By placeOrderBtn = By.xpath("//a[@href='/payment']");
    private By deliveryAddressName = By.xpath("//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']");
    private By deliveryAddress1 = By.xpath("//ul[@id='address_delivery']//li[4]");

    private By productNameInReview = By.xpath("//td[@class='cart_description']//h4//a");
    private By productPriceInReview = By.xpath("//td[@class='cart_price']//p");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void enterComment(String comment){
        type(messageArea, comment);
    }

    public void clickPlaceOrder(){
        clickUsingJS(placeOrderBtn);;
    }

    public String getDeliveryName(){
        return  driver.findElement(deliveryAddressName).getText();
    }

    public String getProductInReview(){
        return driver.findElement(productNameInReview).getText();
    }
}
