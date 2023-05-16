package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.pages.*;

import static ui.common.Constants.*;
import static ui.pages.HomePage.driver;

@Feature("Amozon Web Shopping Cart")
public class Test_ValidateAmazonShoppingFeature {

    BasePage basePage;
    HomePage homePage;
    ProductListPage productListPage;
    ProductViewPage productViewPage;
    AddToCartPage addToCartPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeTest
    public void launchBrowser() {
        basePage = new BasePage(driver);
        homePage = basePage.initiateDriver();
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @Test
    @Description("Validate Amazon Shopping Cart Feature")
    public void test_ValidateAmazonShoppingCart() {

        productListPage = homePage.enterSearchTerm(SEARCH_TERM);
        Assert.assertEquals(productListPage.getPageTitle(), RESULTS_PAGE_TITLE);
        productViewPage = productListPage.clickOnFirstResult();
        String productName = productViewPage.getProductTitle();
        addToCartPage = productViewPage.clickOnAddToCart();
        Assert.assertTrue(addToCartPage.isProductAddedToCart(), ERROR_NO_PRODUCT_ADDED);
        shoppingCartPage = addToCartPage.clickGoToCart();
        Assert.assertEquals(shoppingCartPage.getPageTitle(), CART_PAGE_TITLE);
        Assert.assertTrue(shoppingCartPage.getProductName(productName), ERROR_NO_PRODUCT_IN_CART);
    }

    @AfterTest
    public void quit() {
        if (null != driver) {
            driver.quit();
        }
    }
}
