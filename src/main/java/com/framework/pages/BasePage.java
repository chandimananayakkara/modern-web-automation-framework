package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected void click(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        waitForElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected void hoverOverElement(By locator) {
        waitForElementToBeVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void clickUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void removeAdsWithJS() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "var ads = document.querySelectorAll('ins, iframe[id^=\"aswift\"], .adsbygoogle, #aswift_0_expand, #aswift_0_anchor'); " +
                            "for (var i=0; i<ads.length; i++) { ads[i].remove(); }"
            );
            System.out.println("Ads removed using JavaScript.");
        } catch (Exception e) {

        }
    }
}