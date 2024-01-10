package android.pages.boarding_pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class BoardPageThree {
    public static final SelenideElement
            TITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='Open Cards in This App']")),
            SUBTITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='Do basic operations in Raiffeisen Online.']")),
            REGISTER_BUTTON = $(AppiumBy.xpath("//android.widget.TextView[@text='Register']"));
}

