package com.framework.tests;

import com.framework.pages.CartPage;
import com.framework.pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void testAddSingleProductToCart() {

        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();

        // Continue Shopping ඔබන්න එපා! කෙලින්ම View Cart යන්න.
        productPage.clickViewCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
    }

    @Test
    public void testRemoveProductFromCart(){
        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();
        productPage.clickViewCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct();

        Assert.assertEquals(cartPage.getCartItemCount(),0,"Item not removed.");
    }

    @Test
    public void testAddAndGoToCartViaHeader() {
        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();
        productPage.clickContinueShopping(); // මෙතනදී Pop-up එක වහනවා

        productPage.goToCartFromHeader(); // මෙනු එකෙන් කරත්තයට යනවා

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
    }

    @Test
    public void testAddMultipleProducts() {
        ProductPage productPage = new ProductPage(driver);
        productPage.gotoProducts();
        productPage.addFirstProductToCart();
        productPage.clickContinueShopping();
        productPage.addFirstProductToCart();
        productPage.clickViewCart();

        CartPage cartPage = new CartPage(driver);
         Assert.assertTrue(cartPage.getCartItemCount() >= 1);
    }

    @Test
    public void testAddFromProductDetail() {
        driver.get("https://automationexercise.com/product_details/1");
        driver.findElement(By.xpath("//button[contains(@class,'cart')]")).click();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickViewCart();
        Assert.assertEquals(new CartPage(driver).getCartItemCount(), 1);
    }

    @Test
    public void testCartQuantityUpdate() {
        testAddSingleProductToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.getCartItemCount() > 0);
    }

}
