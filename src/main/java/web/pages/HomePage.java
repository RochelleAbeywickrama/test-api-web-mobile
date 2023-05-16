package web.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static web.common.Constants.APP_BASE_URL;
import static web.common.Constants.HOME_PAGE_TITLE;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By txtSearchBar = By.xpath("//input[@id=\"twotabsearchtextbox\"]");

     public ProductListPage enterSearchTerm(String searchTerm){
        driver.findElement(txtSearchBar).sendKeys(searchTerm);
         driver.findElement(txtSearchBar).sendKeys(Keys.ENTER);
         waitTillPageLoads();
         return new ProductListPage(driver);
    }


    public HomePage launchHome(){
        return new HomePage(driver);
    }

    public void waitTillPageLoads(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void launch(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(APP_BASE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }
}
