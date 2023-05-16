package tests.ui;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.pages.*;

import static ui.common.Constants.*;
import static ui.pages.HomePage.driver;


public class Test_ValidateAmazonShoppingFeature {

    BasePage basePage;
    HomePage homePage;
    ProductListPage productListPage;
    ProductViewPage productViewPage;
    AddToCartPage addToCartPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeTest
    public void launchBrowser() {
        // Initiate Driver
        basePage = new BasePage(driver);
        // Launch Chrome Browser and go to "www.amazon.com"
        homePage = basePage.initiateDriver();
        // Verify Amazon official website is launched
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @Test
    public void test_ValidateAmazonShoppingCart() {

        // Type "‘Apple iPhone 14 Pro" in the search box and press "Enter"
        productListPage = homePage.enterSearchTerm(SEARCH_TERM);

        // Validate Results page is launched
        Assert.assertEquals(productListPage.getPageTitle(), RESULTS_PAGE_TITLE);

        // Click on the 1st search result
        productViewPage = productListPage.clickOnFirstResult();

        // Get Product name from the selected result
        String productName = productViewPage.getProductTitle();

        // Click on 'Add to cart' button to add the item to cart
        addToCartPage = productViewPage.clickOnAddToCart();
        Assert.assertTrue(addToCartPage.isProductAddedToCart(), ERROR_NO_PRODUCT_ADDED);

        // Click on 'Go to cart' button to view the cart
        shoppingCartPage = addToCartPage.clickGoToCart();

        // Validate added Item is available in the cart
        Assert.assertEquals(shoppingCartPage.getPageTitle(), CART_PAGE_TITLE);
        Assert.assertTrue(shoppingCartPage.getProductName(productName), ERROR_NO_PRODUCT_IN_CART);

    }

    @AfterTest
    public void quit() {
        if (null != driver) {
            // Driver to quit all sessions
            driver.quit();
        }
    }
}
