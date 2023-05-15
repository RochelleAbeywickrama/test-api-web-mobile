package tests.web.utils;

import api.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static web.config.Config.chromeDriverPath;

public class BaseUtils {
    private WebDriver driver;

    public static final String APP_BASE_URL = Config.getProperty("base.url");

    public BaseUtils(WebDriver driver) {
        super();
    }
//    protected GetPropertyValues getPropertyValues = null;
//    public static TreeMap<String, String> modTestData = null;
//    public ConfigFileReader configFileReader;configFileReader

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\selenium-appium-restassured-test\\test-api-web-mobile\\src\\main\\resources\\web\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(APP_BASE_URL);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }

//    @BeforeMethod
//    public void setProperty() {
//        getPropertyValues = new GetPropertyValues();
//        String property_path = "/applicationData.properties";
//        try {
//            modTestData = getPropertyValues.getResourceData(property_path);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @AfterClass
    public void quit() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
}
