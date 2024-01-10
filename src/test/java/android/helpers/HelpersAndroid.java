package android.helpers;

import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static BothPlatform.Waiters.WAIT_INSTALL_APP_SEC;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HelpersAndroid {

    public static String
            environment = System.getProperty("env", "prod"),
            numbers = System.getProperty("numbers"),
            appStorePackage = "com.android.vending",
            appStoreActivity = "com.android.vending.AssetBrowserActivity";

    public static String appPackage(String env) {
        return appStorePackage;
    }

    public static String appActivity(String env) {
        return appStoreActivity;
    }

    public static void installFromStore() {
        $(AppiumBy.accessibilityId("Search Google Play")).click();
        $(AppiumBy.className("android.widget.EditText")).sendKeys("myraif");

        $(AppiumBy.accessibilityId("Search for \"myraif\" ")).shouldBe(visible).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text=\"Raiffeisen Bank Joint Stock Company\"]")).shouldBe(visible).click();
//        $(AppiumBy.xpath("//*[@text='myraif']")).shouldBe(visible).click();
        $(AppiumBy.xpath("//*[contains(@content-desc, 'Rate this app')]")).shouldBe(visible);

        if ($(AppiumBy.xpath("//*[@text='Install']")).isDisplayed()) {
            $(AppiumBy.xpath("//*[@text='Install']")).click();

        }
        $(AppiumBy.xpath("//*[@text='Uninstall']")).shouldBe(visible, Duration.ofSeconds(WAIT_INSTALL_APP_SEC));
        $(AppiumBy.xpath("//*[@text='Open']")).shouldBe(visible).click();
    }
}
