package com.framework.tests;

import com.framework.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductSearchTests extends BaseTest {

    ProductPage productPage;

    @BeforeMethod
    public void setupPages(){
        productPage = new ProductPage(driver);
        productPage.gotoProducts();
    }

    @Test
    public void testValidProductSearch(){
        productPage.searchProduct("Tshirt");
        Assert.assertTrue(productPage.isSearchedHeaderDisplayed(), "Searched products header not displayed");

        int count = productPage.getProductCount();
        System.out.println("Found " + count + " products for Tshirt");
        Assert.assertTrue(count > 0, "Items must be available, but shown 0");
    }

    @Test
    public void testInvalidProductSearch(){
        productPage.searchProduct("NonExistingProduct123");
        Assert.assertEquals(productPage.getProductCount(),0,"items must be 0 but shown non matching items");
    }

    @Test
    public void testEmptySearch(){
        productPage.searchProduct("");
        Assert.assertTrue(productPage.getProductCount()>0);
    }

    @Test
    public void testCategorySearch() {
        productPage.searchProduct("Dress");
        Assert.assertTrue(productPage.getProductCount() > 0, "Dresses Not Found!");
    }

    @Test
    public void testSearchResultContent() {
        productPage.searchProduct("Top");
        Assert.assertTrue(productPage.getProductCount() >= 1);
    }


}
