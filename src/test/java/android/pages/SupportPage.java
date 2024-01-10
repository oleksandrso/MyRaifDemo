package android.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SupportPage {
    public static final SelenideElement
            SUPPORT_NAV_HOST = $(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='ua.raiffeisen.myraif:id/supportNavHost']")),
            HEADLINE_GROUP = $(AppiumBy.xpath("//android.view.View[@resource-id='uds_headline_group_background']")),
            NEED_ANY_HELP_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='uds_headline_group_heading']")),
            WE_ARE_IN_TOUCH_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='uds_headline_group_text_caption']")),
            NAVIGATION_BAR_BACK_BUTTON = $(AppiumBy.xpath("//android.widget.Button[@content-desc=\"navigate back\"]"));
}
