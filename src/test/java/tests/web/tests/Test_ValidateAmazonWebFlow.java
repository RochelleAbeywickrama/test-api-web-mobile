package tests.web.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import tests.web.utils.BaseUtils;

import java.net.URL;

public class Test_ValidateAmazonWebFlow {



    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\selenium-appium-restassured-test\\test-api-web-mobile\\src\\test\\resources\\web\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.javatpoint.com/");
    }

    @Test
    public void searchProduct() {
        driver.get("https://www.amazon.com");
        // Add your test steps here
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
