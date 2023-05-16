package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By txtSearchBar = By.xpath("//input[@id=\"twotabsearchtextbox\"]");

     public ProductListPage enterSearchTerm(String searchTerm){
        driver.findElement(txtSearchBar).sendKeys(searchTerm);
         driver.findElement(txtSearchBar).sendKeys(Keys.ENTER);
         waitTillPageLoads();
         return new ProductListPage(driver);
    }

    public void waitTillPageLoads(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


}
