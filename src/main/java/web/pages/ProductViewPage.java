package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductViewPage extends ProductListPage{

    public ProductViewPage(WebDriver driver) {
        super(driver);
    }

    private By eleProductTitle = By.xpath("//span[@id=\"productTitle\"]");
    private By btnAddToCart = By.xpath("//input[@id='add-to-cart-button']");

    public String getProductTitle(){
        return driver.findElement(eleProductTitle).getText().trim();
    }

    public AddToCartPage clickOnAddToCart(){
        driver.findElement(btnAddToCart).click();
        return new AddToCartPage(driver);
    }

}
