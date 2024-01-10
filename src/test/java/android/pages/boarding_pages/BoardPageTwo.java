package android.pages.boarding_pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class BoardPageTwo {
    public static final SelenideElement
            TITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='Easy Registration']")),
            SUBTITLE_TEXT = $(AppiumBy.xpath("//android.widget.TextView[@text='All you need is an ID card or foreign passport, Tax IN and Diia.Pidpys to confirm your data.']")),
            NEXT_BUTTON = $(AppiumBy.xpath("//android.widget.TextView[@text='Next']"));
}
