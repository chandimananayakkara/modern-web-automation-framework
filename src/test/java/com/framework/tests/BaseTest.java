package com.framework.tests;

import com.framework.driver.DriverManager;
import com.framework.pages.BasePage;
import com.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@org.testng.annotations.Listeners(com.framework.utils.TestListener.class)

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String browserName = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        driver = DriverManager.getDriver(browserName);
        driver.get("https://automationexercise.com/");

        BasePage basePage = new BasePage(driver);
        basePage.removeAdsWithJS();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
