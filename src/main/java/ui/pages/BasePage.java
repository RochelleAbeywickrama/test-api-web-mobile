package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.common.Constants;
import ui.utils.DriverUtils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static ui.common.Constants.APPIUM_SERVER_URL;
import static ui.common.Constants.APP_BASE_URL;

public class BasePage {

    // Static Driver
    public static WebDriver driver;

    // Page Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    // Launch Application Homepage
    public HomePage launchApplication() {
        driver.get(APP_BASE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new HomePage(driver);
    }

    // Driver initiation for Web or Mobile
    public HomePage initiateDriver() {
        DesiredCapabilities capabilities = null;
        // Initiate Mobile workflow
        if (Constants.MOBILE_EXECUTION.equals("true")) {
            capabilities = DriverUtils.setToRunOnMobile();
            try {
                driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
                return launchApplication();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Initiate Web workflow
            if (Constants.WEB_EXECUTION.equals("true")) {
                driver = DriverUtils.setToRunLocally();
                return launchApplication();
            } else {
                driver = DriverUtils.setToRunLocally(); // default setting - run locally
                return launchApplication();
            }
        }
        return launchApplication();
    }

    // Page Wait till loads
    public void waitTillPageLoads(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


}
