package BothPlatform.allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.remote.MobileBrowserType.BROWSER;

public class DriverUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(DriverUtils.class);

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static byte[] getScreenshotAsBytes() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static byte[] getPageSourceAsBytes() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static String getConsoleLogs() {
        return String.join("\n", getWebDriverLogs(BROWSER));
    }

}
