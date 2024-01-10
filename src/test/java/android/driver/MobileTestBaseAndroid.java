package android.driver;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static android.helpers.AndroidUtils.installApp;
import static android.helpers.AndroidUtils.removeApp;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MobileTestBaseAndroid {
    @BeforeSuite
    public void beforeSuite() {
        browser = AndroidLocalDriver.class.getName();
        timeout = 8000;
        browserSize = null;
        open();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
        installApp();
    }

    @AfterSuite
    public void afterSuite() {
        removeApp();
        closeWebDriver();
    }

}
