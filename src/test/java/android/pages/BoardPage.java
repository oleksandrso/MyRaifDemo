package android.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class BoardPage {
    public static final SelenideElement
            ACTION_BAR_ROOT = $(AppiumBy.id("ua.raiffeisen.myraif:id/action_bar_root")),
            NAV_HOST_CONTAINER = $(AppiumBy.id("ua.raiffeisen.myraif:id/nav_host_container")),
            PERMISSIONS_NAV_HOST = $(AppiumBy.id("ua.raiffeisen.myraif:id/permissionsNavHost")),
            ONBOARD_PAGE_TITLE = $(AppiumBy.xpath("//android.widget.TextView[@text='Allow Access to Phone and Call Parameters']")),
            ONBOARD_PAGE_SUBTITLE = $(AppiumBy.xpath("//android.widget.TextView[@text='This will prevent fraud and theft from your account. You can always change the access option in Settings.']")),
            CONTINUE_BUTTON = $(AppiumBy.xpath("//*[@resource-id='uds_button_title']")),
            NAVIGATION_BAR_TRAILING_ICON = $(AppiumBy.xpath("//*[@resource-id='uds_navigation_bar_trailing_icon']"));
    public static final SelenideElement
            TITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='Open Your Card Online']")),
            SUBTITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='Register in the application and become a bank client without visiting a branch.']")),
            NEXT_BUTTON = $(AppiumBy.xpath("//android.widget.TextView[@text='Next']"));

}