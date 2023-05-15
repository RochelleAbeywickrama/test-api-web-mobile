package tests.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import web.pages.*;

import java.util.concurrent.TimeUnit;

import static web.common.Constants.*;


public class Test_ValidateAmazonWebFlow {

    private WebDriver driver;
    HomePage homePage;
    ProductListPage productListPage;
    ProductViewPage productViewPage;
    AddToCartPage addToCartPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeTest
    public void initializeBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(APP_BASE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @Test
    public void test_ValidateAmazonShoppingCart() {
        homePage = new HomePage(driver);
        homePage.launchHome();
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
