package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;

public class DriverUtils {
    public DriverUtils() {
    }

    public static WebDriver setToRunLocally() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static DesiredCapabilities setToRunOnMobile() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 3 API 33");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", 240);
        capabilities.setCapability("javascriptEnabled", true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-translate");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-cookies");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }

}
