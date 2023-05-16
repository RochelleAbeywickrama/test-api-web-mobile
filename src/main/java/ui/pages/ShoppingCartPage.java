package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends AddToCartPage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By elePageTitle = By.tagName("H1");
    String lblProductName = "//span[@class=\"a-list-item\"]//following::span[1][contains(text(),'product-name')]";


    public String getPageTitle() {
        return driver.findElement(elePageTitle).getText().trim();
    }

    public boolean getProductName(String productName) {
        return driver.findElement(By.xpath(lblProductName.replace("product-name", productName))).isDisplayed();
    }


}
