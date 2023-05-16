package ui.utils;

import api.model.CommentModel;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;

import static ui.common.Constants.*;

public class DriverUtils {
    public DriverUtils() {
    }

    public static WebDriver setToRunLocally() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static DesiredCapabilities setToRunOnMobile() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.valueOf(NEW_COMMAND_TIMEOUT));
        capabilities.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, Boolean.valueOf(SUPPORTS_JAVASCRIPT));

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
