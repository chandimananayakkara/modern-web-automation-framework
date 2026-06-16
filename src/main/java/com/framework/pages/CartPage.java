package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartItems = By.xpath("//tr[contains(@id,'product-')]");
    private By deleteButton = By.className("cart_quantity_delete");
    private By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return driver.findElements(cartItems).size();
    }

    public void removeProduct() {
        click(deleteButton);
        waitForInvisibility(cartItems);
    }

    public void clickProceedToCheckout(){
        click(proceedToCheckoutBtn);
    }

}