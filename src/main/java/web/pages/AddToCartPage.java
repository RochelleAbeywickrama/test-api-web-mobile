package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By eleAddedToCart = By.xpath("//div[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]//span[contains(text(),'Added to Cart')]");
    private By btnGoToCart = By.xpath("//a[@data-csa-c-content-id=\"sw-gtc_CONTENT\"]");

    public boolean isProductAddedToCart(){
        return driver.findElement(eleAddedToCart).isDisplayed();
    }

    public ShoppingCartPage clickGoToCart(){
        driver.findElement(btnGoToCart).click();
        return new ShoppingCartPage(driver);
    }
}
