package tests.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class Test_ValidateAmazonMobileFlow {

    AppiumDriver driver;

    @BeforeTest
    public void setup() {

        try {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "");
        capabilities.setCapability(MobileCapabilityType.UDID, "");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");


            URL url = new URL("");

            driver = new AppiumDriver(url, capabilities);
//            driver = new AndroidDriver(url, capabilities);
//            driver = new IOSDriver(url, capabilities);


        } catch (Exception e) {
            System.out.println("Cause is : " + e.getCause());
            System.out.println("Message is : " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Test
    public void tets(){
        System.out.println("dssssss");
    }

    @AfterClass
    public void tearDown() {

    }
}
