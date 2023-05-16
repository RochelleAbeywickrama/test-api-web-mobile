package tests.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class Test_ValidateAmazonMobileFlow {


    public static AppiumDriver appiumDriver;

    @Test
    public void setup() {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 3 API 33");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appPackage", "com.android.chrome");
//        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("newCommandTimeout", 240);
//        capabilities.setCapability("appPackage", "com.android.chrome");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-translate");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-cookies");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);


        try {
            appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        appiumDriver.get("https://www.amazon.com");

    }

    @AfterClass
    public void tearDown() {

    }
}

