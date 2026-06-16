package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    private By productsMenu = By.xpath("//a[@href='/products']");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productItems = By.xpath("//div[@class='single-products']");
    private By firstProduct = By.xpath("(//div[@class='single-products'])[1]");
    private By addToCartBtn = By.xpath("(//a[@data-product-id='1'])[2]");
    private By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private By viewCartLink = By.xpath("//a[@href='/view_cart']//u");
    private By mainCartMenu = By.xpath("//a[contains(text(),'Cart')]");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void gotoProducts(){
        click(productsMenu);
        removeAdsWithJS();
        driver.get("https://automationexercise.com/products");
    }

    public void searchProduct(String productName){
        type(searchInput, productName);
        click(searchButton);
    }

    public boolean isSearchedHeaderDisplayed(){
        return driver.findElement(searchedProductsHeader).isDisplayed();
    }

    public int getProductCount(){
        List<WebElement> list = driver.findElements(productItems);
        return list.size();
    }

    public void addFirstProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(firstProduct));
        hoverOverElement(firstProduct);
        clickUsingJS(addToCartBtn);
    }

    public void clickContinueShopping(){
        waitForElementToBeClickable(continueShoppingBtn);
        click(continueShoppingBtn);
    }

    public void clickViewCart(){
        waitForElementToBeVisible(viewCartLink);
        clickUsingJS(viewCartLink);
    }

    public void goToCartFromHeader() {
        click(mainCartMenu);
    }

}
