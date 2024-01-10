package android.helpers;

import android.driver.MobileTestBaseAndroid;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AndroidUtils extends MobileTestBaseAndroid {
    static String PACKAGE_MYRAIF = "ua.raiffeisen.myraif";
    public static final AndroidDriver androidDriver = (AndroidDriver) getWebDriver();

    public static void removeApp() {
        androidDriver.removeApp(PACKAGE_MYRAIF);
    }

    public static void launchMYRAIF() {
        androidDriver.activateApp(PACKAGE_MYRAIF);
    }


    public static void installApp() {
        HelpersAndroid.installFromStore();
    }

    public static void terminateMYRAIF() {
        androidDriver.terminateApp(PACKAGE_MYRAIF);
    }


    public static void startRecordAndroid() {
        AndroidStartScreenRecordingOptions recordingOptions = AndroidStartScreenRecordingOptions.startScreenRecordingOptions()
                .withTimeLimit(Duration.ofMinutes(10))
                .withVideoSize("device")
                .withBitRate(400000);

        androidDriver.startRecordingScreen(recordingOptions);
    }


    public static byte[] stopRecordingAndroid() {
        String videoBase64 = androidDriver.stopRecordingScreen();
        return Base64.decodeBase64(videoBase64);
    }

    public static void rebootAppAndroid() {
        androidDriver.terminateApp(PACKAGE_MYRAIF);
        androidDriver.activateApp(PACKAGE_MYRAIF);
    }

    public static void scrollDownFromCenterAndroid() {
        Dimension windowSize = androidDriver.manage().window().getSize();
        int centerX = windowSize.getWidth() / 2;
        int centerY = windowSize.getHeight() / 2;
        int scrollDistance = 300;
        int endScrollY = centerY - scrollDistance;
        int n = 0;

        while (n < 2) {
            n++;
            TouchAction action = new TouchAction(androidDriver);

            action.press(PointOption.point(centerX, centerY))
                    .waitAction()
                    .moveTo(PointOption.point(centerX, endScrollY))
                    .release()
                    .perform();
        }
    }

    public static void scrollDownFromCenterAndroidUP() {
        Dimension windowSize = androidDriver.manage().window().getSize();
        int centerX = windowSize.getWidth() / 2;
        int centerY = windowSize.getHeight() / 2;
        int scrollDistance = 150;
        int endScrollY = centerY + scrollDistance;
        int n = 0;

        while (n < 2) {
            n++;
            TouchAction action = new TouchAction(androidDriver);

            action.press(PointOption.point(centerX, centerY))
                    .waitAction()
                    .moveTo(PointOption.point(centerX, endScrollY))
                    .release()
                    .perform();
        }
    }

    public static void dragElementForScrollUpAndroid(SelenideElement element) {
        int offset = 300;
        // Получить местоположение элемента
        Point location = element.getLocation();

        // Вычислить координаты начала и конца
        int startX = location.getX();
        int startY = location.getY();
        int endY = startY - offset;
        // Создать новый объект TouchAction
        TouchAction action = new TouchAction(androidDriver);

        // Выполнить жест перетаскивания
        action.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}
