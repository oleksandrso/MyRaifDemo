package android.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static BothPlatform.BothPlatform.getAppiumServerUrl;
import static android.helpers.HelpersAndroid.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidLocalDriver implements WebDriverProvider {


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities desiredCapabilities = new MutableCapabilities();
        desiredCapabilities.merge(capabilities);

        desiredCapabilities.setCapability(PLATFORM_NAME, ANDROID);
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability("ignoreHiddenApiPolicyError", true);
        desiredCapabilities.setCapability(UDID, "PJLZUSTGEQUSSSOR");

        desiredCapabilities.setCapability(APP_PACKAGE, appPackage(environment));
        desiredCapabilities.setCapability(APP_ACTIVITY, appActivity(environment));
//        desiredCapabilities.setCapability(APP, getAbsolutePath("src/test/resources/MyRaif.apk"));


        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }
}
