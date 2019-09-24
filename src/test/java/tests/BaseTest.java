package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BaseTest {

    AppiumDriver driver;
    DesiredCapabilities capabilities;
    String port;

    public void setUp() throws Throwable {
        port = "4725";
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AnyDevice");
        capabilities.setCapability("platformName", "Android");
        // Replace path value with Absolute path to APK
        capabilities.setCapability("app", "Absolute/Path/To/FasTip.apk");
        capabilities.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
    }
}
