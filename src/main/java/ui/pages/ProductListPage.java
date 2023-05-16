package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage extends HomePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    private By elePageTitle = By.xpath("//span[text()='Results']");
    private By lstItem = By.xpath("//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-2\"]//h2");



    public String getPageTitle(){
        return driver.findElement(elePageTitle).getText();
    }



    public ProductViewPage clickOnFirstResult(){
        driver.findElement(lstItem).click();
        return new ProductViewPage(driver);
    }

}
