package com.framework.tests;

import com.framework.pages.*;
import com.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    private void navigateToCheckout() {
        String email = ConfigReader.getProperty("user.email");
        String password = ConfigReader.getProperty("user.password");

        new HomePage(driver).clickOnLoginLink();
        new LoginPage(driver).login(email, password);

        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();
        productPage.clickViewCart();

        new CartPage(driver).clickProceedToCheckout();
    }

    @Test
    public void testFullCheckoutFlow() {
        navigateToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterComment("Please deliver quickly");
        checkoutPage.clickPlaceOrder();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails(
                ConfigReader.getProperty("card.name"),
                ConfigReader.getProperty("card.number"),
                ConfigReader.getProperty("card.cvc"),
                ConfigReader.getProperty("card.expiryMonth"),
                ConfigReader.getProperty("card.expiryYear")
        );

        Assert.assertTrue(paymentPage.getSuccessMessage().contains("Congratulations"), "Order not successful");
    }


    @Test
    public void testAddressAndOrderReview() {
        navigateToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String actualName = checkoutPage.getDeliveryName();

        Assert.assertTrue(actualName.contains(ConfigReader.getProperty("user.fullname")), "Name of address is wrong");


        String actualProduct = checkoutPage.getProductInReview();
        Assert.assertNotNull(actualProduct, "No item available in cart");

        System.out.println("Verified Address and Product: " + actualProduct);
    }

    @Test
    public void testOrderConfirmationDetails() {
        new HomePage(driver).clickOnLoginLink();
        new LoginPage(driver).login(ConfigReader.getProperty("user.email"), ConfigReader.getProperty("user.password"));
        new ProductPage(driver).gotoProducts();
        new ProductPage(driver).addFirstProductToCart();
        new ProductPage(driver).clickViewCart();
        new CartPage(driver).clickProceedToCheckout();
        new CheckoutPage(driver).clickPlaceOrder();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails(
                ConfigReader.getProperty("card.name"),
                ConfigReader.getProperty("card.number"),
                ConfigReader.getProperty("card.cvc"),
                ConfigReader.getProperty("card.expiryMonth"),
                ConfigReader.getProperty("card.expiryYear")
        );

        boolean isOrderPlaced = driver.findElement(By.xpath("//b[text()='Order Placed!']")).isDisplayed();
        boolean isDownloadInvoicePresent = driver.findElement(By.xpath("//a[text()='Download Invoice']")).isDisplayed();

        Assert.assertTrue(isOrderPlaced, "Not Display order message");
        Assert.assertTrue(isDownloadInvoicePresent, "No accessible download invoice button");
    }

    @Test
    public void testCheckoutWithoutLogin() {
        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();
        productPage.clickViewCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckout();

        boolean isPopupDisplayed = driver.findElement(By.xpath("//u[text()='Register / Login']")).isDisplayed();
        Assert.assertTrue(isPopupDisplayed, "Login pop-up not shown!");
    }

    @Test
    public void testInvoiceDownloadOption() {
        testFullCheckoutFlow();

        boolean isDownloadVisible = driver.findElement(By.xpath("//a[text()='Download Invoice']")).isDisplayed();
        Assert.assertTrue(isDownloadVisible, "Invoice download button not shown");
    }

}
