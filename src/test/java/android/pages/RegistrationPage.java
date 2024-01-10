package android.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public static final SelenideElement
            PHONE_NUMBER_FIELD = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"uds_text_input_text\"]")),
            CONTINUE_BUTTON = $(AppiumBy.xpath("//android.widget.TextView[@text='Continue']"));


    public static void enterPhoneNumber(String number) {
        PHONE_NUMBER_FIELD.click();
        PHONE_NUMBER_FIELD.sendKeys(number);
    }
}
